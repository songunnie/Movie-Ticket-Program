package seat;

import java.sql.Date;

public class SeatVo {
		//row : 열
		//arg1 : 상영관
		//arg2 : 상영날짜
		//arg3 : 상영시간
	private String Screen;
	private Date rDate;
	private String rTime;
	private String row;
	
	public SeatVo() {}
	public SeatVo(String screen, Date rDate, String rTime, String row) {
		//super();
		Screen = screen;
		this.rDate = rDate;
		this.rTime = rTime;
		this.row = row;
	}
	public String getScreen() {
		return Screen;
	}
	public void setScreen(String screen) {
		Screen = screen;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public String getrTime() {
		return rTime;
	}
	public void setrTime(String rTime) {
		this.rTime = rTime;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	@Override
	public String toString() {
		return "SeatVo [Screen=" + Screen + ", rDate=" + rDate + ", rTime=" + rTime + ", row=" + row + "]";
	}
	
	
}


	
	