package com.kh.studentScoreManagement.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.kh.studentScoreManagement.model.StudentVO;
import com.kh.studentScoreManagement.model.SubjectVO;


public class StudentRegisterManager {
	public static Scanner sc = new Scanner(System.in); 
	//전체 학생리스트를 출력요청
	public  void selectManager() throws SQLException {
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();
		studentList = StudentDAO.studentSelect();
		if(studentList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printStudentList(studentList); 
	}

	public  void insertManager() throws SQLException {
		StudentDAO sd = new StudentDAO();

		System.out.println("학생 정보 입력");
		
		System.out.print("성명 >>");
		String name = sc.nextLine();
		System.out.print("이메일   : ");
		String email = sc.nextLine();
		System.out.print("도로명 주소 : ");
		String address = sc.nextLine();
		System.out.print("전화번호 : ex) 010-2971-4011");
		String phone = sc.nextLine();
		
		StudentVO studentVO = new StudentVO(0, name, email, address, phone, null);
		
		boolean successFlag = sd.studentInsert(studentVO);

		if(successFlag == false) {
			System.out.println("입력처리 실패");
			return; 
		}

//		System.out.println();
//		System.out.println("등록 학생 정보");
//		studentDao.getStudentSelect(num); 
		//sd.getStudent(svo.getSd_id(), svo.getSd_passwd());
	}

	public  void updateManager() throws SQLException {
		System.out.print("수정할 학생의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("새로운 이메일을 입력하세요: ");
		String email = sc.nextLine();
		System.out.print("새로운 도로명 주소를 입력하세요: ");
		String address = sc.nextLine();
		System.out.print("새로운 휴대폰 번호를 입력하세요: ");
		String phone = sc.nextLine();

		StudentVO svo = new StudentVO(no,name,email,address,phone);
		boolean successFlag = StudentDAO.studentUpdate(svo);
		
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
	}

	public  void deleteManager() throws SQLException {
		System.out.print("삭제할 학생 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		StudentVO svo = new StudentVO();
		svo.setNo(no);
		boolean successFlag = StudentDAO.studentDelete(svo); 
		
		if(successFlag == true) {
			System.out.println("삭제처리 성공");
		}else {
			System.out.println("삭제처리 실패");
		}
	}

//	public  void sortManager() throws SQLException {
//		ArrayList<StudentVO> studentList = null;
//		studentList =StudentDAO.studentSort(); 
//		printStudentList(studentList);
//	}

	//전체 학생리스트를 출력진행
	public  void printStudentList(ArrayList<StudentVO> studentList) {
		System.out.println("============================================");
		for( StudentVO sv :  studentList) {
			System.out.println(sv.toString());
		}
		System.out.println("============================================");
	}
}