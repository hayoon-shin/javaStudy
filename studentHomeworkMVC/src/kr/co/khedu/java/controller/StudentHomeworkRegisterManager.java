package kr.co.khedu.java.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.khedu.java.model.StudentHomeworkVO;

public class StudentHomeworkRegisterManager {
	public static Scanner scan = new Scanner(System.in);
	public static void totalSelectManager() throws SQLException {
		ArrayList<StudentHomeworkVO> studentList = new ArrayList<StudentHomeworkVO>();
		studentList = StudentHomeworkDAO.totalSelect();
		studentListPrint(studentList);
	}
	public static void studentInsertManager() throws SQLException {
		
		System.out.println("이름 입력");
		String name = scan.nextLine();
		System.out.println("국어 성적 입력");
		int kor = Integer.parseInt(scan.nextLine());
		System.out.println("영어 성적 입력");
		int eng = Integer.parseInt(scan.nextLine());
		System.out.println("수학 성적 입력");
		int mat = Integer.parseInt(scan.nextLine());
		System.out.println("수강료 입력");
		int price = Integer.parseInt(scan.nextLine());
		StudentHomeworkVO studentVO = new StudentHomeworkVO(name, kor, eng, mat, price);
		boolean successFlag = StudentHomeworkDAO.studentInsert(studentVO);
		
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
	}
	public static void studentUpdateManager() throws SQLException {
		// 3.statement
		// 수정할데이터를 입력
		System.out.println("학번 입력");
		int no = Integer.parseInt(scan.nextLine());
		System.out.println("이름 입력");
		String name = scan.nextLine();
		System.out.println("국어 성적 입력");
		int kor = Integer.parseInt(scan.nextLine());
		System.out.println("영어 성적 입력");
		int eng = Integer.parseInt(scan.nextLine());
		System.out.println("수학 성적 입력");
		int mat = Integer.parseInt(scan.nextLine());
		System.out.println("수강료 입력");
		int price = Integer.parseInt(scan.nextLine());
		StudentHomeworkVO studentVO = new StudentHomeworkVO(no,name,kor,eng,mat,price);
		boolean successFlag = StudentHomeworkDAO.studentUpdate(studentVO);
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
		
	}
	public static void studentDeleteManager() throws SQLException {
		// 3.statement
		System.out.print("삭제할 학생 번호를 입력하세요 : ");
		int no = Integer.parseInt(scan.nextLine());
		StudentHomeworkVO StudentVO = new StudentHomeworkVO();
		StudentVO.setNo(no);
		boolean successFlag = StudentHomeworkDAO.studentDelete(StudentVO);
		if(successFlag == true) {
			System.out.println("삭제처리 성공");
		}else {
			System.out.println("삭제처리 실패");
		}
	}
	public static void studentSALARY_UP_PROCManager() throws SQLException {
		// 3.statement
		System.out.print("인상될 학생 번호 입력: >>");
		int no = Integer.parseInt(scan.nextLine());
		System.out.print("인상금액 입력: >>");
		int price = Integer.parseInt(scan.nextLine());
		// 수정할데이터를 입력
		StudentHomeworkVO studentVO = new StudentHomeworkVO(no,price);
		boolean successFlag = StudentHomeworkDAO.studentSALARY_UP_PROC(studentVO);
		if(successFlag == true) {
			System.out.println("프로시저 성공");
		} else {
			System.out.println("프로시저 실패");
		} 
	}
	public static void studentSALARY_UP_FUNCManager() throws SQLException {
		// 3.statement
		System.out.print("인상될 학생 번호 입력: >>");
		int no = Integer.parseInt(scan.nextLine());
		StudentHomeworkVO studentVO = new StudentHomeworkVO();
		studentVO.setNo(no);
		boolean successFlag = StudentHomeworkDAO.studentSALARY_UP_FUNC(studentVO);
		if(successFlag == true) {
			System.out.println("Function 성공");
		}else {
			System.out.println("Function 실패");
		}
	}
	private static void studentListPrint(ArrayList<StudentHomeworkVO> studentList) {
		System.out.println("====================================================");
		for (StudentHomeworkVO student : studentList) {
			System.out.println(student.toString());
		}
		System.out.println("====================================================");
	}
}
