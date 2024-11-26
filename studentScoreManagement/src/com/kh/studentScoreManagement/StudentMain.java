package com.kh.studentScoreManagement;

import java.sql.SQLException;
import java.util.Scanner;

import com.kh.studentScoreManagement.controller.StudentRegisterManager;
import com.kh.studentScoreManagement.controller.SubjectRegisterManager;
import com.kh.studentScoreManagement.controller.TraineeRegisterManager;
import com.kh.studentScoreManagement.view.MENU_CHOICE;
import com.kh.studentScoreManagement.view.MenuViewer;
import com.kh.studentScoreManagement.view.STUDENT_CHOICE;
import com.kh.studentScoreManagement.view.SUBJECT_CHOICE;
import com.kh.studentScoreManagement.view.TRAINEE_CHOICE;

public class StudentMain {
	public static Scanner sc = new Scanner(System.in); 
	public static void main(String[] args) {
		int no;
		boolean exitFlag = false; 
		while (!exitFlag) {
			try {
				MenuViewer.mainMenuView();
				no = Integer.parseInt(sc.nextLine()); 
				switch (no) {
				case MENU_CHOICE.SUBJECT:
					subjectMenu();
					break;
				case MENU_CHOICE.STUDENT:
					studentMenu();
					break;
				case MENU_CHOICE.TRAINEE:
					traineeMenu();
					break;
				case MENU_CHOICE.EXIT:
					System.out.println("프로그램을 종료합니다.");
					exitFlag = true; 
					break; 
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
			}
		}//end of file
	}
	//수강신청정보
	private static void traineeMenu() throws SQLException {
		int no;
		TraineeRegisterManager trm = new TraineeRegisterManager();  

		MenuViewer.traineeMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case TRAINEE_CHOICE.INSERT:
			System.out.println("");
			trm.InsertManager();
			break;
//		case TRAINEE_CHOICE.UPDATE:
//			System.out.println("");
//			trm.UpdateManager();
//			break;
		case TRAINEE_CHOICE.LIST:
			System.out.println("");
			trm.SelectManager();
			break;
		case TRAINEE_CHOICE.DELETE:
			System.out.println("");
			trm.DeleteManager();
			break;
		case TRAINEE_CHOICE.JOIN:
			System.out.println("");
			trm.selectAllManager();
			break;
		case TRAINEE_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
		
	}
	//과목정보
	private static void subjectMenu() throws SQLException {
		int no;
		SubjectRegisterManager srm = new SubjectRegisterManager();  

		MenuViewer.subjectMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case SUBJECT_CHOICE.INSERT:
			System.out.println("");
			srm.insertManager();
			break;
		case SUBJECT_CHOICE.UPDATE:
			System.out.println("");
			srm.updateManager();
			break;
		case SUBJECT_CHOICE.LIST:
			System.out.println("");
			srm.selectManager();
			break;
		case SUBJECT_CHOICE.DELETE:
			System.out.println("");
			srm.deleteManager();
			break;
		case SUBJECT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}
	//학생정보
	private static void studentMenu() throws SQLException {
		int no;
		StudentRegisterManager srm = new StudentRegisterManager(); 

		MenuViewer.studentMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case STUDENT_CHOICE.INSERT:
			System.out.println("");
			srm.insertManager();
			break;
		case STUDENT_CHOICE.UPDATE:
			System.out.println("");
			srm.updateManager();
			break;
		case STUDENT_CHOICE.LIST:
			System.out.println("");
			srm.selectManager();
			break;
		case STUDENT_CHOICE.DELETE:
			System.out.println("");
			srm.deleteManager();
			break;
		case STUDENT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}
}