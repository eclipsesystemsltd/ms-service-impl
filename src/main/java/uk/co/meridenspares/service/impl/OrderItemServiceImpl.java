package uk.co.meridenspares.service.impl;

import uk.co.meridenspares.domain.OrderItem;
import uk.co.meridenspares.domain.validators.OrderItemValidator;
import uk.co.meridenspares.persistence.api.OrderItemPersistenceService;
import uk.co.meridenspares.service.api.OrderItemService;

/**
 * This class defines the methods of the 'OrderItem' service.
 * @author user
 *
 */
public class OrderItemServiceImpl extends GenericServiceImpl<OrderItem, Long> implements OrderItemService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public OrderItemServiceImpl(OrderItemPersistenceService persistenceService, OrderItemValidator validator) {
		super(persistenceService, validator);
	}
}
