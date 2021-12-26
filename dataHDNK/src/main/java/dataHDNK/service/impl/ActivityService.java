package dataHDNK.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataHDNK.converter.ActivityConverter;
import dataHDNK.dto.ActivityDTO;
import dataHDNK.dto.StudentDTO;
import dataHDNK.entity.ActivityEntity;
import dataHDNK.entity.StudentEntity;
import dataHDNK.repository.ActitvityRepository;
import dataHDNK.service.IActivityService;

@Service
public class ActivityService implements IActivityService {
	
	@Autowired
	private ActitvityRepository repository;

	@Autowired
	private ActivityConverter converter;
	
	@Override
	public ActivityDTO save(ActivityDTO model) {
		ActivityEntity entity; 
		if (model.getId() == null) {
			entity = new ActivityEntity();
			entity = converter.toEntity(model);
		} else {
			ActivityEntity oldEntity = repository.findOne(model.getId()); // lấy entity cũ
			entity = converter.toEntity(model, oldEntity); // cập nhật entity
		}
		repository.save(entity);
		return converter.toDTO(entity);
	}

	@Override
	public ActivityDTO getActivity(String code) {
		ActivityEntity entity;
		entity = repository.findOneByCode(code);
		return converter.toDTO(entity);
	}

	@Override
	public List<ActivityDTO> getAllActivity() {
		List<ActivityEntity> listEntity = new ArrayList<>();
		List<ActivityDTO> listDTO = new ArrayList<>();
		listEntity = repository.findAll();
		for (ActivityEntity entity : listEntity) {
			listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}

	@Override
	public List<ActivityDTO> getAllActivity(Date date) {
		List<ActivityEntity> listEntity = new ArrayList<>();
		List<ActivityDTO> listDTO = new ArrayList<>();
		listEntity = repository.findByThoiGianGreaterThan(date);
		for (ActivityEntity entity : listEntity) {
			listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}

}
