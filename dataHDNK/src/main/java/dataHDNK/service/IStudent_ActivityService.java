package dataHDNK.service;

import java.util.List;

import dataHDNK.dto.student_activityDTO;

public interface IStudent_ActivityService {
	student_activityDTO save(student_activityDTO model);
//	List<student_activityDTO> getStudent_ActivityByMsv(String msv);
//	List<student_activityDTO> getStudent_ActivityByCode(String code);
//	student_activityDTO getStudent_Activity(String msv, String code);
	List<student_activityDTO> getAllStudent_Activity();
	void delete(Long[] ids);
}
