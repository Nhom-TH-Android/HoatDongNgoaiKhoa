package dataHDNK.service;

import java.util.List;

import dataHDNK.dto.StudentDTO;

public interface IStudentService {
	StudentDTO save(StudentDTO model);
	StudentDTO getStudent(String msv);
	List<StudentDTO> getAllStudent();
}
