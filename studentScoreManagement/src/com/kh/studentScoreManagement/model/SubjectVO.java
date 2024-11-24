package com.kh.studentScoreManagement.model;

public class SubjectVO {

	private int subNo;              	//-- 과목코드(PK)
    private String subName;			    //-- 과목이름
    private int score;            	    //-- 학점
    private int tot;               		//-- 총점
    private int avr;                	//-- 평점
    private int rnk;                    //-- 랭크
	
    public SubjectVO() {
		
	}

	public SubjectVO(int subNo, String subName, int score, int tot, int avr, int rnk) {
		super();
		this.subNo = subNo;
		this.subName = subName;
		this.score = score;
		this.tot = tot;
		this.avr = avr;
		this.rnk = rnk;
	}

	public SubjectVO(int subNo, String subName, int score) {
		this.subNo = subNo;
		this.subName = subName;
		this.score = score;
	}

	public int getSubNo() {
		return subNo;
	}

	public void setSubNo(int subNo) {
		this.subNo = subNo;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getAvr() {
		return avr;
	}

	public void setAvr(int avr) {
		this.avr = avr;
	}

	public int getRnk() {
		return rnk;
	}

	public void setRnk(int rnk) {
		this.rnk = rnk;
	}

	@Override
	public String toString() {
		return "[subNo=" + subNo + ", subName=" + subName + ", score=" + score + ", tot=" + tot + ", avr="
				+ avr + ", rnk=" + rnk + "]";
	}   
    
    
}
