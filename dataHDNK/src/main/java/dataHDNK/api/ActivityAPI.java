package dataHDNK.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataHDNK.dto.ActivityDTO;
import dataHDNK.service.impl.ActivityService;

@RestController
public class ActivityAPI {
	@Autowired
	private ActivityService service;
	
	@PostMapping(value = "/activity")
	public ActivityDTO createActivity(@RequestBody ActivityDTO model) {
		return service.save(model);
	}
	
	
	@GetMapping(value = "/activity")
	public ActivityDTO getActivity(@RequestParam("code") String code) {
		return service.getActivity(code);
	}
	 
	@PutMapping(value = "/activity/{id}")
	public ActivityDTO updateActivity(@RequestBody ActivityDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return service.save(model);
	}
	@GetMapping(value = "/activity/list")
	public List<ActivityDTO> ListActivity() {
		return service.getAllActivity();
	}
	@GetMapping(value = "/activity/listInFuture")
	public List<ActivityDTO> ListActivityInFuture() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
//		Date date=new Date("2021/12/15");
		String stringDate=dtf.format(now);
		Date date=new Date(stringDate);
		return service.getAllActivity(date);
	}
}
