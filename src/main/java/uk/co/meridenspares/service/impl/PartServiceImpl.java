package uk.co.meridenspares.service.impl;

import uk.co.meridenspares.domain.Part;
import uk.co.meridenspares.domain.validators.PartValidator;
import uk.co.meridenspares.persistence.api.PartPersistenceService;
import uk.co.meridenspares.service.api.PartService;

/**
 * This class defines the methods of the 'Part' service.
 * @author user
 *
 */
public class PartServiceImpl extends GenericServiceImpl<Part, Long> implements PartService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public PartServiceImpl(PartPersistenceService persistenceService, PartValidator validator) {
		super(persistenceService, validator);
	}
}
