package uk.co.meridenspares.service.impl;

import uk.co.meridenspares.domain.TopicEntryAttachment;
import uk.co.meridenspares.domain.validators.TopicEntryAttachmentValidator;
import uk.co.meridenspares.persistence.api.TopicEntryAttachmentPersistenceService;
import uk.co.meridenspares.service.api.TopicEntryAttachmentService;

/**
 * This class defines the methods of the 'TopicEntryAttachment' service.
 * @author user
 *
 */
public class TopicEntryAttachmentServiceImpl extends GenericServiceImpl<TopicEntryAttachment, Long> implements TopicEntryAttachmentService {

	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public TopicEntryAttachmentServiceImpl(TopicEntryAttachmentPersistenceService persistenceService, TopicEntryAttachmentValidator validator) {
		super(persistenceService, validator);
	}
}
