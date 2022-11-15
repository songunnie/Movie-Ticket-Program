package theater;
public class TheaterVo {

	private String Id; //상영관 이름
	private int totalSeat; //총 좌석수
	private int remainSeat; //잔여좌석 
	
	public TheaterVo() {}
	public TheaterVo(String Id, int totalSeat, int remainSeat) {
		this.Id = Id;
		this.totalSeat = totalSeat;
		this.remainSeat = remainSeat;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String Id) {
		this.Id = Id;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	public int getRemainSeat() {
		return remainSeat;
	}
	public void setRemainSeat(int remainSeat) {
		this.remainSeat = remainSeat;
	}
	@Override
	public String toString() {
		return "| 상영관: " + Id + "| 전체좌석: " + totalSeat
				+ "| 잔여좌석: " + remainSeat + "|";
	}
	
	
}




/*create table theater(
		theaternum number primary key,
		theaterid  varchar2(20) not Null,
		totalseat number,
		remainseat number);

		create sequence seq_theaternum
						start with 1
						maxvalue 9999
						cycle;
					
		commit; */