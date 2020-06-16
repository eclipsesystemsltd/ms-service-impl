package uk.co.meridenspares.service.impl;

import uk.co.meridenspares.domain.Section;
import uk.co.meridenspares.domain.validators.SectionValidator;
import uk.co.meridenspares.persistence.api.SectionPersistenceService;
import uk.co.meridenspares.service.api.SectionService;

/**
 * This class defines the methods of the 'Section' service.
 * @author user
 *
 */
public class SectionServiceImpl extends GenericServiceImpl<Section, Long> implements SectionService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public SectionServiceImpl(SectionPersistenceService persistenceService, SectionValidator validator) {
		super(persistenceService, validator);
	}
}
