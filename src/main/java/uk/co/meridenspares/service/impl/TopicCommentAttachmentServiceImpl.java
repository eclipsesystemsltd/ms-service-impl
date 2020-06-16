package uk.co.meridenspares.service.impl;

import uk.co.meridenspares.domain.TopicCommentAttachment;
import uk.co.meridenspares.domain.validators.TopicCommentAttachmentValidator;
import uk.co.meridenspares.persistence.api.TopicCommentAttachmentPersistenceService;
import uk.co.meridenspares.service.api.TopicCommentAttachmentService;

/**
 * This class defines the methods of the 'TopicCommentAttachment' service.
 * @author user
 *
 */
public class TopicCommentAttachmentServiceImpl extends GenericServiceImpl<TopicCommentAttachment, Long> implements TopicCommentAttachmentService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public TopicCommentAttachmentServiceImpl(TopicCommentAttachmentPersistenceService persistenceService, TopicCommentAttachmentValidator validator) {
		super(persistenceService, validator);
	}
}
