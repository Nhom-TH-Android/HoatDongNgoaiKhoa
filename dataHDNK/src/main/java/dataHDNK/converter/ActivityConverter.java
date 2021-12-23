package dataHDNK.converter;

import org.springframework.stereotype.Component;

import dataHDNK.dto.ActivityDTO;
import dataHDNK.entity.ActivityEntity;

@Component
public class ActivityConverter {
	public ActivityEntity toEntity(ActivityDTO dto) {
		ActivityEntity entity = new ActivityEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setDiem(dto.getDiem());
		entity.setThoiGian(dto.getThoiGian());
		entity.setHetHan(dto.getHetHan());
		entity.setSoLuong(dto.getSoLuong());
		entity.setDiaDiem(dto.getDiaDiem());
		entity.setActive(dto.isActive());
		return entity;
	}

	public ActivityDTO toDTO(ActivityEntity entity) {
		ActivityDTO dto = new ActivityDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setDiem(entity.getDiem());
		dto.setThoiGian(entity.getThoiGian());
		dto.setHetHan(entity.getHetHan());
		dto.setSoLuong(entity.getSoLuong());
		dto.setDiaDiem(entity.getDiaDiem());
		dto.setActive(entity.isActive());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;

	}

	public ActivityEntity toEntity(ActivityDTO dto, ActivityEntity entity) {
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setDiem(dto.getDiem());
		entity.setThoiGian(dto.getThoiGian());
		entity.setHetHan(dto.getHetHan());
		entity.setSoLuong(dto.getSoLuong());
		entity.setDiaDiem(dto.getDiaDiem());
		entity.setActive(dto.isActive());
		return entity;

	}
}
