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
    public static final String SUBJECT_INSERT = "insert into subject(no, num, name) values (subject_seq.nextval, ?, ?)";
    public static final String SUBJECT_CALL_RANK_PROC = "{call STUDENT_RANK_PROC()}";
    public static final String SUBJECT_UPDATE = "UPDATE STUDENT SET NAME = ?, KOR = ?, ENG = ?, MAT = ? WHERE NO = ?";
    public static final String SUBJECT_DELETE = "DELETE FROM STUDENT WHERE NO = ?";
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
				int subNo = rs.getInt("SUB_NO");
				String subName = rs.getString("SUB_NAME");
				int score = rs.getInt("SCORE");
				SubjectVO svo = new SubjectVO(subNo, subName, score); 
				subjectList.add(svo);
			}while (rs.next());
		}else {
			subjectList = null; 
		}
		DBUtility.dbClose(con, stmt, rs);
		return subjectList;
	}
	
	public boolean subjectInsert(SubjectVO svo) throws SQLException  {
		//Conection
		boolean successFlag = false; 
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBUtility.dbCon();

		pstmt = con.prepareStatement(SUBJECT_INSERT);
		pstmt.setInt(1, svo.getSubNo());
		pstmt.setString(2, svo.getSubName());
		
		int result = pstmt.executeUpdate();
		
		DBUtility.dbClose(con, pstmt, cstmt);
		successFlag = (result != 0 ) ? true : false;
		return successFlag; 
	}

	public static boolean subjectUpdate(SubjectVO svo) throws SQLException {
		boolean successFlag = false; 
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(SUBJECT_UPDATE);
		pstmt.setString(1, svo.getSubName());
		

		int result1 = pstmt.executeUpdate();
		cstmt = con.prepareCall(SUBJECT_CALL_RANK_PROC);
		int result2 = cstmt.executeUpdate();
		
		successFlag = (result1 != 0 && result2 != 0) ? true : false;

		DBUtility.dbClose(con, pstmt, cstmt);
		return successFlag; 
	}

	public static boolean subjectDelete(SubjectVO svo) throws SQLException {
		boolean successFlag =false; 
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(SUBJECT_DELETE);
		pstmt.setInt(1, svo.getSubNo());
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