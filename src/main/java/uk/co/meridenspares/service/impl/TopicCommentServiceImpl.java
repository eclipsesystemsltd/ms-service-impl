package uk.co.meridenspares.service.impl;

import java.util.List;

import uk.co.meridenspares.domain.TopicComment;
import uk.co.meridenspares.domain.validators.TopicCommentValidator;
import uk.co.meridenspares.persistence.api.TopicCommentPersistenceService;
import uk.co.meridenspares.service.api.TopicCommentService;

/**
 * This class defines the methods of the 'TopicComment' service.
 * @author user
 *
 */
public class TopicCommentServiceImpl extends GenericServiceImpl<TopicComment, Long> implements TopicCommentService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public TopicCommentServiceImpl(TopicCommentPersistenceService persistenceService, TopicCommentValidator validator) {
		super(persistenceService, validator);
	}

	
	
	public void delete(TopicComment comment) {
		// TODO Auto-generated method stub
		
	}

	public List<TopicComment> findByEntryId(Long entryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> findReplyToByEntryId(Long entryId) {
		// TODO Auto-generated method stub
		return null;
	}
}
