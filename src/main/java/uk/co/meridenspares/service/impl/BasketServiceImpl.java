package uk.co.meridenspares.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import uk.co.meridenspares.domain.Basket;
import uk.co.meridenspares.domain.BasketItem;
import uk.co.meridenspares.domain.SectionItem;
import uk.co.meridenspares.domain.StockItem;
import uk.co.meridenspares.domain.validators.BasketValidator;
import uk.co.meridenspares.persistence.api.BasketItemPersistenceService;
import uk.co.meridenspares.persistence.api.BasketPersistenceService;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.service.api.BasketService;
import uk.co.meridenspares.service.api.exception.MsServiceException;

/**
 * This class defines the methods of the 'Basket' service.
 * @author user
 *
 */
public class BasketServiceImpl extends GenericServiceImpl<Basket, Long> implements BasketService {

	private BasketItemPersistenceService basketItemPersistenceService;
	
	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public BasketServiceImpl(BasketPersistenceService persistenceService, BasketValidator validator,
			BasketItemPersistenceService basketItemPersistenceService) {
		super(persistenceService, validator);
		this.basketItemPersistenceService = basketItemPersistenceService;
	}
	
	@Transactional(rollbackFor=MsServiceException.class)
	public void add(Basket basket, StockItem stockItem, int quantity) throws MsServiceException {
		try {
			boolean itemInBasket = false;
			Basket bskt = persistenceService.find(basket.getId());
			Collection<BasketItem> items = bskt.getItems();
			
			for (BasketItem item : items) {
				if (item.getStockItem().getId().equals(stockItem.getId())) {
					item.addQuantity(quantity);				
					basketItemPersistenceService.update(item);
					itemInBasket = true;
					break;
				}
			}
			
			if (!itemInBasket) {
				BasketItem basketItem = new BasketItem();
				basketItem.setStockItem(stockItem);
				basketItem.addQuantity(quantity);
				basketItem.setBasket(bskt);
				BasketItem bi = basketItemPersistenceService.create(basketItem);
				bskt.getItems().add(bi);
				persistenceService.update(bskt);
			}
		}
		catch (Exception e) {
			String message = "Failed to add StockItem to Basket using [" + persistenceService.getClass().getName() + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	@Transactional(rollbackFor=MsServiceException.class)
	public void remove(Basket basket, StockItem stockItem, int quantity) throws MsServiceException {
		try {
			Basket bskt = persistenceService.find(basket.getId());
			Collection<BasketItem> basketItems = bskt.getItems();
			
			for (BasketItem basketItem : basketItems) {
				if (basketItem.getStockItem().getId().equals(stockItem.getId())) {
					basketItem.removeQuantity(quantity);
					
					if (basketItem.getQuantity() == 0) {
						bskt.getItems().remove(basketItem);
						persistenceService.update(bskt);
						basketItemPersistenceService.delete(basketItem);
					}
					else {
						basketItemPersistenceService.update(basketItem);
					}
					
					break;
				}
			}
		}
		catch (Exception e) {
			String message = "Failed to remove StockItem from Basket using [" + persistenceService.getClass().getName() + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	@Transactional(rollbackFor=MsServiceException.class)
	public void remove(Basket basket, BasketItem item, int quantity) throws MsServiceException {
		try {
			Basket bskt = persistenceService.find(basket.getId());
			Collection<BasketItem> basketItems = bskt.getItems();
			
			for (BasketItem basketItem : basketItems) {
				if (basketItem.getStockItem().getId().equals(item.getStockItem().getId())) {
					basketItem.removeQuantity(quantity);
					
					if (basketItem.getQuantity() == 0) {
						bskt.getItems().remove(basketItem);
						persistenceService.update(bskt);
						basketItemPersistenceService.delete(basketItem);
					}
					else {
						basketItemPersistenceService.update(basketItem);
					}
					
					break;
				}
			}
		}
		catch (Exception e) {
			String message = "Failed to remove StockItem from Basket using [" + persistenceService.getClass().getName() + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	@Transactional(readOnly=true)
	public List<BasketItem> getItems(Basket basket) {
		List<BasketItem> lst = new ArrayList<BasketItem>();
		
		try {
			Basket bskt = persistenceService.find(basket.getId());
			Collection<BasketItem> items = bskt.getItems();
			lst = new ArrayList<BasketItem>(items);
		}
		catch (PersistenceServiceException e) {

		}
		
		return lst;
	}

	@Transactional(readOnly=true)
	public int getBasketQuantity(Basket basket, StockItem item) {
		int quantity = 0;
		List<BasketItem> items = getItems(basket);
		
		for (BasketItem basketItem : items) {
			if (basketItem.getStockItem().getPartNumber().equals(item.getPartNumber())) {
				quantity = basketItem.getQuantity();
				break;
			}
		}

		return quantity;
	}

	@Transactional(readOnly=true)
	public int getBasketQuantity(Basket basket, SectionItem item) {
		int quantity = 0;
		List<BasketItem> items = getItems(basket);
		
		for (BasketItem basketItem : items) {
			if (basketItem.getStockItem() instanceof SectionItem &&
				basketItem.getStockItem().getPartNumber().equals(item.getPartNumber())) {
				quantity = basketItem.getQuantity();
				break;
			}
		}

		return quantity;
	}

}
