package dataHDNK.converter;

import org.springframework.stereotype.Component;

import dataHDNK.dto.StudentDTO;
import dataHDNK.entity.StudentEntity;

@Component
public class StudentConverter {

	public StudentEntity toEntity(StudentDTO dto) {
		StudentEntity entity = new StudentEntity();
		entity.setMsv(dto.getMsv());
		entity.setTen(dto.getTen());
		entity.setPassword(dto.getPassword());
		entity.setNgSinh(dto.getNgSinh());
		entity.setLop(dto.getLop());
		entity.setEmail(dto.getEmail());
		entity.setGioiTinh(dto.getGioiTinh());
		entity.setSDT(dto.getSDT());
		entity.setDiemHD(dto.getDiemHD());
		entity.setAvatar(dto.getAvatar());
		return entity;
	}

	public StudentDTO toDTO(StudentEntity entity) {
		StudentDTO dto = new StudentDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setMsv(entity.getMsv());
		dto.setTen(entity.getTen());
		dto.setPassword(entity.getPassword());
		dto.setNgSinh(entity.getNgSinh());
		dto.setLop(entity.getLop());
		dto.setEmail(entity.getEmail());
		dto.setGioiTinh(entity.getGioiTinh());
		dto.setSDT(entity.getSDT());
		dto.setDiemHD(entity.getDiemHD());
		dto.setAvatar(entity.getAvatar());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;

	}

	public StudentEntity toEntity(StudentDTO dto, StudentEntity entity) {
		entity.setMsv(dto.getMsv());
		entity.setTen(dto.getTen());
		entity.setPassword(dto.getPassword());
		entity.setNgSinh(dto.getNgSinh());
		entity.setLop(dto.getLop());
		entity.setEmail(dto.getEmail());
		entity.setGioiTinh(dto.getGioiTinh());
		entity.setSDT(dto.getSDT());
		entity.setDiemHD(dto.getDiemHD());
		entity.setAvatar(dto.getAvatar());
		return entity;

	}

}
