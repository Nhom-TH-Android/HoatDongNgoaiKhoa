package dataHDNK.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dataHDNK.converter.StudentConverter;
import dataHDNK.dto.StudentDTO;
import dataHDNK.entity.StudentEntity;
import dataHDNK.repository.StudentRepository;
import dataHDNK.service.IStudentService;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository repository;

	@Autowired
	private StudentConverter converter;

	PasswordEncoder passwordEncoder;

	@Override
	public StudentDTO save(StudentDTO model) {
		StudentEntity entity;
		if (model.getId() == null) {
			entity = new StudentEntity();
			entity = converter.toEntity(model);
		} else {
			StudentEntity oldEntity = repository.findOne(model.getId()); // lấy entity cũ
			entity = converter.toEntity(model, oldEntity); // cập nhật entity
		}
		passwordEncoder = new BCryptPasswordEncoder();
		String encoderPassword = passwordEncoder.encode(entity.getPassword());
		entity.setPassword(encoderPassword);
		repository.save(entity);
		return converter.toDTO(entity);
	}

	@Override
	public StudentDTO getStudent(String msv) {
		StudentEntity entity;
		entity = repository.findOneByMsv(msv);
		return converter.toDTO(entity);
	}

	@Override
	public List<StudentDTO> getAllStudent() {
		List<StudentEntity> listEntity = new ArrayList<>();
		List<StudentDTO> listDTO = new ArrayList<>();
		listEntity = repository.findAll();
		for (StudentEntity entity : listEntity) {
			listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}

}
