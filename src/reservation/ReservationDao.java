package reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import dbconn.DBConnect;

public class ReservationDao {
	private DBConnect dbconn;
	
	public ReservationDao() {
		dbconn = DBConnect.getInstance();
	}
	
	public void insert(ReservationVo vo) {
		String sql = "insert into Reservation values(seq_reserve.nextval,?,?,?,?,?,?)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMovieId());
			pstmt.setString(2, vo.getMemberId());
			pstmt.setString(3, vo.getTheaterId());
			pstmt.setString(4, vo.getStartT());
			pstmt.setString(5, vo.getRowN());
			pstmt.setInt(6, vo.getSeatN());
			pstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			System.out.println("중복된 아이디. 다시 입력하시오");
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
	
	public ReservationVo select(int ticketId) {
		ReservationVo vo = null;
		ResultSet rs = null;
		
		String sql="select * from Reservation where ticketN=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ticketId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new ReservationVo(rs.getInt(1), rs.getInt(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			return vo;
			
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


	public void delete(int ticketId) {
		String sql = "delete from Reservation where ticketN=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ticketId);
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
