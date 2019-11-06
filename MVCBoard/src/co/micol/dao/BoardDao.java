package co.micol.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.dto.BoardDto;

public class BoardDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "tangg";
	String password = "1234";

	public BoardDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BoardDto> select() { // 전체 리스트
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		BoardDto dto;
		String sql = "select * from mvc_board where btitle != '(댓글)' order by bgroup desc, bstep asc";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				dto = new BoardDto(); // dto 초기화
				dto.setId(rs.getInt("bid"));
				dto.setName(rs.getString("bname"));
				dto.setTitle(rs.getString("btitle"));
				dto.setContents(rs.getString("bcontent"));
				dto.setwDate(rs.getDate("bdate"));
				dto.setHit(rs.getInt("bhit"));
				dto.setGroup(rs.getInt("bgroup"));
				dto.setStep(rs.getInt("bstep"));
				dto.setIndent(rs.getInt("bindent"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BoardDto> select(int id) { //세부목록조회
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		
		BoardDto dto;
		String sql = "select * from mvc_board where bgroup = ? order by bid";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				dto = new BoardDto();
				dto.setId(rs.getInt("bid"));
				dto.setName(rs.getString("bname"));
				dto.setTitle(rs.getString("btitle"));
				dto.setContents(rs.getString("bcontent"));
				dto.setwDate(rs.getDate("bdate"));
				dto.setHit(rs.getInt("bhit"));
				dto.setGroup(rs.getInt("bgroup"));
				dto.setStep(rs.getInt("bstep"));
				dto.setIndent(rs.getInt("bindent"));
				list.add(dto);
				viewCountUpdate(rs.getInt("bid")); // 조회수 증가 메소드 호출
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	}

	private void viewCountUpdate(int id) { // 조회수 증가
		String sql = "update mvc_board set bhit = bhit + 1 where bid =" + id;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int insert(BoardDto dto) { // 글 추가
		int n = 0;
		String sql = "insert into mvc_board(bid,bname,btitle,bcontent,bdate,bgroup,bstep,bindent)"
				+ " values(b_name.nextval,?,?,?,?,b_name.currval,0,0)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContents());
			psmt.setDate(4, dto.getwDate());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	public int update(BoardDto dto) { // 글 수정
		int n = 0;
		String sql = "update mvc_board set btitle=?, bcontent=? where bid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContents());
			psmt.setInt(3, dto.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	public int delete(int id) { // 글 삭제
		int n = 0;
		String sql = "delete from mvc_board where bid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
