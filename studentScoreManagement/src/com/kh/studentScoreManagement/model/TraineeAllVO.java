package com.kh.studentScoreManagement.model;

public class TraineeAllVO {

	 private int no;                  //-- 수강번호(PK)
	 private int stuno;                  //-- 학번(FK)
	 private int subno;                  //-- 과목코드(FK)
	 private String name;			    //-- 과목이름
	 private int score;            	    //-- 학점
	
	 public TraineeAllVO(int no, int stuno, int subno, String name, int score) {
		super();
		this.no = no;
		this.stuno = stuno;
		this.subno = subno;
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", stuno=" + stuno + ", subno=" + subno + ", name=" + name + ", score="
				+ score + "]";
	}
	 
}


