package reservation;

import movie.MovieVo;

public class ReservationVo {
	private int ticketN;
	private int movieId;
	private String memberId;
	private String theaterId;
	private String startT;
	private String rowN;
	private int seatN;
	private MovieVo mVo;
	
	public ReservationVo() {}
	
	public ReservationVo(int ticketN, int movieId, String memberId, String theaterId, String startT, String rowN, int seatN) {
		this.ticketN = ticketN;
		this.movieId = movieId;
		this.memberId = memberId;
		this.theaterId = theaterId;
		this.startT = startT;
		this.rowN = rowN;
		this.seatN = seatN;
	}
	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public int getTicketN() {
		return ticketN;
	}
	public void setTicketN(int ticketN) {
		this.ticketN = ticketN;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getStartT() {
		return startT;
	}
	public void setStartT(String startT) {
		this.startT = startT;
	}
	public String getRowN() {
		return rowN;
	}
	public void setRowN(String rowN) {
		this.rowN = rowN;
	}
	public int getSeatN() {
		return seatN;
	}
	public void setSeatN(int seatN) {
		this.seatN = seatN;
	}
	

	@Override
	public String toString() {
//		return "[ticketN=" + ticketN + ", movieId=" + movieId + ", memberId=" + memberId + ", theaterId="
//				+ theaterId + ", startT=" + startT + ", rowN=" + rowN + ", seatN=" + seatN + "]";
		return "========== 영화 티켓 ==========" + "\n" + "    티켓 번호: " + ticketN + "\n"
				+ "    상영관: " + theaterId + "\n"
				+ "    상영 시작 시간: " + startT + "\n" + "    좌석: " + rowN + "열" + seatN + "번" + "\n"
				+ "=============================";
	}
	
}
