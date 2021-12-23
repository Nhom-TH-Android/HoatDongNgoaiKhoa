package dataHDNK.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataHDNK.dto.StudentDTO;
import dataHDNK.service.impl.StudentService;

@RestController
public class StudentAPI {
	@Autowired
	private StudentService service;
	
	@PostMapping(value = "/student/register")
	public StudentDTO createStudent(@RequestBody StudentDTO model) {
		return service.save(model);
	}
	
	@PostMapping(value = "/student/login")
	public StudentDTO getStudent(@RequestBody StudentDTO student) {
		StudentDTO studentlogin=service.getStudent(student.getMsv());
		if (student==null || !new BCryptPasswordEncoder().matches(student.getPassword(), studentlogin.getPassword())) {
			return null;
        }
		return service.getStudent(studentlogin.getMsv());
	}
	
	@GetMapping(value = "/student")
	public String getStudent(@RequestParam("msv") String msv) {
		return service.getStudent(msv).getMsv();
	}
	 
	@PutMapping(value = "/student/{id}")
	public StudentDTO updateStudent(@RequestBody StudentDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return service.save(model);
	}
	@GetMapping(value = "/student/list")
	public List<StudentDTO> ListStudent() {
		return service.getAllStudent();
	}
}
