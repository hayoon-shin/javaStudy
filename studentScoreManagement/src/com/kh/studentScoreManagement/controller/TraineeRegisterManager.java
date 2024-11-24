package com.kh.studentScoreManagement.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.studentScoreManagement.model.StudentVO;
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
	
	public static void traineeInsertManager() throws SQLException {
		
		// 3.statement
		System.out.print("학번을 입력하세요: ");
		int stuNo = Integer.parseInt(sc.nextLine());
		System.out.print("수강 번호를 입력하세요: ");
		int traNo = Integer.parseInt(sc.nextLine());
		System.out.print("과목 코드를 입력하세요: ");
		int subNo = Integer.parseInt(sc.nextLine());


		TraineeVO traineeVO = new TraineeVO();
		boolean successFlag = TraineeDAO.studentInsert(traineeVO);
		
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
		
	}
	
	public static void studentUpdateManager() throws SQLException {
		System.out.print("수정할 학생의 번호를 입력하세요: ");
		int stuNo = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 수강 번호를 입력하세요: ");
		int traNo = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 과목 코드를 입력하세요: ");
		int subNo = Integer.parseInt(sc.nextLine());
		
		TraineeVO tvo = new TraineeVO();
		boolean successFlag = TraineeDAO.studentUpdate(tvo);
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
	}
	
	public static void studentDeleteManager() throws SQLException {
		System.out.print("삭제할 학생 번호를 입력하세요: ");
		int stuNo = Integer.parseInt(sc.nextLine());
		TraineeVO tvo = new TraineeVO();
		tvo.setStuNo(stuNo);
		boolean successFlag = TraineeDAO.studentDelete(tvo);
		if(successFlag == true) {
			System.out.println("삭제처리 성공");
		}else {
			System.out.println("삭제처리 실패");
		}
	}
	
	public static void studentSortManager() throws SQLException {
		ArrayList<TraineeVO> traineeList = null;
		traineeList = TraineeDAO.studentSort();
		printTraineeList(traineeList);
	}
	//전체 학생리스트를 출력진행
	public static void printTraineeList(ArrayList<TraineeVO> traineeList) {
		System.out.println("============================================");
		for (TraineeVO tv : traineeList) {
			System.out.println(tv.toString());
		}
		System.out.println("============================================");
	}

}
