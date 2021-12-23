package dataHDNK.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
