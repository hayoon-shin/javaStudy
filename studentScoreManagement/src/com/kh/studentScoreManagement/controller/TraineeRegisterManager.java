package com.kh.studentScoreManagement.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.studentScoreManagement.model.TraineeAllVO;
import com.kh.studentScoreManagement.model.TraineeVO;


public class TraineeRegisterManager {
	public static Scanner sc = new Scanner(System.in);
	//전체 학생리스트를 출력요청
	public static void SelectManager() throws SQLException {
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>();
		traineeList = TraineeDAO.studentSelect();
		if(traineeList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		
		printTraineeList(traineeList);
		
	}
	
	public static void InsertManager() throws SQLException {
		
		// 3.statement
		System.out.print("학번을 입력하세요: ");
		int stuno = Integer.parseInt(sc.nextLine());
		System.out.print("과목 코드를 입력하세요: ");
		int subno = Integer.parseInt(sc.nextLine());


		TraineeVO traineeVO = new TraineeVO(stuno,subno);
		boolean successFlag = TraineeDAO.studentInsert(traineeVO);
		
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
		
	}
	
//	public static void UpdateManager() throws SQLException {
//		System.out.print("수정할 학생의 번호를 입력하세요: ");
//		int stuno = Integer.parseInt(sc.nextLine());
//		System.out.print("새로운 수강 번호를 입력하세요: ");
//		int no = Integer.parseInt(sc.nextLine());
//		System.out.print("새로운 과목 코드를 입력하세요: ");
//		int subno = Integer.parseInt(sc.nextLine());
//		
//		TraineeVO tvo = new TraineeVO();
//		boolean successFlag = TraineeDAO.studentUpdate(tvo);
//		if(successFlag == true) {
//			System.out.println("입력처리 성공");
//		}else {
//			System.out.println("입력처리 실패");
//		}
//	}
//	
	public static void DeleteManager() throws SQLException {
		System.out.print("삭제할 학생 번호를 입력하세요: ");
		int stuno = Integer.parseInt(sc.nextLine());
		TraineeVO tvo = new TraineeVO();
		tvo.setStuno(stuno);
		boolean successFlag = TraineeDAO.studentDelete(tvo);
		if(successFlag == true) {
			System.out.println("삭제처리 성공");
		}else {
			System.out.println("삭제처리 실패");
		}
	}
	
//	public static void studentSortManager() throws SQLException {
//		ArrayList<TraineeVO> traineeList = null;
//		traineeList = TraineeDAO.studentSort();
//		printTraineeList(traineeList);
//	}
	public void selectAllManager() throws SQLException {
		TraineeDAO tdao = new TraineeDAO(); 
		ArrayList<TraineeAllVO> traineeAllList = new ArrayList<TraineeAllVO>();
		
		traineeAllList = tdao.studentAllSelect();
		if (traineeAllList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printTraineeList2(traineeAllList);
	}
	
	
	//전체 학생리스트를 출력진행
	public static void printTraineeList(ArrayList<TraineeVO> traineeList) {
		System.out.println("============================================");
		for (TraineeVO tv : traineeList) {
			System.out.println(tv.toString());
		}
		System.out.println("============================================");
	}
	public static void printTraineeList2(ArrayList<TraineeAllVO> traineeList) {
		System.out.println("============================================");
		for (TraineeAllVO tv : traineeList) {
			System.out.println(tv.toString());
		}
		System.out.println("============================================");
	}

}
