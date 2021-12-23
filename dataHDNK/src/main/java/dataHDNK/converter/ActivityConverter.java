package dataHDNK.converter;

import dataHDNK.dto.ActivityDTO;
import dataHDNK.entity.ActivityEntity;

public class ActivityConverter {
	public ActivityEntity toEntity(ActivityDTO dto) {
		ActivityEntity entity = new ActivityEntity();
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
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setDiem(dto.getDiem());
		entity.setThoiGian(dto.getThoiGian());
		entity.setHetHan(dto.getHetHan());
		entity.setSoLuong(dto.getSoLuong());
		entity.setDiaDiem(dto.getDiaDiem());
		entity.setActive(dto.isActive());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;

	}

	public ActivityEntity toEntity(ActivityDTO dto, ActivityEntity entity) {
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
