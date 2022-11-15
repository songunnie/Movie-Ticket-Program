package theater;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import dbconn.DBConnect;
//TODO 1. 상영관 정보(추가/수정/삭제)
// 수정에서 총 좌석수, 잔여좌석수 실시간 연계필요한지? 아니면 단순히 숫자수정으로 구현
import seat.SeatVo;
  




public class TheaterDao {
private DBConnect dbconn; //DB연결 객체 
	public SeatVo vo;
	
	
	public TheaterDao() {
		dbconn = DBConnect.getInstance();
		
	}
	
	
	//상영관 추가 
	public void insertTheater(TheaterVo vo) 
	{
		String sql = "insert into theater values(?,?,?)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, vo.getTotalSeat());
			pstmt.executeUpdate();
			System.out.println("신규 상영관이 추가되었습니다.");
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("중복된 상영관 다시 입력하시오");
		}catch (SQLException e) {
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
	//상영관 정보 삭제
	public void deleteTheater(String id) { 
	String sql = "delete from theater where id=?";
	Connection conn = dbconn.conn();
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);		
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
	//
	public void getRow(String row, String thid) { //열 전 받아오
		String sql = "select" + "?" + "from seats where theaterid= ?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, row);
			pstmt.setString(2, thid);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<String> list = new ArrayList<>();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			for(int i =0; i <  list.size(); i++){
				list.get(i);
				System.out.println(i);
		} 
		}catch (SQLException e) {
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
	
	//전체좌석 검색 
	public int totalSeat(String thid) {
		String sql = "select sum(LENGTH(a)+LENGTH(b)+LENGTH(c)+LENGTH(d)+LENGTH(e)) from seats where THEATERid = ?"; // a~e열의 총 자리
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, thid);
			ResultSet rs = pstmt.executeQuery();
			int count = 0;
			while(rs.next()) {
				count = rs.getInt(1);
			}
				return count;
//			String count = "";
//			while(rs.next()) {
//				count = rs.getString(1);
//				
		}
			 catch (SQLException e) {
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
		return 0; 
}
	
	//상영관 이름으로 예약된 좌석수 검색
	public  int remainSeat(String thid) {
		String sql = "SELECT sum(LENGTH(a)-LENGTH(REPLACE(a,'1','')) + LENGTH(b)-LENGTH(REPLACE(b,'1',''))"
				+ " + LENGTH(c)-LENGTH(REPLACE(c,'1','')) +LENGTH(d)-LENGTH(REPLACE(d,'1','')) +LENGTH(e)-LENGTH(REPLACE(e,'1','')))"
				+ "as reserve from seats where THEATERid =?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, thid);
			ResultSet rs = pstmt.executeQuery();
			int count = 0;
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
//			String count = "";
//			while(rs.next()) {
//				count = rs.getString(1);
//				}
		}
			 catch (SQLException e) {
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
		return 0;
	}
}

	
//	public void CountReserveSeat() { //
//		vo.setRow("a");//
		
//	}
//}
		
	
	/*public void UpdateTheater(TheaterVo vo) { //상영관이름 입력받아 상영관 이름 수정 
	
	
	String sql = "update Theater set =? where id=?";
	Connection conn = dbconn.conn();
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getId());
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
 */
	
	

  
