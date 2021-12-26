package com.android.hoatdongngoaikhoa.Class;

import java.io.Serializable;

public class Student implements Serializable {
    private Long id;

    private String msv;

    private String password;

    private String ten;

    private String lop;

    private String ngSinh;

    private String email;

    private String GioiTinh;

    private String sdt;

    private int diemHD;

    private String avatar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNgSinh() {
        return ngSinh;
    }

    public void setNgSinh(String ngSinh) {
        this.ngSinh = ngSinh;
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
        return sdt;
    }

    public void setSDT(String SDT) {
        this.sdt = SDT;
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
