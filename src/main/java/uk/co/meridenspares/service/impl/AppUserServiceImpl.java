package uk.co.meridenspares.service.impl;

import uk.co.meridenspares.domain.AppUser;
import uk.co.meridenspares.domain.validators.AppUserValidator;
import uk.co.meridenspares.persistence.api.AppUserPersistenceService;
import uk.co.meridenspares.service.api.AppUserService;

/**
 * This class defines the methods of the 'AppUser' service.
 * @author user
 *
 */
public class AppUserServiceImpl extends GenericServiceImpl<AppUser, Long> implements AppUserService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public AppUserServiceImpl(AppUserPersistenceService persistenceService, AppUserValidator validator) {
		super(persistenceService, validator);
	}

	
	
	public AppUser findByAppUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
