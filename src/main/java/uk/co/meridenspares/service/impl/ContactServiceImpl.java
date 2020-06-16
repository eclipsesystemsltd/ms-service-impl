package uk.co.meridenspares.service.impl;

import uk.co.meridenspares.domain.Contact;
import uk.co.meridenspares.domain.validators.ContactValidator;
import uk.co.meridenspares.persistence.api.ContactPersistenceService;
import uk.co.meridenspares.service.api.ContactService;

/**
 * This class defines the methods of the 'Contact' service.
 * @author user
 *
 */
public class ContactServiceImpl extends GenericServiceImpl<Contact, Long> implements ContactService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public ContactServiceImpl(ContactPersistenceService persistenceService, ContactValidator validator) {
		super(persistenceService, validator);
	}

	public Contact findByContactName(String contactName) {
		// TODO Auto-generated method stub
		return null;
	}
}
