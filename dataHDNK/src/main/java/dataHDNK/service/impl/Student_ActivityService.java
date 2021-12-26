package dataHDNK.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataHDNK.converter.ActivityConverter;
import dataHDNK.converter.StudentConverter;
import dataHDNK.converter.student_activityConverter;
import dataHDNK.dto.ActivityDTO;
import dataHDNK.dto.StudentDTO;
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
	StudentConverter studentConverter;
	@Autowired
	ActivityConverter activityConverter;
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
//		listEntity = repository.findOneByStudent(studentEntity);
//		for (student_activityEntity entity : listEntity) {
//			listDTO.add(converter.toDTO(entity));
//		}
//		return listDTO;
////		return null;
//	}
//
//	@Override
//	public student_activityDTO getStudent_Activity(String code, String msv) {
//		StudentEntity studentEntity=studentRepository.findOneByMsv(msv);
//		ActivityEntity activityEntity=activityRepository.findOneByCode(code);
//		student_activityEntity stu_actEntity=repository.findOneByStudent_idActivity_Id(msv, code);
//		return converter.toDTO(stu_actEntity);
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

	@Override
	public student_activityDTO getStudent_Activity(student_activityDTO dto) {
////		StudentEntity studentEntity = studentRepository.findOneByMsv(dto.getStudent_id());
////		ActivityEntity activityEntity = activityRepository.findOneByCode(dto.getActivity_id());
////		Long activity_id=activityEntity.getId();
////		Long student_id=studentEntity.getId();
////		student_activityEntity stu_act = null;
////		stu_act.setActivity(activityEntity);
////		stu_act.setStudent(studentEntity);
		Long student_id = studentRepository.findOneByMsv(dto.getStudent_id()).getId();
		Long activity_id = activityRepository.findOneByCode(dto.getActivity_id()).getId();
		student_activityEntity stu_actEntity;
		stu_actEntity=repository.findByActivity_IdAndStudent_Id(activity_id, student_id);
		return converter.toDTO(stu_actEntity);
//		return null;
	}

	@Override
	public List<ActivityDTO> getStudent_ActivityByMsv(StudentDTO student) {
		StudentEntity studentEntity = studentRepository.findOneByMsv(student.getMsv());
		List<student_activityEntity> listEntities=repository.findOneByStudent(studentEntity);
		List<ActivityDTO> listDTO = new ArrayList<>();
		for (student_activityEntity entity : listEntities) {
			ActivityEntity activityEntity=new ActivityEntity();
			activityEntity= activityRepository.findOneByCode(entity.getActivity().getCode());
			listDTO.add(activityConverter.toDTO(activityEntity));
		}
		return listDTO;
	}

	@Override
	public List<StudentDTO> getStudent_ActivityByCode(ActivityDTO activity) {
		ActivityEntity activityEntity = activityRepository.findOneByCode(activity.getCode());
		List<student_activityEntity> listEntities = repository.findOneByActivity(activityEntity);
		List<StudentDTO> listDTO = new ArrayList<>();
		for (student_activityEntity entity : listEntities) {
			StudentEntity studentEntity=new StudentEntity();
			studentEntity=studentRepository.findOneByMsv(entity.getStudent().getMsv());
			listDTO.add(studentConverter.toDTO(studentEntity));
		}
		return listDTO;
	}

	@Override
	public List<ActivityDTO> getStudent_ActivityByMsvBeforeDate(StudentDTO student, Date date) {
		StudentEntity studentEntity = studentRepository.findOneByMsv(student.getMsv());
		List<student_activityEntity> listEntities=repository.findOneByStudent(studentEntity);
		List<ActivityDTO> listDTO = new ArrayList<>();
		for (student_activityEntity entity : listEntities) {
			ActivityEntity activityEntity=new ActivityEntity();
			activityEntity= activityRepository.findOneByCode(entity.getActivity().getCode());
//			Date dateTest=new Date("2021/12/14");
			if(activityEntity.getThoiGian().compareTo(date)<0) {
				listDTO.add(activityConverter.toDTO(activityEntity));
			}
		}
		return listDTO;
//		return null;
	}

	@Override
	public List<ActivityDTO> getStudent_ActivityByMsvAfterDate(StudentDTO student, Date date) {
		StudentEntity studentEntity = studentRepository.findOneByMsv(student.getMsv());
		List<student_activityEntity> listEntities=repository.findOneByStudent(studentEntity);
		List<ActivityDTO> listDTO = new ArrayList<>();
		for (student_activityEntity entity : listEntities) {
			ActivityEntity activityEntity=new ActivityEntity();
			activityEntity= activityRepository.findOneByCode(entity.getActivity().getCode());
//			Date dateTest=new Date("2021/12/14");
			if(activityEntity.getThoiGian().compareTo(date)>=0) {
				listDTO.add(activityConverter.toDTO(activityEntity));
			}
		}
		return listDTO;
	}

}
