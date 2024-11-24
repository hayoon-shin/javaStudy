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
		SubjectDAO subjectDao = new SubjectDAO();
		StudentDAO studentDao = new StudentDAO();
		StudentVO svo = new StudentVO();

		System.out.println("학생 정보 입력");
		System.out.print("성명 >>");
		String stuName = sc.nextLine();
//		String id = null; 
//		do {
//			System.out.print("아이디(8자 이상 12자 이내) : ");
//			id = sc.nextLine();
//			boolean idCheck = studentDao.studentIdCheck(id);
//			if (idCheck == false) {
//				break; 
//			}
//			System.out.println("중복된 아이디입니다. 다시 입력하세요");
//		} while (true);
//
//		System.out.print("비밀번호(12자 이내) : ");
//		String passwd = sc.nextLine();

		//과목정보출력
//		ArrayList<SubjectVO> subjectList = subjectDao.subjectSelect(); 
//		SubjectRegisterManager.printSubjectList(subjectList);
//
//		System.out.print("과목번호 : ");
//		String subNo = sc.nextLine();
//
//		// 학생 번호는 8자리로 생성한다. (연도2자리+학과2자리+일련번호 - 예로24110001) 
//		SimpleDateFormat sdf = new SimpleDateFormat("yy");
//		String year = sdf.format(new Date());
//		String num = year + s_num + studentDao.getStudentCount(s_num);
//		//String num = year + s_num + "0001";

		System.out.print("이메일   : ");
		String email = sc.nextLine();
		System.out.print("도로명 주소 : ");
		String address = sc.nextLine();
		System.out.print("전화번호 : ex) 010-2971-4011");
		String phone = sc.nextLine();
		
		StudentVO studentVO = new StudentVO(0, stuName, phone, address, email, null);
		
		boolean successFlag = studentDao.studentInsert(studentVO);

		if(successFlag == false) {
			System.out.println("입력처리 실패");
			return; 
		}

		System.out.println();
		System.out.println("등록 학생 정보");
//		studentDao.getStudentSelect(num); 
		//sd.getStudent(svo.getSd_id(), svo.getSd_passwd());
	}

	public  void updateManager() throws SQLException {
		System.out.print("수정할 학생의 번호를 입력하세요: ");
		int stuNo = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 이름을 입력하세요: ");
		String stuName = sc.nextLine();
		System.out.print("새로운 과목 코드를 입력하세요: ");
		int subNo = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 과목 이름을 입력하세요: ");
		String subName = sc.nextLine();
		System.out.print("새로운 과목 점수를 입력하세요: ");
		int score = Integer.parseInt(sc.nextLine());
		
		StudentVO svo = new StudentVO();
		boolean successFlag = StudentDAO.studentUpdate(svo);
		
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
	}

	public  void deleteManager() throws SQLException {
		System.out.print("삭제할 학생 번호를 입력하세요: ");
		int stuNo = Integer.parseInt(sc.nextLine());
		StudentVO svo = new StudentVO();
		((StudentVO) svo).setStuNo(stuNo);
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