package com.kh.studentScoreManagement.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.studentScoreManagement.model.StudentVO;
import com.kh.studentScoreManagement.model.TraineeAllVO;
import com.kh.studentScoreManagement.model.TraineeVO;

public class TraineeDAO {
	public static final String TRAINEE_SELECT = "SELECT * FROM TRAINEE";
    public static final String TRAINEE_INSERT = "INSERT INTO TRAINEE VALUES(TRAINEE_SEQ.NEXTVAL, ?, ?)";
    public static final String TRAINEE_UPDATE = "UPDATE TRAINEE SET STUNO = ?, SUBNO = ? WHERE NO = ?";
    public static final String TRAINEE_DELETE = "DELETE FROM TRAINEE WHERE STUNO = ?";
    public static final String TRAINEE_SUBJECT_JOIN_SELECT = "select T.NO, STUNO, SUBNO, NAME, SCORE from trainee T inner join subject S on S.no = T.SUBNO";
    
    public static ArrayList<TraineeVO> studentSelect() throws SQLException {Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	ArrayList<TraineeVO> studentList = new ArrayList<TraineeVO>();

	con = DBUtility.dbCon();
	stmt = con.createStatement();
	rs = stmt.executeQuery(TRAINEE_SELECT);

	while (rs.next()) {
		int no = rs.getInt("NO");
		int stuno = rs.getInt("STUNO");
		int subno = rs.getInt("SUBNO");

		TraineeVO stu = new TraineeVO(no,stuno,subno);
		studentList.add(stu);
	}
//	stuListPrint(studentList);
	DBUtility.dbClose(con, stmt, rs);
	
	return studentList;
	}
	
	public static boolean studentInsert(TraineeVO svo) {
		// Conection
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBUtility.dbCon();

		try {
			pstmt = con.prepareStatement(TRAINEE_INSERT);
			pstmt.setInt(1, svo.getStuno());
			pstmt.setInt(2, svo.getSubno());
			int result1 = pstmt.executeUpdate();
			successFlag = (result1 != 0) ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		
		return successFlag;
	}

//	public static boolean studentUpdate(TraineeVO svo) throws SQLException {
//		boolean successFlag = false;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		con = DBUtility.dbCon();
//
//		pstmt = con.prepareStatement(TRAINEE_UPDATE);
//		pstmt.setInt(1, svo.getStuno());
//		pstmt.setInt(2, svo.getSubno());
//		pstmt.setInt(3, svo.getNo());
//		int result1 = pstmt.executeUpdate();
//
//		successFlag = (result1 != 0) ? true : false;
//		
//		DBUtility.dbClose(con, pstmt);
//		return successFlag;
//	}
	public static boolean studentDelete(TraineeVO svo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(TRAINEE_DELETE);
		pstmt.setInt(1, svo.getStuno());
		int result = pstmt.executeUpdate();

		successFlag = (result != 0) ? true : false;

		DBUtility.dbClose(con, pstmt);
		
		return successFlag;
	}
	
	// 조인 메뉴 조회
	public ArrayList<TraineeAllVO> studentAllSelect() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TraineeAllVO> traineeList = new ArrayList<TraineeAllVO>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(TRAINEE_SUBJECT_JOIN_SELECT);

		if(rs.next()) {
			do{
				int no = rs.getInt("NO");
				int stuno = rs.getInt("STUNO");
				int subno = rs.getInt("SUBNO");
				String name = rs.getString("NAME");
				int score = rs.getInt("SCORE");
				
				TraineeAllVO trainee = new TraineeAllVO(no,stuno,subno,name,score);
				traineeList.add(trainee);
			}while (rs.next());
		}else {
			traineeList = null; 
		}
		DBUtility.dbClose(con, stmt, rs);
		return traineeList;
	}

}
