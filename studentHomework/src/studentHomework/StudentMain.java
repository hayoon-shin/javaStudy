package studentHomework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
	public static Scanner scan = new Scanner(System.in);
	public static final int PRINT = 1, INSERT = 2, UPDATE = 3, DELETE = 4, EXIT = 5;

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;
		// 사용자로부터 student 출력, 입력, 수정, 삭제, 종료 요청받는다.
		while (!exitFlag) {
			printMenu();
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
			case PRINT:
				studentPrint();
				break;
			case INSERT:
				studentInsert();
				break;
			case UPDATE:
				studentUpdate();
				break;
			case DELETE:
				studentDelete();
				break;
			case EXIT:
				exitFlag = true;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + num);

			}
		}
		System.out.println("The end");

	}

	private static void studentDelete() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;
		// 1 Load,2 connect
		con = DBConnection.dbCon();
		// 3.statement
		System.out.print("삭제할번호>>");
		int no = Integer.parseInt(scan.nextLine());
		stmt = con.createStatement();
		int result = stmt.executeUpdate("DELETE FROM STUDENT WHERE NO = " + no);
		// 4.내용이 잘 입력이 되었는지 check
		System.out.println((result != 0) ? "삭제성공" : "삭제실패");
		// 6.sql 객체 반남
		DBConnection.dbClose(con, stmt);
	}

	private static void studentUpdate() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		// 1 Load,2 connect
		con = DBConnection.dbCon();
		// 3.statement
		//수정할데이터를 입력
		System.out.println("학번 입력");
		String no = scan.nextLine();
		System.out.println("이름 입력");
		String name = scan.nextLine();
		System.out.println("국어 성적 입력");
		String kor = scan.nextLine();
		System.out.println("영어 성적 입력");
		String eng = scan.nextLine();
		System.out.println("수학 성적 입력");
		String mat = scan.nextLine();
		System.out.println("합계 입력");
		String tot = scan.nextLine();
		System.out.println("평균 입력");
		String avr = scan.nextLine();
		Student student = new Student();
		stmt = con.createStatement();
		int result = stmt.executeUpdate("UPDATE STUDENT SET  NAME = '"+
				name +"', KOR = '"+ kor +"', ENG = '"+
				eng+"' , MAT = '"+ mat + "', TOT = '"+ tot +"', AVR = '"+
						avr+ "' WHERE NO = '"+ no +"'");
		// 4.내용이 잘 입력이 되었는지 check
		System.out.println((result != 0) ? "수정성공" : "수정실패");
		// 6.sql 객체 반남
		DBConnection.dbClose(con, stmt);
	}



	private static void studentInsert() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;
		// 1 Load,2 connect
		con = DBConnection.dbCon();
		// 3.statement
		System.out.println("이름 입력");
		String name = scan.nextLine();
		System.out.println("국어 성적 입력");
		String kor = scan.nextLine();
		System.out.println("영어 성적 입력");
		String eng = scan.nextLine();
		System.out.println("수학 성적 입력");
		String mat = scan.nextLine();
		System.out.println("합계 입력");
		String tot = scan.nextLine();
		System.out.println("평균 입력");
		String avr = scan.nextLine();

		Student student = new Student();
		stmt = con.createStatement();
		int result = stmt.executeUpdate("INSERT INTO STUDENT VALUES " + "(STUDENT_ID_SEQ.nextval,'" + name + "','" + kor
				+ "','" + eng + "','" + mat + "','" + tot + "','" + avr + "')");
		// 4.내용이 잘 입력이 되었는지 check
		System.out.println((result != 0) ? "입력성공" : "입력실패");
		// 6.sql 객체 반남
		DBConnection.dbClose(con, stmt);

	}

	private static void studentPrint() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> studentList = new ArrayList<Student>();
		// 1.Load, 2.connect
		con = DBConnection.dbCon();
		// 3. statement
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM STUDENT");
		// 4. 테이블 내용 가져오기
		while (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			int kor = rs.getInt("KOR");
			int eng = rs.getInt("ENG");
			int mat = rs.getInt("MAT");
			int tot = rs.getInt("TOT");
			double avr = rs.getInt("AVR");
			Student student = new Student(no, name, kor, eng, mat, tot, avr);
			studentList.add(student);
		}
		// 5. 출력하기
		studentListPrint(studentList);
		// 6.sql 객체 반남
		DBConnection.dbClose(con, stmt, rs);
	}

	private static void studentListPrint(ArrayList<Student> studentList) {
		for (Student student : studentList) {
			System.out.println(student.toString());
		}
	}

	private static void printMenu() {
		System.out.println("Student menu(1.출력, 2.입력, 3.수정, 4.삭제, 5.종료)");
		System.out.println(">>");
	}

}
