package kr.co.khedu.java.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import kr.co.khedu.java.model.StudentHomeworkVO;

public class StudentHomeworkDAO {
	public static String selectSQL = "SELECT * FROM STUDENT";
	public static String insertSQL = "INSERT INTO STUDENT VALUES (STUDENT_ID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)"; 
	public static String updateSQL = "UPDATE STUDENT SET  NAME = ?, KOR = ?, ENG = ?, MAT = ?, PRICE =? WHERE NO = ?";
	public static String deleteSQL = "DELETE FROM STUDENT WHERE NO = ?";
	public static String salaryUpProcSQL = "{call STUDENT_PROCEDURE(?,?,?)}";
	public static String salaryUpFuncSQL = "{ ? = call STUDENT_FUNCTION(?)}";
  	public static ArrayList<StudentHomeworkVO> totalSelect() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<StudentHomeworkVO> studentList = new ArrayList<StudentHomeworkVO>();
		// 1.Load, 2.connect
		con = DBUtility.dbCon();
		// 3. statement
		stmt = con.createStatement();
		rs = stmt.executeQuery(selectSQL);
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
			StudentHomeworkVO student = new StudentHomeworkVO(no, name, kor, eng, mat, tot, avr, price);
			studentList.add(student);
		}
		// 6.sql 객체 반남
		DBUtility.dbClose(con, stmt, rs);
		
		return studentList;
	}
	
	public static boolean studentInsert(StudentHomeworkVO svo) throws SQLException {
		// Connection
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1 Load,2 connect
		con = DBUtility.dbCon();
		// 3.statement
		pstmt = con.prepareStatement(insertSQL);
		pstmt.setString(1, svo.getName());
		pstmt.setInt(2, svo.getKor());
		pstmt.setInt(3, svo.getEng());
		pstmt.setInt(4, svo.getMat());
		pstmt.setInt(5, svo.getTot());
		pstmt.setDouble(6, svo.getAvr());
		pstmt.setInt(7, svo.getPrice());
		int result1 = pstmt.executeUpdate();
	
		System.out.println((result1 != 0) ? "입력성공" : "입력실패");
		
		DBUtility.dbClose(con, pstmt);
		successFlag = (result1 != 0 ) ? true : false;
		
		return successFlag;

	}
	public static boolean studentUpdate(StudentHomeworkVO svo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1 Load,2 connect
		con = DBUtility.dbCon();
		// 3.statement
		// 수정할데이터를 입력
		
		pstmt = con.prepareStatement(updateSQL);
		pstmt.setString(1, svo.getName());
		pstmt.setInt(2, svo.getKor());
		pstmt.setInt(3, svo.getEng());
		pstmt.setInt(4, svo.getMat());
		pstmt.setInt(5, svo.getPrice());
		pstmt.setInt(6, svo.getNo());
		int result1 = pstmt.executeUpdate();
		// 4.내용이 잘 입력이 되었는지 check
		successFlag = (result1 != 0) ? true : false;
		// 6.sql 객체 반남
		DBUtility.dbClose(con, pstmt);
		return successFlag;
	}
	public static boolean studentDelete(StudentHomeworkVO svo) throws SQLException {
		// Connection
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1 Load,2 connect
		con = DBUtility.dbCon();
		// 3.statement
		pstmt = con.prepareStatement(deleteSQL);
		pstmt.setInt(1, svo.getNo());
		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력이 되었는지 check
		successFlag = (result != 0) ? true : false;
		// 6.sql 객체 반남
		DBUtility.dbClose(con, pstmt);
		
		return successFlag;
	}
	public static boolean studentSALARY_UP_PROC(StudentHomeworkVO svo) throws SQLException {
		// Connection
		boolean successFlag = false;
		Connection con = null;
		CallableStatement cstmt = null;
		// 1 Load,2 connect
		con = DBUtility.dbCon();
		// 3.statement
		// 수정할데이터를 입력
		cstmt = con.prepareCall(salaryUpProcSQL);
		cstmt.setInt(1, svo.getNo());
		cstmt.setInt(2, svo.getPrice());
		// 출력될 데이터값으로 3번을 바인딩시킨다.
		cstmt.registerOutParameter(3, Types.VARCHAR);

		int result = cstmt.executeUpdate();
		String message = cstmt.getString(3);
		System.out.println(message);
		// 4.내용이 잘 입력이 되었는지 check
		successFlag = (result != 0) ? true : false;
		// 6.sql 객체 반남
		DBUtility.dbClose(con, cstmt);
		
		return successFlag;
	}
	public static boolean studentSALARY_UP_FUNC(StudentHomeworkVO svo) throws SQLException {
		// Connection
		boolean successFlag = false;
		Connection con = null;
		CallableStatement cstmt = null;
		// 1 Load,2 connect
		con = DBUtility.dbCon();

		// 3.statement
		// 수정할데이터를 입력
		cstmt = con.prepareCall(salaryUpFuncSQL);
		cstmt.registerOutParameter(1, Types.VARCHAR);
		cstmt.setInt(2, svo.getNo());
		// 출력될 데이터값으로 3번을 바인딩시킨다.

		int result = cstmt.executeUpdate();
		String message = cstmt.getString(1);
		System.out.println(message);
		// 4.내용이 잘 입력이 되었는지 check
		successFlag = (result != 0) ? true : false;
		// 6.sql 객체 반남
		DBUtility.dbClose(con, cstmt);
		return successFlag;

	}
}


