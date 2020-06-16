package uk.co.meridenspares.service.impl;

import uk.co.meridenspares.domain.Role;
import uk.co.meridenspares.domain.validators.RoleValidator;
import uk.co.meridenspares.persistence.api.RolePersistenceService;
import uk.co.meridenspares.service.api.RoleService;

/**
 * This class defines the methods of the 'Role' service.
 * @author user
 *
 */
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public RoleServiceImpl(RolePersistenceService persistenceService, RoleValidator validator) {
		super(persistenceService, validator);
	}
}
