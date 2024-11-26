package com.kh.studentScoreManagement.model;

import java.sql.Date;

public class StudentVO {
	private int no;                  //-- 학번(PK)
    private String name;	        	//-- 이름
    private String email; 		        //-- 이메일
    private String address;		        //-- 주소
    private String phone; 		        //-- 전화번호
    private Date regdate;              //-- 등록일
	
    public StudentVO() {
    	
    }

	public StudentVO(int no, String name, String email, String address, String phone, Date regdate) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.regdate = regdate;
	}

	public StudentVO(int no, String name, String email, String address, String phone) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "StudentVO [no=" + no + ", name=" + name + ", email=" + email + ", address=" + address + ", phone="
				+ phone + ", regdate=" + regdate + "]";
	}

	
    
}
