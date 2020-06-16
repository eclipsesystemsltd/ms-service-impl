package uk.co.meridenspares.service.impl;

import java.util.List;

import uk.co.meridenspares.domain.Customer;
import uk.co.meridenspares.service.api.AuthenticationService;
import uk.co.meridenspares.service.api.CustomerService;

/**
 * This class defines the methods of the 'Authentication' service.
 * @author user
 *
 */
public class AuthenticationServiceImpl implements AuthenticationService {

	private CustomerService customerService;
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public AuthenticationServiceImpl(CustomerService persistenceService) {
		this.customerService = persistenceService;
	}

	public boolean login(String username, String password) {
		boolean loggedIn = false;
		
		List<Customer> customers = customerService.getCustomerByEmail(username);
		
		if (customers.size() == 1 && customers.get(0).getPassword().equals(password)) {
			loggedIn = true;
		}
		
		return loggedIn;
	}
}
