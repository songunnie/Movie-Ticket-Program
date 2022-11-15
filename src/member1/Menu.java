package member1;

import java.util.Scanner;

import member.MemberService;
import movie.MovieService;
import reservation.ReservationService;
import seat.SeatService;
import theater.TheaterService;

public class Menu {
	private Member1Service mService;
	private MovieService mvService;
	private ReservationService rService;
	private TheaterService tService;
	private SeatService sService;

	public Menu() {
		mService = new Member1Service();
		mvService = new MovieService();
		rService = new ReservationService();
		tService = new TheaterService();
		sService = new SeatService();
	}

	public void run(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while (flag) {
			if (Member1Service.loginId == null) {
				System.out.println("| 1. 로그인 | 2. 회원가입 | 3. 상영정보확인 |  7. 종료  |");
			} else {
				System.out.println("| 3. 상영정보확인 | 4. 영화예매 | 5. 마이페이지 | 6. 로그아웃 |  7. 종료  |");
			}
			m = sc.nextInt();
			switch (m) {
			case 1:
				mService.login(sc);
				break;
			case 2:
				mService.join(sc);
				break;
			case 3:
				mvService.readAll();
				break;
			case 4:
				rvrun(sc);
				break;
			case 5:
				if (Member1Service.loginId.equals("admin")) {
					adminRun(sc);// 관리자모드
				} else {
					userRun(sc);// 일반인모드
				}
				break;
			case 6:
				mService.logout();
				break;
			case 7:
				flag = false;
				break;
				
			}
		}
	}

	public void adminRun(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while (flag) {
			System.out.println("| 1.극장관리 | 2.전체회원목록 | 3. 회원조회 | 4. 회원 삭제 |  5. 종료  |");
			m = sc.nextInt();
			switch (m) {
			case 1:
				mvrun(sc);
				break;
			case 2:
				mService.printAll();
				break;
			case 3:
				mService.printMemberInfo(sc);
				break;
			case 4:
				mService.adminDelete(sc);
				break;
			case 5:
				flag = false;
				break;
			}
		}
	}

	public void userRun(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while (flag) {
			System.out.println("| 1.내정보확인 | 2.내정보수정 | 3. 예매내역확인 |  4.탈퇴  |  5.종료  |");
			m = sc.nextInt();
			switch (m) {
			case 1:
				mService.printMyInfo();
				break;
			case 2:
				mService.editMyInfo(sc);
				break;
			case 3:
				rService.printReservation(sc);
				break;
			case 4:
				mService.out();
				break;
			case 5:
				flag = false;
				break;
			}
		}
	}
	
	//MovieService run.
	public void mvrun(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while(flag) {
			System.out.println("1.영화 등록 2.상영관으로 찾기 3.영화 제목으로 찾기 4.영화 리스트 출력"
					+ " 5.영화 정보 수정 6.영화삭제 7.종료");
			m = sc.nextInt();
			switch(m) {
			case 1:
				mvService.create(sc);
				System.out.println();
				break;
			case 2:
				mvService.readByTheater(sc);
				System.out.println();
				break;
			case 3:
				mvService.readByTitle(sc);
				System.out.println();
				break;
			case 4:
				mvService.readAll();
				System.out.println();
				break;
			case 5:
				mvService.readAll();
				mvService.update(sc);
				System.out.println();
				break;
			case 6:
				mvService.readAll();
				mvService.delete(sc);
				System.out.println();
				break;
			case 7:
				flag = false;
				break;
			}
		}
	}
	
	public void rvrun(Scanner sc) {
		boolean flag=true;
		int m = 0;
		while(flag) {
			System.out.println("1.영화 제목으로 예약 2.상영관으로 예약 3.예약정보 확인 4.예약취소 5.종료");
			m = sc.nextInt();
			switch(m) {
			case 1:
				rService.reserveByMovie(sc);
				break;
			case 2:
				rService.reserveByTheater(sc);
				break;
			case 3:
				rService.printReservation(sc);
				break;
			case 4:
				rService.cancelReservation(sc);
				break;
			case 5:
				flag=false;
				break;
			}
		}
	}
	
	public void trun(Scanner sc) {
		boolean flag=true;
		int m = 0;
		while(flag) {
			
		}
	}
}
