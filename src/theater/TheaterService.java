package theater;

import java.util.Scanner;

public class TheaterService {
	private TheaterDao dao;
	
	public TheaterService() {
		dao = new TheaterDao();
	}
	
	//상영관 추가 
	//TODO : 상영관명 중복 확인, 정원 수정 어떻게 할것인지 고민 
	public void insert(Scanner sc) { 
		System.out.println("상영관 추가");
		System.out.print("상영관 이름 입력 : ");
		String name = sc.next();
		System.out.print("상영관 정원 입력");
		int max = sc.nextInt();
		System.out.print("잔여석 입력(정원과같은 숫자 입력)"); //굳이 입력안하게해도되는
		int remain = sc.nextInt(); 
		
		dao.insertTheater(new TheaterVo(name,max,remain));
	}
	
	//상영관 삭
	public void delete(Scanner sc) { 
		System.out.println("상영관 삭제");
		System.out.print("삭제할 상영관 이름 입력");
		String name = sc.next();
		
		dao.deleteTheater(name);
	}
	
	
	//상영관 정보조회
	public void infoSeat(Scanner sc){
		System.out.println("상영관 현황 조회(전체좌석/예약된좌석/예약가능한좌석수");
		System.out.print("조회할 상영관 입력 : ");
		String name = sc.next();
		int total = dao.totalSeat(name);
		int resev = dao.remainSeat(name);
		int rem = total - resev;
		System.out.println(name +"의 전체좌석수 : " + total);
		System.out.println(name +"의 예약된좌석수 : " + resev);
		System.out.println(name +"의 얘약가능한 좌석수 : " + rem);
	}
	
	    
		
}

