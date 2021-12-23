package dataHDNK.dto;

import java.util.Date;

public class ActivityDTO extends BaseDTO {

	private String code;

	private String name;

	private String description;

	private int diem;

	private Date thoiGian;

	private Date HetHan;

	private int soLuong;

	private String diaDiem;

	private boolean active;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public Date getHetHan() {
		return HetHan;
	}

	public void setHetHan(Date hetHan) {
		HetHan = hetHan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
