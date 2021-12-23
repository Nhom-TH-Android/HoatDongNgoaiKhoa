package dataHDNK.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataHDNK.converter.student_activityConverter;
import dataHDNK.dto.student_activityDTO;
import dataHDNK.entity.ActivityEntity;
import dataHDNK.entity.StudentEntity;
import dataHDNK.entity.student_activityEntity;
import dataHDNK.repository.ActitvityRepository;
import dataHDNK.repository.StudentRepository;
import dataHDNK.repository.student_activityRepository;
import dataHDNK.service.IStudent_ActivityService;

@Service
public class Student_ActivityService implements IStudent_ActivityService {

	@Autowired
	student_activityRepository repository;
	@Autowired
	student_activityConverter converter;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	ActitvityRepository activityRepository;

	@Override
	public student_activityDTO save(student_activityDTO model) {
		student_activityEntity entity;
		StudentEntity studentEntity = studentRepository.findOneByMsv(model.getStudent_id());
		ActivityEntity activityEntity = activityRepository.findOneByCode(model.getActivity_id());
		if (model.getId() == null) {
			entity = new student_activityEntity();
			entity = converter.toEntity(model);
		} else {
			student_activityEntity oldEntity = repository.findOne(model.getId()); // lấy entity cũ
			entity = converter.toEntity(model, oldEntity); // cập nhật entity
		}
		entity.setStudent(studentEntity);
		entity.setActivity(activityEntity);
		repository.save(entity);
		return converter.toDTO(entity);
	}

//	@Override
//	public List<student_activityDTO> getStudent_ActivityByMsv(String msv) {
//		StudentEntity studentEntity=studentRepository.findOneByMsv(msv);
//		List<student_activityEntity> listEntity = new ArrayList<>();
//		List<student_activityDTO> listDTO = new ArrayList<>();
//		listEntity = repository.findOneByMsv(studentEntity);
//		for (student_activityEntity entity : listEntity) {
//			listDTO.add(converter.toDTO(entity));
//		}
//		return listDTO;
////		return null;
//	}
//
//	@Override
//	public List<student_activityDTO> getStudent_ActivityByCode(String code) {
//		ActivityEntity activityEntity = activityRepository.findOneByCode(code);
//		List<student_activityEntity> listEntity = new ArrayList<>();
//		List<student_activityDTO> listDTO = new ArrayList<>();
//		listEntity = repository.findOneByCode(activityEntity);
//		for (student_activityEntity entity : listEntity) {
//			listDTO.add(converter.toDTO(entity));
//		}
//		return listDTO;
////		return null;
//	}

//	@Override
//	public student_activityDTO getStudent_Activity(String msv, String code) {
//		student_activityEntity entity;
//		entity = repository.findOneByKey(code, msv);
//		return converter.toDTO(entity);
//	}

	@Override
	public List<student_activityDTO> getAllStudent_Activity() {
		List<student_activityEntity> listEntity = new ArrayList<>();
		List<student_activityDTO> listDTO = new ArrayList<>();
		listEntity = repository.findAll();
		for (student_activityEntity entity : listEntity) {
			listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}

	@Override
	public void delete(Long[] ids) {
		for (Long item : ids) {
			repository.delete(item);
		}
	}

}
