package com.kh.studentScoreManagement.model;

public class TraineeVO {
	 private int traNo;                  //-- 수강번호(PK)
	 private int stuNo;                  //-- 학번(FK)
	 private int subNo;                  //-- 과목코드(FK)
	
	 public TraineeVO() {
		
	}

	public TraineeVO(int traNo, int stuNo, int subNo) {
		super();
		this.traNo = traNo;
		this.stuNo = stuNo;
		this.subNo = subNo;
	}

	public int getTraNo() {
		return traNo;
	}

	public void setTraNo(int traNo) {
		this.traNo = traNo;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public int getSubNo() {
		return subNo;
	}

	public void setSubNo(int subNo) {
		this.subNo = subNo;
	}

	@Override
	public String toString() {
		return "[traNo=" + traNo + ", stuNo=" + stuNo + ", subNo=" + subNo + "]";
	}
	 
	 
	 
}
