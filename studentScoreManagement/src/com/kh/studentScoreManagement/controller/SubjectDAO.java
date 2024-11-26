package com.kh.studentScoreManagement.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.studentScoreManagement.model.StudentVO;
import com.kh.studentScoreManagement.model.SubjectVO;


public class SubjectDAO {
		
	public static final String SUBJECT_SELECT = "SELECT * FROM SUBJECT";
    public static final String SUBJECT_INSERT = "INSERT INTO SUBJECT VALUES (?, ?, ?)";
    public static final String SUBJECT_CALL_RANK_PROC = "{call STUDENT_RANK_PROC()}";
    public static final String SUBJECT_UPDATE = "UPDATE SUBJECT SET NAME = ?, SCORE = ? WHERE NO = ?";
    public static final String SUBJECT_DELETE = "DELETE FROM SUBJECT WHERE NO = ?";
    public static final String SUBJECT_SORT = "SELECT *FROM STUDENT ORDER BY RANK";
	
	public ArrayList<SubjectVO> subjectSelect() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<SubjectVO> subjectList = new ArrayList<SubjectVO>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(SUBJECT_SELECT);

		if(rs.next()) {
			do{
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				int score = rs.getInt("SCORE");
				SubjectVO svo = new SubjectVO(no, name, score); 
				subjectList.add(svo);
			}while (rs.next());
		}else {
			subjectList = null; 
		}
		DBUtility.dbClose(con, stmt, rs);
		return subjectList;
	}
	
	public boolean subjectInsert(SubjectVO svo){
		//Conection
		boolean successFlag = false; 
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBUtility.dbCon();

		try {
			pstmt = con.prepareStatement(SUBJECT_INSERT);
			pstmt.setInt(1, svo.getNo());
			pstmt.setString(2, svo.getName());
			pstmt.setInt(3, svo.getScore());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0 ) ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtility.dbClose(con, pstmt);
		}

		return successFlag; 
	}

	public static boolean subjectUpdate(SubjectVO svo) throws SQLException {
		boolean successFlag = false; 
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(SUBJECT_UPDATE);
		pstmt.setString(1, svo.getName());
		pstmt.setInt(2, svo.getScore());
		pstmt.setInt(3, svo.getNo());
		int result = pstmt.executeUpdate();
//		cstmt = con.prepareCall(SUBJECT_CALL_RANK_PROC);
//		int result2 = cstmt.executeUpdate();
		
		successFlag = (result != 0) ? true : false;

		DBUtility.dbClose(con, pstmt);
		return successFlag; 
	}

	public static boolean subjectDelete(SubjectVO svo) throws SQLException {
		boolean successFlag =false; 
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(SUBJECT_DELETE);
		pstmt.setInt(1, svo.getNo());
		int result = pstmt.executeUpdate();
		successFlag = (result != 0) ? true : false ;

		DBUtility.dbClose(con, pstmt);
		return successFlag; 
	}

	public static ArrayList<SubjectVO> subjcetSort() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<SubjectVO> subjectList = new ArrayList<SubjectVO>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(SUBJECT_SORT);

		if(rs.next()) {
			do {
				int subNo = rs.getInt("SUB_NO");
				String subName = rs.getString("SUB_NAME");
				int score = rs.getInt("SCORE");
				SubjectVO sub = new SubjectVO();
				subjectList.add(sub);
			} while (rs.next());
		}else {
			subjectList = null; 
		}

		DBUtility.dbClose(con, stmt, rs);
		return subjectList; 
	}


}