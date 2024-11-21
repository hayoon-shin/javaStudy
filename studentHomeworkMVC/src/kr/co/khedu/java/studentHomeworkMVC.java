package kr.co.khedu.java;


import java.sql.SQLException;
import java.util.Scanner;

import kr.co.khedu.java.controller.StudentHomeworkRegisterManager;
import kr.co.khedu.java.view.StudentHomeworkCURDMenu;
import kr.co.khedu.java.view.StudentHomeworkMenu;

public class studentHomeworkMVC {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;
		// 사용자로부터 student 출력, 입력, 수정, 삭제, 종료 요청받는다.
		while (!exitFlag) {
			StudentHomeworkMenu.printMenu();
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
			case StudentHomeworkCURDMenu.PRINT:
				StudentHomeworkRegisterManager.totalSelectManager();
				break;
			case StudentHomeworkCURDMenu.INSERT:
				StudentHomeworkRegisterManager.studentInsertManager();
				break;
			case StudentHomeworkCURDMenu.UPDATE:
				StudentHomeworkRegisterManager.studentUpdateManager();
				break;
			case StudentHomeworkCURDMenu.DELETE:
				StudentHomeworkRegisterManager.studentDeleteManager();
				break;
			case StudentHomeworkCURDMenu.SALARY_UP_PROC:
				StudentHomeworkRegisterManager.studentSALARY_UP_PROCManager();
				break;
			case StudentHomeworkCURDMenu.SALARY_UP_FUNC:
				StudentHomeworkRegisterManager.studentSALARY_UP_FUNCManager();
				break;
			case StudentHomeworkCURDMenu.EXIT:
				exitFlag = true;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + num);

			}
		}
		System.out.println("The end");

	}

}