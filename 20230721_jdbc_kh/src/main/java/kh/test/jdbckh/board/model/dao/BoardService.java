package kh.test.jdbckh.board.model.dao;

import static kh.test.jdbckh.common.jdbc.jdbcTemplate.close;
import static kh.test.jdbckh.common.jdbc.jdbcTemplate.getConnectionkhl;

import java.sql.Connection;
import java.util.List;

import kh.test.jdbckh.board.model.dto.BoardDto;

public class BoardService {

	private BoardDao dao = new BoardDao();
	
	public List<BoardDto> selectList(){
		List<BoardDto> result = null;
		Connection conn = getConnectionkhl();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	
	public BoardDto selectOne(int bno) {
		BoardDto result = null;
		Connection conn = getConnectionkhl();
		result = dao.selectOne(conn, bno);
		close(conn);
		return result;
	}
	
	public int insert(BoardDto dto) {
		int result = 0;
		Connection conn = getConnectionkhl();
		result = dao.insert(conn, dto);
		close(conn);
		return result;
	}
	
	public int update(BoardDto dto) {
		int result = 0;
		Connection conn = getConnectionkhl();
		result = dao.update(conn, dto);
		close(conn);
		return result;
	}
	
	public int delete(int bno) {
		int result = 0;
		Connection conn = getConnectionkhl();
		result = dao.delete(conn, bno);
		close(conn);
		return result;
	}
	
	public int getTotalCount(String searchWord) {
		int result = 0;
		Connection conn = getConnectionkhl();
		result = dao.getTotalCount(conn, searchWord);
		close(conn);
		return result;
	}
	
	public List<BoardDto> selectList(int currentPage, int pageSize, String searchWord){
		List<BoardDto> result = null;
		Connection conn = getConnectionkhl();
		int totalCount = getTotalCount(searchWord);
		result = dao.selectList(conn, currentPage, pageSize, searchWord);
		close(conn);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
