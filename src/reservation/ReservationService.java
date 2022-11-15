package reservation;

//import java.util.ArrayList;
import java.util.Scanner;

import member1.Member1Service;
import movie.MovieVo;
import movie.MovieDao;
import movie.MovieService;


public class ReservationService {
	
	private MovieDao movDao;
	private ReservationDao dao;
	private MovieService movService;
	
	//int[][] seat = new int[5][5];
	
	public ReservationService() {
		dao = new ReservationDao();
		movDao = new MovieDao();
		movService = new MovieService();
	}
	
	
//	//좌석 예약(배열 출력)
//	public void printSeat() {
//		for(int i=0; i<seat.length; i++) {
//			for(int j=0; j<seat[i].length; j++) {
//				System.out.print(seat[i][j]+"  ");
//			}
//			System.out.println();
//		}
//	}
	
	
//	public void reserveSeat(Scanner sc) {
//		printSeat();
//		System.out.println("좌석 열을 입력하시오");
//		char r = sc.next().charAt(0);
//		int rIdx = r - 97;
//		System.out.println("좌석 번호를 입력하시오");
//		int sIdx = sc.nextInt()-1;
//		seat[rIdx][sIdx] = 1;
//		printSeat();
//	}
	

	
	
	//영화 예매시 쓰일 영화 번호, 좌석 입력하는 method
	public void reserve(Scanner sc) {
		System.out.println("예매할 영화의 번호를 입력하시오");
		int movieId = sc.nextInt();
		MovieVo mVo = movDao.selectByNum(movieId);
		String theaterId = mVo.getTheaterId();
		String startT = mVo.getStartT();
		String rowN = "";
		int seatN = 0;
		boolean flag=true;
		while(flag) {
			System.out.println("좌석 열을 입력하시오(a,b,c,d,e 중 택1).");
			rowN = sc.next();
			if(!rowN.equals("a") && !rowN.equals("b") && !rowN.equals("c")&&!rowN.equals("d")&&!rowN.equals("e")) {
				System.out.println("존재하지 않는 열입니다. 다시 입력하세요");
			}
			else {
				flag=false;
			}
		}
		flag=true;
		while(flag) {
			System.out.println("좌석 번호를 입력하시오(1~16 중 택1).");
			seatN = sc.nextInt();
			if(seatN<1 || seatN>16) {
				System.out.println("존재하지 않는 좌석입니다. 다시 입력하세요");
			}
			else {
				flag=false;
			}
		}
		ReservationVo vo = new ReservationVo(0, movieId, Member1Service.loginId, theaterId, startT, rowN, seatN);
		dao.insert(vo);
		System.out.println("예약 완료");
	}
	
	//영화 예매1
	//1. MovieService class에서 영화 제목으로 검색하는 method 가져와서 원하는 영화 리스트 출력
	//2. MovieId 입력 후 좌석 정해서 예약 완료
	public void reserveByMovie(Scanner sc) {
		if(Member1Service.loginId.equals(null)) {
			System.out.println("비회원은 예약 불가. 상영 중인 영화 목록 확인만 가능");
		}
		else {
			movService.readByTitle(sc);
			
			//ArrayList로 나온 값 중 하나를 선택해서, reserve 들어가야 하는 상황
			
			reserve(sc);
		}
	}
	
	//영화 예매2
	//1. MovieService class에서 상영관 검색하는 method 가져와서 해당 장소에서 상영 중인 영화 리스트 출력
	//2. MovieId 입력 후 좌석 정해서 예약 완료
	public void reserveByTheater(Scanner sc) {
		if(Member1Service.loginId.equals(null)) {
			System.out.println("비회원은 예약 불가. 상영 중인 영화 목록 확인만 가능");
		}
		else {
			movService.readByTheater(sc);
			reserve(sc);
		}
	}
	
	//티켓 번호로 예약 조회
//	public void printReservation(Scanner sc) {
//		System.out.println("====티켓 번호로 예약 확인====");
//		System.out.println("티켓 번호 입력:");
//		int num = sc.nextInt();
//		ReservationVo vo = dao.select(num);
//		if(vo==null) {
//			System.out.println("없는 티켓 번호");
//			return;
//		}
//		else {
//			System.out.println(dao.select(num));
//		}
//	}
	
	public void printReservation(Scanner sc) {
		System.out.println("====티켓 번호로 예약 확인====");
		System.out.println("티켓 번호 입력:");
		int num = sc.nextInt();
		ReservationVo vo = dao.select(num);
		if(vo==null) {
			System.out.println("없는 티켓 번호");
			return;
		}
		//수정한 부분입니다!
		else {
			if(Member1Service.loginId.equals(vo.getMemberId())) {
				System.out.println(dao.select(num));
			}
			else {
				System.out.println("본인이 예매한 티켓 번호가 아닙니다.");
			}
		}
	}
	
	
	
	//예약 취소
	public void cancelReservation(Scanner sc) {
		System.out.println("====예약 취소====");
		System.out.println("취소할 티켓 번호 입력");
		int num = sc.nextInt();
		ReservationVo vo = dao.select(num);
		if(vo == null) {
			System.out.println("없는 티켓 번호");
			return;
		}
		else {
			if(Member1Service.loginId.equals(vo.getMemberId())) {
				dao.delete(num);
				System.out.println("취소 완료");
			} else {
				System.out.println("본인이 예매한 티켓만 예약 취소 가능합니다.");
			}
		}
	}
	
	//상영관선택
	//영화선택
	//시간대선택
	//좌석선택
	//syso "예약하시겠습니까?" y/n "예약되었습니다"
	
}
