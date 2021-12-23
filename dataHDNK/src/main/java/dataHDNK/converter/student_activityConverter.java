package dataHDNK.converter;

import dataHDNK.dto.student_activityDTO;
import dataHDNK.entity.student_activityEntity;

public class student_activityConverter {
	public student_activityEntity toEntity(student_activityDTO dto) {
		student_activityEntity entity = new student_activityEntity();
		return entity;
	}

	public student_activityDTO toDTO(student_activityEntity entity) {
		student_activityDTO dto = new student_activityDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setCode(entity.getActivity().getCode());
		dto.setMsv(entity.getStudent().getMsv());
		return dto;

	}

	public student_activityEntity toEntity(student_activityDTO dto, student_activityEntity entity) {
		return entity;
	}
}
