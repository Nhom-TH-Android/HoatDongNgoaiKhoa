package dataHDNK.dto;

import java.util.Date;

public class StudentDTO extends BaseDTO {

	private String msv;

	private String password;

	private String ten;

	private String lop;

	private Date NgSinh;

	private String email;

	private String GioiTinh;

	private String SDT;

	private int diemHD;

	private String avatar;

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

}
