package dataHDNK.service;

import java.util.Date;
import java.util.List;

import dataHDNK.dto.ActivityDTO;

public interface IActivityService {
	ActivityDTO save(ActivityDTO model);
	ActivityDTO getActivity(String code);
	List<ActivityDTO> getAllActivity();
	List<ActivityDTO> getAllActivity(Date date);
}
