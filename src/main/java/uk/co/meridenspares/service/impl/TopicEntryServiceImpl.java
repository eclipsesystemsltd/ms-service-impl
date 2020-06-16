package uk.co.meridenspares.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uk.co.meridenspares.domain.SearchCriteria;
import uk.co.meridenspares.domain.TopicEntry;
import uk.co.meridenspares.domain.validators.TopicEntryValidator;
import uk.co.meridenspares.persistence.api.TopicEntryPersistenceService;
import uk.co.meridenspares.service.api.TopicEntryService;

/**
 * This class defines the methods of the 'TopicEntry' service.
 * @author user
 *
 */
public class TopicEntryServiceImpl extends GenericServiceImpl<TopicEntry, Long> implements TopicEntryService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public TopicEntryServiceImpl(TopicEntryPersistenceService persistenceService, TopicEntryValidator validator) {
		super(persistenceService, validator);
	}

	
	
	
	public List<TopicEntry> findByCategoryId(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(TopicEntry entry) {
		// TODO Auto-generated method stub
		
	}

	public Page<TopicEntry> findAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<TopicEntry> findEntryByCriteria(SearchCriteria searchCriteria,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
