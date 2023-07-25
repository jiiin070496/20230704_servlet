package kh.test.jdbckh.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.student.model.vo.StudentVo;

import static kh.test.jdbckh.common.jdbc.jdbcTemplate.*;

//dao -> DB와 연동, 기능 위주
//public void getStudentList() {} 로도 쓰임.
public class StudentDao {
	// DB에서 tb_student 테이블에 있는 모든 내용을 읽어서 꺼냄.
	public List<StudentVo> selectListStudent() { // 전체보기 - 매개 인자가 없으면 전체찾기.
		List<StudentVo> result = null;
		
		String query = "select * from tb_student";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. driver 있다면 로딩함. 없으면 ClassNotFoundException 오류발생

			// 2. connection객체 생성 -> DBMS와 연결

			conn = getConnection();
			// 3. Statement / PrepareStatement 객체 생성 -> conn 객체로부터 - query 문을 실어보냄.
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(query);
			// 4. query문을 실행하고 그 결과값을 return받음
			// select query 문이면 ResultSet 모양
			// insert/update/delete 문이면 int 모양
			rs = pstmt.executeQuery();

			// 5. ResultSet에서 Row(record) 한 줄 읽어오기 위해 cursor(포인트)를 이용함.
			result = new ArrayList<StudentVo>();
			while (rs.next() == true) {
				// 한 줄 row/record를 읽을 준비 완료
//				System.out.println(rs.getString("STUDENT_NAME")); // 컬럼명
				StudentVo vo = new StudentVo();
				vo.setStudentName(rs.getString("student_name"));
				vo.setDepartmentNo(rs.getString("department_no"));
				vo.setStudentNo(rs.getString("student_no"));
				vo.setStudentSsn(rs.getString("student_ssn"));
				vo.setStudentAddress(rs.getString("student_address"));
				vo.setEntranceDate(rs.getDate("entrance_date"));
				vo.setAbsenceYn(rs.getString("absence_yn"));
				vo.setCoachProfessorNo(rs.getString("coach_professor_no"));

				result.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}

	public StudentVo selectOneStudent(String studentNo) {
		System.out.println("DAO selectOneStudent() arg:" + studentNo);

		StudentVo result = null;
		
		String query = "select s.* "
				+ " , (select department_name from tb_department where department_no=s.department_no) department_name "
				+ " from "
				+ " tb_student s where student_no = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, studentNo);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = new StudentVo();
				// while 동작시킬필요없음. query 결과가 단일행일 것이므로
				result.setAbsenceYn(rset.getString("Absence_Yn"));
				result.setCoachProfessorNo(rset.getString("Coach_Professor_No"));
				result.setDepartmentNo(rset.getString("Department_No"));
				result.setEntranceDate(rset.getDate("Entrance_Date"));
				result.setStudentAddress(rset.getString("Student_Address"));
				result.setStudentName(rset.getString("student_Name"));
				result.setStudentNo(rset.getString("student_No"));
				result.setStudentSsn(rset.getString("Student_Ssn"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);			 
		}
		System.out.println(result);
		return result;
	}

	public List<StudentVo> selectListStudent(String searchWord) { // 검색
		List<StudentVo> result = null;
		String query = "select * from tb_student where student_name like ? or student_address like ?";
		// like연산자인 경우 위치홀더? 대신 연결자 사용
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. driver 있다면 로딩함. 없으면 ClassNotFoundException 오류발생
			
			// 2. connection객체 생성 -> DBMS와 연결

			conn = getConnection();
			// 3. Statement / PrepareStatement 객체 생성 -> conn 객체로부터 - query 문을 실어보냄.
			pstmt = conn.prepareStatement(query);

			// 3과 4 사이 위치홀더 ? 에 값 설정
			searchWord = "%" + searchWord + "%"; // like 연산자인 경우 % 또는 _ 를 합쳐서 만듬
			pstmt.setString(1, searchWord);
			pstmt.setString(2, searchWord);

			// 4. query문을 실행하고 그 결과값을 return받음
			// select query 문이면 ResultSet 모양
			// insert/update/delete 문이면 int 모양
			
			rs = pstmt.executeQuery();

			// 5. ResultSet에서 Row(record) 한 줄 읽어오기 위해 cursor(포인트)를 이용함.
			if (rs.next()) {
				result = new ArrayList<StudentVo>();
				do {
					// 한 줄 row/record를 읽을 준비 완료
					// System.out.println(rs.getString("STUDENT_NAME")); // 컬럼명
					StudentVo vo = new StudentVo();
					vo.setStudentName(rs.getString("student_name"));
					vo.setDepartmentNo(rs.getString("department_no"));
					vo.setStudentNo(rs.getString("student_no"));
					vo.setStudentSsn(rs.getString("student_ssn"));
					vo.setStudentAddress(rs.getString("student_address"));
					vo.setEntranceDate(rs.getDate("entrance_date"));
					vo.setAbsenceYn(rs.getString("absence_yn"));
					vo.setCoachProfessorNo(rs.getString("coach_professor_no"));

					result.add(vo);
				} while (rs.next() == true);
			}

		} catch (SQLException e) {
			// 2. DBMS 연결실패
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}

	public List<StudentVo> selectListStudent(int currentPage, int pageSize ) { // 페이징처리
		List<StudentVo> result = new ArrayList<StudentVo>();
		
		String queryTotalCnt = "select count(*) cnt  from tb_student";
		String query = " select * from "
				+ " (\r\n"
				+ " select tb1.*, rownum rn from"
				+ "    (select * from tb_student order by student_no asc) tb1"
				+ " ) tb2"
				+ " where rn between ? and ?";
		
		Connection conn = null;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int totalCnt = 0;  // 총 글개수
		int startRownum = 0;
		int endRownum = 0;
		
		try {
			conn = getConnection();
			// 총 개수를 알아오기위한 query 실행
			pstmt = conn.prepareStatement(queryTotalCnt);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {  //읽은 갯수가 있다면
				//totalCnt = rs.getInt("count(*)"); 오류. 함수는 컬럼명이 될 수 없음 
				totalCnt = rs.getInt("cnt");
			}
			System.out.println("총 글개수: "+totalCnt);
			
			startRownum = (currentPage -1)*pageSize +1;
			endRownum = (currentPage*pageSize > totalCnt) ? totalCnt : (currentPage*pageSize);
			
			System.out.println("startRownum: "+startRownum);
			System.out.println("endRownum: "+endRownum);
			
			// conn 생성으로 2개의 query(select)문을 실행할때
			close(rs);
			close(pstmt);
			
			// 페이지당 글 읽어오기 위한 query 실행
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRownum);
			pstmt.setInt(2, endRownum);
			rs = pstmt.executeQuery();		
			
			// 5. ResultSet에서 Row(record) 한 줄 읽어오기 위해 cursor(포인트)를 이용함.
			result = new ArrayList<StudentVo>();
			while (rs.next() == true) {
				// 한 줄 row/record를 읽을 준비 완료
//				System.out.println(rs.getString("STUDENT_NAME")); // 컬럼명
				StudentVo vo = new StudentVo();
				vo.setStudentName(rs.getString("student_name"));
				vo.setDepartmentNo(rs.getString("department_no"));
				vo.setStudentNo(rs.getString("student_no"));
				vo.setStudentSsn(rs.getString("student_ssn"));
				vo.setStudentAddress(rs.getString("student_address"));
				vo.setEntranceDate(rs.getDate("entrance_date"));
				vo.setAbsenceYn(rs.getString("absence_yn"));
				vo.setCoachProfessorNo(rs.getString("coach_professor_no"));

				result.add(vo);
			}

		} catch (SQLException e) {
			// 2. DBMS 연결실패
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}

}
