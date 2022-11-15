package seat;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconn.DBConnect;
public class SeatDao {

	private DBConnect dbconn;// db연결 객체

	public SeatDao() {
	dbconn = DBConnect.getInstance();
	}
	//상영중인 영화정보
	
	
	//예매할 때 열 선택 
	public String rowValue(String row, String screen, String rDate, String rTime) { 
	//row : 열
	//screen : 상영관
	//rDate : 상영날짜
	//rTime : 상영시간
	String sql = "select " + row + " from seats where theaterid=? and to_char(r_date)=? and r_time=?";
	Connection conn = dbconn.conn();// db연결
	try {
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,screen);
	pstmt.setString(2,rDate);
	pstmt.setString(3,rTime);
	// ResultSet: 검색 결과 테이블
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
	return rs.getString(1);
	}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} finally {
	try {
	conn.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	return null;
	}
	
	//좌석 예약 업데이트
	public void update(String row, String val, String screen, String rDate, String rTime) {
	    
		String sql = "update seats set " + row + "=? where theaterid=? and to_char(r_date)=? and r_time=?";

		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, val);
			pstmt.setString(2, screen);
			pstmt.setString(3, rDate);
			pstmt.setString(4, rTime);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
			conn.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	}


		
}

