package dataHDNK.service;

import java.util.Date;
import java.util.List;

import dataHDNK.dto.ActivityDTO;
import dataHDNK.dto.StudentDTO;
import dataHDNK.dto.student_activityDTO;

public interface IStudent_ActivityService {
	student_activityDTO save(student_activityDTO model);
	List<ActivityDTO> getStudent_ActivityByMsv(StudentDTO student);
	List<ActivityDTO> getStudent_ActivityByMsvBeforeDate(StudentDTO student, Date date);
	List<ActivityDTO> getStudent_ActivityByMsvAfterDate(StudentDTO student, Date date);
	List<StudentDTO> getStudent_ActivityByCode(ActivityDTO activity);
	student_activityDTO getStudent_Activity(student_activityDTO stu_act);
	List<student_activityDTO> getAllStudent_Activity();
	void delete(Long[] ids);
}
