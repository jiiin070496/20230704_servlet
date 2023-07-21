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

//dao -> DB와 연동, 기능 위주
//public void getStudentList() {} 로도 쓰임.
public class StudentDao {
	//DB에서 tb_student 테이블에 있는 모든 내용을 읽어서 꺼냄.
	public List<StudentVo> selectListStudent() {
		List<StudentVo> result = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. driver 있다면 로딩함. 없으면 ClassNotFoundException 오류발생
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. connection객체 생성 -> DBMS와 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
//			if(conn!=null) {
//				System.out.println("<DB연결 성공>");
//			} else {
//				System.out.println("<DB연결 실.패.>");
//			}
			// 3. Statement / PrepareStatement 객체 생성 -> conn 객체로부터 - query 문을 실어보냄.
//			stmt = conn.createStatement();
			String query = "select * from tb_student"; //sql or query 라고 이름을 지음.
			pstmt = conn.prepareStatement(query);
			// 4. query문을 실행하고 그 결과값을 return받음
			// select query 문이면 ResultSet 모양
			// insert/update/delete 문이면 int 모양
			ResultSet rs = pstmt.executeQuery();

			// 5. ResultSet에서 Row(record) 한 줄 읽어오기 위해 cursor(포인트)를 이용함.
			result = new ArrayList<StudentVo>();
			while(rs.next() == true) {
				//한 줄 row/record를 읽을 준비 완료
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
			
		} catch (ClassNotFoundException e) {
			// 1. driver (ojdbc.jar)없음
			e.printStackTrace();
		} catch (SQLException e) {
			// 2. DBMS 연결실패
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
//		 확인용 System.out.println(result);
		return result;
		
	} 

}
