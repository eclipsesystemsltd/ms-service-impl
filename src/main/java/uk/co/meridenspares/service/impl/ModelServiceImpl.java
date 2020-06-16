package uk.co.meridenspares.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import uk.co.meridenspares.domain.Model;
import uk.co.meridenspares.domain.ModelRange;
import uk.co.meridenspares.domain.Section;
import uk.co.meridenspares.domain.validators.ModelValidator;
import uk.co.meridenspares.persistence.api.ModelPersistenceService;
import uk.co.meridenspares.persistence.api.ModelRangePersistenceService;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.service.api.ModelService;
import uk.co.meridenspares.service.api.exception.MsServiceException;

/**
 * This class defines the methods of the 'Model' service.
 * @author user
 *
 */
public class ModelServiceImpl extends GenericServiceImpl<Model, Long> implements ModelService {

	private ModelRangePersistenceService modelRangePersistenceService;
	
	/**
	 * Constructor.
	 * @param persistenceService
	 * @param validator
	 */
	public ModelServiceImpl(ModelPersistenceService persistenceService, ModelValidator validator,
											ModelRangePersistenceService modelRangePersistenceService) {
		super(persistenceService, validator);
		this.modelRangePersistenceService = modelRangePersistenceService;
	}

	@Transactional(readOnly=true)
	public List<Model> getModelsForYear(int year) throws MsServiceException {
		try {
			return ((ModelPersistenceService) persistenceService).getModelsForYear(year);
		}
		catch (PersistenceServiceException e) {
			String message = "Failed to get models for year [" + year + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	@Transactional(readOnly=true)
	public List<Integer> getModelYears() throws MsServiceException {
		try {
			return ((ModelPersistenceService) persistenceService).getModelYears();
		}
		catch (PersistenceServiceException e) {
			String message = "Failed to get model years";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	@Transactional(readOnly=true)
	public List<ModelRange> getModelRanges() throws MsServiceException {
		try {
			return modelRangePersistenceService.findAll();
		}
		catch (PersistenceServiceException e) {
			String message = "Failed to find model ranges";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	@Transactional(readOnly=true)
	public List<Integer> getModelYears(ModelRange modelRange) throws MsServiceException {
		try {
			return modelRangePersistenceService.getModelRangeYears(modelRange);
		}
		catch (PersistenceServiceException e) {
			String message = "Failed to get model range years for [" + modelRange.getName() + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	@Transactional(readOnly=true)
	public List<Section> getSections(Model model) throws MsServiceException {
		try {
			return ((ModelPersistenceService) persistenceService).getSections(model);
		}
		catch (PersistenceServiceException e) {
			String message = "Failed to get sections for model [" + model.getName() + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	public ModelRange findModelRangeByName(String modelRange) throws MsServiceException {
		try {
			return modelRangePersistenceService.findByName(modelRange);
		}
		catch (PersistenceServiceException e) {
			String message = "Failed to find model range with name [" + modelRange + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}

	public Model findModelByName(String model, int year) throws MsServiceException {
		try {
			return ((ModelPersistenceService) persistenceService).findModelByName(model, year);
		}
		catch (PersistenceServiceException e) {
			String message = "Failed to find model with name [" + model + "] for year [" + year + "]";
			log.warn(message);
			throw new MsServiceException(message, e);
		}
	}
}
