package dataHDNK.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "student")
public class StudentEntity extends BaseEntity {

	@Column(name = "msv")
	private String msv;

	@Column(name = "password")
	private String password;

	@Column(name = "ten")
	private String ten;

	@Column(name = "lop")
	private String lop;

	@Column(name = "ngSinh")
	@JsonFormat(pattern="yyyy-MM-dd", shape=Shape.STRING)
	private Date NgSinh;

	@Column(name = "email")
	private String email;

	@Column(name = "gioiTinh")
	private String GioiTinh;

	@Column(name = "sdt")
	private String SDT;

	@Column(name = "diemHD")
	private int diemHD;

	@Column(name = "avatar")
	private String avatar;

//	@ManyToMany
//	@JoinTable(name = "student_activity", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "activity_id"))
//	private List<ActivityEntity> activities = new ArrayList<>();

	@OneToMany(mappedBy = "student")
	private List<NotificationEntity> notifications = new ArrayList<>();

	@OneToMany(mappedBy = "student")
	private List<student_activityEntity> students_activities = new ArrayList<>();

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public Date getNgSinh() {
		return NgSinh;
	}

	public void setNgSinh(Date ngSinh) {
		NgSinh = ngSinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public int getDiemHD() {
		return diemHD;
	}

	public void setDiemHD(int diemHD) {
		this.diemHD = diemHD;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMsv() {
		return msv;
	}

	public void setMsv(String msv) {
		this.msv = msv;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<student_activityEntity> getStudents_activities() {
		return students_activities;
	}

	public void setStudents_activities(List<student_activityEntity> students_activities) {
		this.students_activities = students_activities;
	}

	public List<NotificationEntity> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<NotificationEntity> notifications) {
		this.notifications = notifications;
	}

}
