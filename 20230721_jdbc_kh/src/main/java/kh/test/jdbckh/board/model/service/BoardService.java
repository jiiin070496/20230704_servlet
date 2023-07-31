package kh.test.jdbckh.board.model.service;

import static kh.test.jdbckh.common.jdbc.jdbcTemplate.close;
import static kh.test.jdbckh.common.jdbc.jdbcTemplate.getConnectionkhl;

import static kh.test.jdbckh.common.jdbc.jdbcTemplate.setAutocommit;
import static kh.test.jdbckh.common.jdbc.jdbcTemplate.commit;
import static kh.test.jdbckh.common.jdbc.jdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import kh.test.jdbckh.board.model.dao.BoardDao;
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
	
	//한 행 읽기 -pk
	public BoardDto selectOne(int bno) {
		BoardDto result = null;
		Connection conn = getConnectionkhl();
		result = dao.selectOne(conn, bno);
		close(conn);
		return result;
	}
	
	//한 행 삽입
	public int insert(BoardDto dto) {
		int result = 0;
		Connection conn = getConnectionkhl();
		result = dao.insert(conn, dto);
		setAutocommit(conn, false);
		if(dto.getBno()==0) { //원본 글 작성
			result = dao.update(conn, dto);
		}else {
			result = dao.update(conn, dto);
			if(result > -1) {
				result = dao.insert(conn, dto);
			}
		}
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);		
		}
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
		result = dao.delete(conn, null);
		close(conn);
		return result;
	}
//	
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
		result = dao.selectList(conn, currentPage, pageSize, totalCount, searchWord);
		close(conn);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
