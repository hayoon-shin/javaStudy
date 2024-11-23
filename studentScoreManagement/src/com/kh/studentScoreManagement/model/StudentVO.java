package com.kh.studentScoreManagement.model;

import java.sql.Date;

public class StudentVO {
	private int stuNo;                  //-- 학번(PK)
    private String stuName;	        	//-- 이름
    private String email; 		        //-- 이메일
    private String address;		        //-- 주소
    private String phone; 		        //-- 전화번호
    private Date reg_date;              //-- 등록일
	
    public StudentVO() {
    	
    }

	public StudentVO(int stuNo, String stuName, String email, String address, String phone, Date reg_date) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.reg_date = reg_date;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "[stuNo=" + stuNo + ", stuName=" + stuName + ", email=" + email + ", address=" + address
				+ ", phone=" + phone + ", reg_date=" + reg_date + "]";
	}
    
    
}
