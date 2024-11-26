package com.kh.studentScoreManagement.model;

public class SubjectVO {

	private int no;              	//-- 과목코드(PK)
    private String name;			    //-- 과목이름
    private int score;            	    //-- 학점

    public SubjectVO() {
		
	}

	public SubjectVO(int no, String name, int score) {
		super();
		this.no = no;
		this.name = name;
		this.score = score;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "SubjectVO [no=" + no + ", name=" + name + ", score=" + score + "]";
	}

	
    
    
}
