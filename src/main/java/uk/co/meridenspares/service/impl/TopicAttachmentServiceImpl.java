package uk.co.meridenspares.service.impl;

import uk.co.meridenspares.domain.TopicAttachment;
import uk.co.meridenspares.domain.validators.TopicAttachmentValidator;
import uk.co.meridenspares.persistence.api.TopicAttachmentPersistenceService;
import uk.co.meridenspares.service.api.TopicAttachmentService;

/**
 * This class defines the methods of the 'TopicAttachment' service.
 * @author user
 *
 */
public class TopicAttachmentServiceImpl extends GenericServiceImpl<TopicAttachment, Long> implements TopicAttachmentService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public TopicAttachmentServiceImpl(TopicAttachmentPersistenceService persistenceService, TopicAttachmentValidator validator) {
		super(persistenceService, validator);
	}
}
