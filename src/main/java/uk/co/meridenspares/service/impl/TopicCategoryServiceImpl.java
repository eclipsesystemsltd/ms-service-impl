package uk.co.meridenspares.service.impl;

import java.util.List;

import uk.co.meridenspares.domain.TopicCategory;
import uk.co.meridenspares.domain.validators.TopicCategoryValidator;
import uk.co.meridenspares.persistence.api.TopicCategoryPersistenceService;
import uk.co.meridenspares.service.api.TopicCategoryService;

/**
 * This class defines the methods of the 'TopicCategory' service.
 * @author user
 *
 */
public class TopicCategoryServiceImpl extends GenericServiceImpl<TopicCategory, Long> implements TopicCategoryService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public TopicCategoryServiceImpl(TopicCategoryPersistenceService persistenceService, TopicCategoryValidator validator) {
		super(persistenceService, validator);
	}

	
	
	
	public List<TopicCategory> findAllParentCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TopicCategory> findAllSubCategory(String parentCategoryId) {
		// TODO Auto-generated method stub
		return null;
	}
}
