package dbconn;
//따로 만들어서 dao에서 dbconn 객체를 끌어서 만들어 쓸 수 있게함.
//또다시 작성할 필요 x

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤
public class DBConnect {
	private static DBConnect dbconn = new DBConnect();
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	//같이 프로젝트 할때는 똑같이 set data 넣어놓고 하거나
	//아니면 localhost: 똑같이 해놓으면 됨.
	
	private DBConnect() {}
	
	public static DBConnect getInstance() {
		return dbconn;
	}
	
	public Connection conn() { //로그인한 세션이라고 보면 된다.
		try {
			//드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			//세션수립
			return DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
