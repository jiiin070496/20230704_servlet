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
	
}
