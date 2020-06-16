package uk.co.meridenspares.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import uk.co.meridenspares.domain.validators.api.GenericDomainValidator;
import uk.co.meridenspares.persistence.api.GenericPersistenceService;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.service.api.GenericService;
import uk.co.meridenspares.service.api.exception.MsServiceException;

/**
 * This class defines the basic methods that will be provided by the MS domain object type services.
 * @author user
 *
 * @param <T>
 * @param <PK>
 */
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

	protected Logger log = Logger.getLogger(GenericServiceImpl.class);
	
	protected GenericPersistenceService<T, PK> persistenceService;
	
	private GenericDomainValidator<T> validator;
	
	/**
	 * Default constructor to allow frameworks to reflectively instantiate.
	 */
	public GenericServiceImpl() {
	}
	
	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public GenericServiceImpl(GenericPersistenceService<T, PK> persistenceService,
								GenericDomainValidator<T> validator) {
		Validate.notNull(persistenceService, "persistenceService cannot be null");
		Validate.notNull(validator, "validator cannot be null");
		this.persistenceService = persistenceService;
		this.validator = validator;
	}

	/**
	 * Returns instantiated type with given id.
	 * @param id
	 * @return Populated object or null if not in database
	 * @throws MsServiceException
	 */
	@Transactional(readOnly=true)
	public T find(PK id) throws MsServiceException {
		Validate.notNull(id, "id cannot be null");
		
		try {
			return persistenceService.find(id);
		}
		catch (PersistenceServiceException e) {
			String message = "Failed to get entity from [" + persistenceService.getClass().getName() + "] with ID [" + id + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	/**
	 * Returns all objects of instantiated type.
	 * @return List of instantiated objects
	 * @throws MsServiceException
	 */
	@Transactional(readOnly=true)
	public List<T> findAll() throws MsServiceException {
		try {
			return persistenceService.findAll();
		}
		catch (PersistenceServiceException e) {
			String message = "Failed to get all entities from [" + persistenceService.getClass().getName() + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	/**
	 * Adds a new instance of the instantiated type, effectively adding a new row in the database.
	 * @param object
	 * @return
	 * @throws MsServiceException
	 */
	@Transactional(rollbackFor=MsServiceException.class)
	public T save(T object) throws MsServiceException {
		Validate.notNull(object, "object cannot be null");
		
		try {
			validator.validate(object);
			return persistenceService.create(object);
		}
		catch (Exception e) {
			String message = "Failed to add entity using [" + persistenceService.getClass().getName() + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	/**
	 * Updates an existing database row.
	 * @param object
	 * @return
	 * @throws MsServiceException
	 */
	@Transactional(rollbackFor=MsServiceException.class)
	public T update(T object) throws MsServiceException {
		Validate.notNull(object, "object cannot be null");
		
		try {
			validator.validate(object);
			return persistenceService.update(object);
		}
		catch (Exception e) {
			String message = "Failed to update entity using [" + persistenceService.getClass().getName() + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	/**
	 * Removes a row from the database.
	 * @param object
	 * @throws MsServiceException
	 */
	@Transactional(rollbackFor=MsServiceException.class)
	public void remove(T object) throws MsServiceException {
		Validate.notNull(object, "object cannot be null");
		
		try {
			persistenceService.delete(object);
		}
		catch (PersistenceServiceException e) {
			String message = "Failed to remove entity using [" + persistenceService.getClass().getName() + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}
}
