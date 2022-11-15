package movie;

import java.util.ArrayList;
import java.util.Scanner;

import member1.Member1Dao;
import member1.Member1Service;

public class MovieService {
	private MovieDao dao;

	public MovieService() {
		dao = new MovieDao();
	}

	public void create(Scanner sc) {
		System.out.println("======= 어드민모드: 영화 등록 =======");
		// TheaterId, title, runtime, releaseD, endD, startT, finishT
		System.out.print("서울/경기/부산 중 원하는 상영관을 선택해주세요: ");
		String theaterId = sc.next();

		System.out.print("영화 제목을 정확히 입력해주세요: ");
		sc.nextLine();
		String title = sc.nextLine();

		System.out.print("영화 러닝타임을 0h 0m 형식으로 입력해주세요.(1h 40m): ");
		String runTime = sc.nextLine();

		System.out.print("영화개봉일을 yyyy-mm-dd 형식으로 입력해주세요.: ");
		String releaseD = sc.next();

		System.out.print("영화종영일을 yyyy-mm-dd 형식으로 입력해주세요.: ");
		String endD = sc.next();

		System.out.print("영화 시작 시간을 00:00 형식으로 입력해주세요.(14:25): ");
		String startT = sc.next();

		System.out.print("영화 끝나는 시간을 00:00 형식으로 입력해주세요.(15:10): ");
		String finishT = sc.next();

		dao.insert(new MovieVo(0, Member1Service.loginId, theaterId, title, runTime, releaseD, endD, startT, finishT));
	}

	public void readByTheater(Scanner sc) {
		System.out.println("======= 상영관에 따른 영화 리스트 =======");
		System.out.print("서울/경기/부산 중 원하는 상영관을 선택해주세요: ");
		String theaterId = sc.next();

		ArrayList<MovieVo> list = dao.selectByTheater(theaterId);
		if(list.isEmpty()) {
			System.out.println("해당 영화관은 없습니다. 다시 검색해주세요.");
		} else {
			for (MovieVo vo : list) {
				System.out.println(vo);
			}
		}
	}

	public void readByTitle(Scanner sc) {
		System.out.println("======= 영화 제목으로 영화 정보 찾기 =======");
		System.out.print("영화 제목의 키워드를 입력해주세요.: ");
		sc.nextLine();
		String title = sc.nextLine();

		ArrayList<MovieVo> list = dao.selectByTitle(title);
		if (list.isEmpty()) {
			System.out.println("해당 키워드를 가진 영화가 없습니다.");
		} else {
			for (MovieVo vo : list) {
				System.out.println(vo);
			}
		}
	}

	public void readAll() {
		System.out.println("======= 상영중인 영화 정보 보기 =======");
		ArrayList<MovieVo> list = dao.selectAll();
		for (MovieVo vo : list) {
			System.out.println(vo);
		}
	}

	public void update(Scanner sc) {
		System.out.println("======= 영화정보 수정하기 =======");
		System.out.print("영화에 할당된 번호: ");
		int movieId = sc.nextInt();

		MovieVo vo = dao.selectByNum(movieId);
		if(vo == null) {
			System.out.println("해당 번호의 영화가 없습니다.");
		} else {
			System.out.println(vo);
			System.out.print("new title: ");
			sc.nextLine();
			String title = sc.nextLine();
			dao.edit(new MovieVo(movieId, null, null, title, null, null, null, null, null));
			System.out.println("영화 정보 수정 성공");
		}
	}

	public void delete(Scanner sc) {
		System.out.println("======= 영화 삭제하기 =======");
		System.out.print("삭제를 원하는 영화에 할당된 번호: ");
		int movieId = sc.nextInt();

		dao.deleteOne(movieId);
		System.out.println("영화 삭제 성공");
	}
}
