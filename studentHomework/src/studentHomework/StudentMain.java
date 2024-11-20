package studentHomework;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;
		// 사용자로부터 student 출력, 입력, 수정, 삭제, 종료 요청받는다.
		while (!exitFlag) {
			printMenu();
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
			case StudentMenu.PRINT:
				studentPrint();
				break;
			case StudentMenu.INSERT:
				studentInsert();
				break;
			case StudentMenu.UPDATE:
				studentUpdate();
				break;
			case StudentMenu.DELETE:
				studentDelete();
				break;
			case StudentMenu.SALARY_UP_PROC:
				studentSALARY_UP_PROC();
				break;
			case StudentMenu.SALARY_UP_FUNC:
				studentSALARY_UP_FUNC();
				break;
			case StudentMenu.EXIT:
				exitFlag = true;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + num);

			}
		}
		System.out.println("The end");

	}

	private static void studentSALARY_UP_FUNC() throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		// 1 Load,2 connect
		con = DBConnection.dbCon();

		// 3.statement
		System.out.print("인상될 학생 번호 입력: >>");
		int no = Integer.parseInt(scan.nextLine());
		// 수정할데이터를 입력
		cstmt = con.prepareCall("{ ? = call STUDENT_FUNCTION(?)}");
		cstmt.registerOutParameter(1, Types.VARCHAR);
		cstmt.setInt(2, no);
		// 출력될 데이터값으로 3번을 바인딩시킨다.

		int result = cstmt.executeUpdate();
		String message = cstmt.getString(1);
		System.out.println(message);
		// 4.내용이 잘 입력이 되었는지 check
		System.out.println((result != 0) ? "FUNCTION 성공" : "FUNCTION 실패");
		// 6.sql 객체 반남
		DBConnection.dbClose(con, cstmt);

	}

	private static void studentSALARY_UP_PROC() throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		// 1 Load,2 connect
		con = DBConnection.dbCon();
		// 3.statement
		System.out.print("인상될 학생 번호 입력: >>");
		int no = Integer.parseInt(scan.nextLine());
		System.out.print("인상금액 입력: >>");
		int price = Integer.parseInt(scan.nextLine());
		// 수정할데이터를 입력
		Student student = new Student();
		cstmt = con.prepareCall("{call STUDENT_PROCEDURE(?,?,?)}");
		cstmt.setInt(1, no);
		cstmt.setInt(2, price);
		// 출력될 데이터값으로 3번을 바인딩시킨다.
		cstmt.registerOutParameter(3, Types.VARCHAR);

		int result = cstmt.executeUpdate();
		String message = cstmt.getString(3);
		System.out.println(message);
		// 4.내용이 잘 입력이 되었는지 check
		System.out.println((result != 0) ? "수강료인상 프로시저성공" : "수강료인상 프로시저실패");
		// 6.sql 객체 반남
		DBConnection.dbClose(con, cstmt);
	}

	private static void studentDelete() throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1 Load,2 connect
		con = DBConnection.dbCon();
		// 3.statement
		System.out.print("삭제할번호>>");
		int no = Integer.parseInt(scan.nextLine());
		pstmt = con.prepareStatement("DELETE FROM STUDENT WHERE NO = ?");
		pstmt.setInt(1, no);
		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력이 되었는지 check
		System.out.println((result != 0) ? "삭제성공" : "삭제실패");
		// 6.sql 객체 반남
		DBConnection.dbClose(con, pstmt);
	}

	private static void studentUpdate() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1 Load,2 connect
		con = DBConnection.dbCon();
		// 3.statement
		// 수정할데이터를 입력
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
		System.out.println("수강료 입력");
		String price = scan.nextLine();
		Student student = new Student();
		pstmt = con.prepareStatement(
				"UPDATE STUDENT SET  NAME = ?, KOR = ?, ENG = ?, MAT = ?, TOT = ?, AVR = ?, PRICE =? WHERE NO = ?");
		pstmt.setString(1, name);
		pstmt.setString(2, kor);
		pstmt.setString(3, eng);
		pstmt.setString(4, mat);
		pstmt.setInt(5, student.getTot());
		pstmt.setDouble(6, student.getAvr());
		pstmt.setString(7, price);
		pstmt.setString(8, no);
		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력이 되었는지 check
		System.out.println((result != 0) ? "수정성공" : "수정실패");
		// 6.sql 객체 반남
		DBConnection.dbClose(con, pstmt);
	}

	private static void studentInsert() throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;
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
		System.out.println("수강료 입력");
		String price = scan.nextLine();
		Student student = new Student();
		pstmt = con.prepareStatement("INSERT INTO STUDENT VALUES (STUDENT_ID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)");
		pstmt.setString(1, name);
		pstmt.setString(2, kor);
		pstmt.setString(3, eng);
		pstmt.setString(4, mat);
		pstmt.setInt(5, student.getTot());
		pstmt.setDouble(6, student.getAvr());
		pstmt.setString(7, price);
		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력이 되었는지 check
		System.out.println((result != 0) ? "입력성공" : "입력실패");
		// 6.sql 객체 반남
		DBConnection.dbClose(con, pstmt);

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
			int price = rs.getInt("PRICE");
			Student student = new Student(no, name, kor, eng, mat, tot, avr, price);
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
		System.out.println("Student menu(1.출력, 2.입력, 3.수정, 4.삭제, 5.수강료인상, 6.수강료조회, 7.종료)");
		System.out.println(">>");
	}

}
