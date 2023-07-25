package kh.test.jdbckh.department.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.department.model.vo.DepartmentVo;
import kh.test.jdbckh.student.model.vo.StudentVo;

public class DepartmentDao {

	public List<DepartmentVo> selectListDepartment(){
		List<DepartmentVo> result = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

			String query = "select * from tb_department";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			result = new ArrayList<DepartmentVo>();
			while(rs.next() == true) {
				DepartmentVo vo = new DepartmentVo();
				vo.setDepartmentNo(rs.getString("department_No"));
				vo.setDepartmentName(rs.getString("department_Name"));
				vo.setCategory(rs.getString("category"));
				vo.setOpenYn(rs.getString("open_Yn"));
				vo.setCapacity(rs.getInt("capacity"));
				
				result.add(vo);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
				
		return result;
		
	}
	public DepartmentVo selectOneDepartment(String DepartmentNo) {
		System.out.println("DAO selectOneDepartment() arg:"+ DepartmentNo);

		DepartmentVo result = null;
		String query = "select * from tb_department where department_no = "+"'"+DepartmentNo+"'";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","kh");

			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = new DepartmentVo();
				// while 동작시킬필요없음. query 결과가 단일행일 것이므로
				result.setDepartmentNo(rset.getString("department_No"));
				result.setDepartmentName(rset.getString("department_Name"));
				result.setCategory(rset.getString("category"));
				result.setOpenYn(rset.getString("open_Yn"));
				result.setCapacity(rset.getInt("capacity"));
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println(result);
		return result;		
	}
	
	public List<DepartmentVo> selectListDepartment(String searchWord){
		List<DepartmentVo> result = null;
		String query = "select * from tb_department where department_name like ?";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

			pstmt = conn.prepareStatement(query);
			//3과 4 사이 위치홀더 ? 에 값 설정
			searchWord = "%"+searchWord+"%";  //like 연산자인 경우 % 또는 _ 를 합쳐서 만듬
			pstmt.setString(1, searchWord);
//			pstmt.setString(2, searchWord);
			// 4. query문을 실행하고 그 결과값을 return받음
			// select query 문이면 ResultSet 모양
			// insert/update/delete 문이면 int 모양
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new ArrayList<DepartmentVo>();
				
				do {
					DepartmentVo vo = new DepartmentVo();
					vo.setDepartmentNo(rs.getString("department_No"));
					vo.setDepartmentName(rs.getString("department_Name"));
					vo.setCategory(rs.getString("category"));
					vo.setOpenYn(rs.getString("open_Yn"));
					vo.setCapacity(rs.getInt("capacity"));
					
					result.add(vo);
					
				}while(rs.next() == true);
			}
		
		}  catch (ClassNotFoundException e) {
			// 1. driver (ojdbc.jar)없음
			e.printStackTrace();
		} catch (SQLException e) {
			// 2. DBMS 연결실패
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null)
					rs.close();
				if (pstmt!=null)
					pstmt.close();
				if (conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
}
