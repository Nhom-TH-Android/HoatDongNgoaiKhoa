package dataHDNK.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="activity")
public class ActivityEntity extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "diem")
	private int diem;
	
	@Column(name = "thoiGian")
	private Date thoiGian;
	
	@Column(name = "hetHan")
	private Date HetHan;
	
	@Column(name = "soLuong")
	private int soLuong;
	
	@Column(name = "active")
	private boolean active;
	
	@ManyToMany(mappedBy = "activities")
	private List<StudentEntity> Students = new ArrayList<>();
	
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
