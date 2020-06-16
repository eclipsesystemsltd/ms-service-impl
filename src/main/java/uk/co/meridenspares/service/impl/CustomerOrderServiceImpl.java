package uk.co.meridenspares.service.impl;

import uk.co.meridenspares.domain.CustomerOrder;
import uk.co.meridenspares.domain.validators.CustomerOrderValidator;
import uk.co.meridenspares.persistence.api.CustomerOrderPersistenceService;
import uk.co.meridenspares.service.api.CustomerOrderService;

/**
 * This class defines the methods of the 'CustomerOrder' service.
 * @author user
 *
 */
public class CustomerOrderServiceImpl extends GenericServiceImpl<CustomerOrder, Long> implements CustomerOrderService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public CustomerOrderServiceImpl(CustomerOrderPersistenceService persistenceService, CustomerOrderValidator validator) {
		super(persistenceService, validator);
	}
}
