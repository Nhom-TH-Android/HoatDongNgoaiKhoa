package dataHDNK.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataHDNK.dto.ActivityDTO;
import dataHDNK.dto.StudentDTO;
import dataHDNK.dto.student_activityDTO;
import dataHDNK.service.impl.Student_ActivityService;

@RestController
public class student_activityAPI {
	@Autowired
	Student_ActivityService service;

	@PostMapping(value = "student_activity")
	public student_activityDTO save(@RequestBody student_activityDTO dto) {
		return service.save(dto);
	}
	@PostMapping(value = "student_activity/listActivityOfStudent")
	public List<ActivityDTO> getListActivityOfStudent(@RequestBody StudentDTO dto) {
		return service.getStudent_ActivityByMsv(dto);
	}
	
	@PostMapping(value = "student_activity/historyActivityOfStudent")
	public List<ActivityDTO> historyActivityOfStudent(@RequestBody StudentDTO dto) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
//		Date date=new Date("2021/12/15");
		String stringDate=dtf.format(now);
		Date date=new Date(stringDate);
		return service.getStudent_ActivityByMsvBeforeDate(dto, date);
	}
	
	@PostMapping(value = "student_activity/listActivityOfStudentFuture")
	public List<ActivityDTO> listActivityOfStudent(@RequestBody StudentDTO dto) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
//		Date date=new Date("2021/12/15");
		String stringDate=dtf.format(now);
		Date date=new Date(stringDate);
		return service.getStudent_ActivityByMsvAfterDate(dto, date);
	}
	
	@PostMapping(value = "student_activity/listStudentOfActivity")
	public Integer getListStudentOfActivity(@RequestBody ActivityDTO dto) {
		return service.getStudent_ActivityByCode(dto).size();
	}
	
	@PostMapping(value = "student_activity/check")
	public student_activityDTO check(@RequestBody student_activityDTO dto) {
		student_activityDTO stu_act= service.getStudent_Activity(dto);
		return stu_act;
	}
//	@GetMapping(value = "student_activity/msv")
//	public List<student_activityDTO> getStudent_ActivityByMsv(@RequestParam("msv") String msv) {
//		return service.getStudent_ActivityByMsv(msv);
//	}
//	@GetMapping(value = "student_activity/code")
//	public List<student_activityDTO> getStudent_ActivityByCode(@RequestParam("code") String code) {
//		return service.getStudent_ActivityByMsv(code);
//	}

	@GetMapping(value = "student_activity/list")
	public List<student_activityDTO> getAllStudent_Activity() {
		return service.getAllStudent_Activity();
	}

	@DeleteMapping(value = "student_activity")
	public void delete(@RequestParam("id") Long[] id) {
		service.delete(id);
	}

}
