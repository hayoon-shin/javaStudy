package com.kh.studentScoreManagement.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.studentScoreManagement.model.StudentVO;
import com.kh.studentScoreManagement.model.SubjectVO;


public class SubjectRegisterManager {
	public static Scanner sc = new Scanner(System.in); 
	//전체 학생리스트를 출력요청
	public static void selectManager() throws SQLException {
		ArrayList<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		SubjectDAO subDAO = new SubjectDAO(); 
		subjectList = subDAO.subjectSelect();
		if(subjectList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printSubjectList(subjectList); 
	}

	public static void insertManager() throws SQLException {
		SubjectDAO sd = new SubjectDAO();
		

		int no; // 과목 코드
		String name; // 과목이름
		int score; // 학점

		System.out.println("과목 전체 리스트");
		//sd.getSubjectTotalList();
		System.out.println();

		System.out.println("과목 정보 입력(학과번호:01,02,03,04,05)학과명01(C언어),02(Database 개론), 03(정보보호 개론), 04(시스템 프로그래밍),05(네트워크 프로그래밍)");
		System.out.print("과목번호>>");
		no = Integer.parseInt(sc.nextLine());
		System.out.print("과목명>>");
		name = sc.nextLine();
		System.out.print("학점수>>");
		score = Integer.parseInt(sc.nextLine());
		SubjectVO svo = new SubjectVO(no,name,score);
		boolean successFlag = sd.subjectInsert(svo);

		if(successFlag == false) {
			System.out.println("입력처리 실패");
			return;
		}
		System.out.println();
		System.out.println("과목 전체 리스트");
		ArrayList<SubjectVO> subjectList = sd.subjectSelect();
		if(subjectList == null) {
			System.out.println("학과정보가 없습니다.");
			return;
		}
		printSubjectList(subjectList); 
	}

	public static void updateManager() throws SQLException {
		System.out.println("과목 정보 입력(학과번호:01,02,03,04,05)학과명01(C언어),02(Database 개론), 03(정보보호 개론), 04(시스템 프로그래밍),05(네트워크 프로그래밍)");
		System.out.print("수정할 과목의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 과목 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("수정할 과목 학점수를 입력하세요: ");
		int score = Integer.parseInt(sc.nextLine());
		SubjectVO svo = new SubjectVO(no,name,score);
		boolean successFlag = SubjectDAO.subjectUpdate(svo);
		
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
	}

	public static void deleteManager() throws SQLException {
		System.out.print("삭제할 과목 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		SubjectVO svo = new SubjectVO();
		svo.setNo(no);
		boolean successFlag = SubjectDAO.subjectDelete(svo); 
		
		if(successFlag == true) {
			System.out.println("삭제처리 성공");
		}else {
			System.out.println("삭제처리 실패");
		}
	}

	public static void sortManager() throws SQLException {
		ArrayList<SubjectVO> subjectList = null;
		subjectList =SubjectDAO.subjcetSort(); 
		printSubjectList(subjectList); 
	}

	//전체 학생리스트를 출력진행
	public static void printSubjectList(ArrayList<SubjectVO> subjectList) {
		System.out.println("============================================");
		for( SubjectVO sv :  subjectList) {
			System.out.println(sv.toString());
		}
		System.out.println("============================================");
	}
}
