package movie;

public class MovieVo {
	private int movieId;
	private String managing;
	private String theaterId;
	private String title;
	private String runTime;
	private String releaseD; //개봉일
	private String endD; //종영일
	private String startT;
	private String finishT;
	
	MovieVo () {}

	public MovieVo(int movieId, String managing, String theaterId, String title, String runTime, String releaseD, String endD, String startT,
			String finishT) {
		this.movieId = movieId;
		this.managing = managing;
		this.theaterId = theaterId;
		this.title = title;
		this.runTime = runTime;
		this.releaseD = releaseD;
		this.endD = endD;
		this.startT = startT;
		this.finishT = finishT;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public String getManaging() {
		return managing;
	}
	
	public void setManaging(String managing) {
		this.managing = managing;
	}

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getReleaseD() {
		return releaseD;
	}

	public void setReleaseD(String releaseD) {
		this.releaseD = releaseD;
	}

	public String getEndD() {
		return endD;
	}

	public void setEndD(String endD) {
		this.endD = endD;
	}

	public String getStartT() {
		return startT;
	}

	public void setStartT(String startT) {
		this.startT = startT;
	}

	public String getFinishT() {
		return finishT;
	}

	public void setFinishT(String finishT) {
		this.finishT = finishT;
	}

	@Override
	public String toString() {
		return "영화번호:" + movieId + "| 영화상영관:" + theaterId + "| 영화제목:" + title + "| 러닝타임:" + runTime
				+ "| 개봉일:" + releaseD + "| 종영일:" + endD + "| 시작시간:" + startT + "| 끝나는시간:" + finishT
				+ "|";
	}
}
