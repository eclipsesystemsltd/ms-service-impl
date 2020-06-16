package uk.co.meridenspares.service.impl;

import java.util.List;

import uk.co.meridenspares.domain.Customer;
import uk.co.meridenspares.domain.validators.CustomerValidator;
import uk.co.meridenspares.persistence.api.CustomerPersistenceService;
import uk.co.meridenspares.service.api.CustomerService;

/**
 * This class defines the methods of the 'Customer' service.
 * @author user
 *
 */
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public CustomerServiceImpl(CustomerPersistenceService persistenceService, CustomerValidator validator) {
		super(persistenceService, validator);
	}

	public List<Customer> getCustomerByEmail(String email) {
		return ((CustomerPersistenceService) persistenceService).getCustomerByEmail(email);
	}
}
