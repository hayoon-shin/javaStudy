package com.kh.studentScoreManagement.model;

public class TraineeVO {
	 private int no;                  //-- 수강번호(PK)
	 private int stuno;                  //-- 학번(FK)
	 private int subno;                  //-- 과목코드(FK)
	
	 public TraineeVO() {
		
	}

	public TraineeVO(int no, int stuno, int subno) {
		super();
		this.no = no;
		this.stuno = stuno;
		this.subno = subno;
	}

	public TraineeVO(int stuno, int subno) {
		this.stuno = stuno;
		this.subno = subno;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getStuno() {
		return stuno;
	}

	public void setStuno(int stuno) {
		this.stuno = stuno;
	}

	public int getSubno() {
		return subno;
	}

	public void setSubno(int subno) {
		this.subno = subno;
	}

	@Override
	public String toString() {
		return "TraineeVO [no=" + no + ", stuno=" + stuno + ", subno=" + subno + "]";
	}


	 
	 
	 
}
