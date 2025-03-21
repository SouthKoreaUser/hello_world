package com.yedam.test;

import java.util.Scanner;

public class EmpApp {	
	private static Scanner scanner = new Scanner(System.in);
	private static EmpDAO dao = new EmpDAO();
	
	
	public static void insert() {
		System.out.println("사번입력>> ");
		String emp_no = scanner.nextLine();
		System.out.println("이름입력>> ");
		String emp_name = scanner.nextLine();
		System.out.println("전화번호 입력>>");
		int phone = Integer.parseInt(scanner.nextLine());
		System.out.println("입사일자 입력 (YYYY-MM-DD)>> ");
		String hire_date = scanner.nextLine();
		System.out.println("급여 입력>>");
		int salay = Integer.parseInt(scanner.nextLine());
		
		Employee emp = new Employee(emp_no, emp_name, phone, hire_date, salay);
		
		if (dao.insert(emp)) {
			System.out.println("등록완료");
		} else {
			System.out.println("등록실패");
		}
		
	}
	public static list() {
		System.out.println("목록출력");
		
	}
	public static void main(String[] args) {
		
		// 앱을 실행하는 클래스.
		boolean run = true;
		while(run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건: 입사일자) 6.종료");
			String choice = scanner.nextLine();
			
			switch (choice){
			case "1":
				insert();
				break;
			case "2":
				list();
				break;
			case "3":
				update();
				break;
			case "4":
				delete();
			case "5":
				search();
				break;
			case "6":
				System.out.println("end of prog.");
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				return;
			}
	     	}
		
		// 사원등록

}
}

//
//지금의 내 고민 : 나이는 먹고 내세울 것 하나없는 것 같아서
//일할 때 돈이나 많이 모아둘걸 싶기도 하고 ,, 맨날 돈 펑펑썼는데 탈덕하고 나니
//남는건 좆도없고 그돈으로 악세사리 산건 존나그뤠잇 잘했어 영선아. 그게 남는거지 
//그건 그래도 금이야. 
//는 무슨 땅파면 금나오냐 씨발. 돈 아낄걸, 여행이나 갈걸, 외국어나 공부할걸,,.. 하는 회의감.
//
//너 아직 적금 안깼다. 입학 전까지는 무슨 수를 써도 유지하자.
//
//고민의 이유 : 자바 때문./ 너무 시간낭비하는 것 같다는 기분이 들어서.
//
//현 상황 정리 : 내나이 23. 무경력.
//실업급여 수급중, 개발자 과정 수강중, 내년 26학번 대학재학예정.
//학과는 불교학과(어차피 추천서 받아서 꽂힐거면 진작갔지 ㅆㅂ), 복수전공이 불가피한 상황.
//
//실업급여 수급중이기 때문에 다른 직장을 구하는 것보다 내일배움카드를 발급받아서
//내년 대학 진학시 유리할 만한 과정을 미리 수강하고자 했음.
//어차피 집이 경주라 배울 만한 것도 없고, 배울 수 있는 것도 없음.
//예습 + 대학시 학점을 유리하게 받기 위해서.
//
//과연 이 과정을 중도하차하고 취업한다 한들
//이보다 유리한 상황일 순 없음.
//
//그러던 중 과연 개발자 과정을 대학 4년 동안 배울 수 있을 것인가에 대한 회의.
//그러나 새삼스럽지는 않은 것이 고등학생 때 회계에 대한 회의감과 유사.
//(고등학교 입학 전 예습이 고1 때 유리했던 것은 사실.
//지금의 과정 또한 컴공 관련 과목 선택시 유리할 것.)
//
//+ 완전 쌩신입, 내년 3월 대학 입학 예정이기 때문에 취업 자체가 쉽지도 않을 뿐더러
//대구까지 왕복 교통비(40만원)를 생각한다면 개발자 업무와는 무관하게
//경주에서 취업하는 것이 유리할 수도 있음.
//3200이면 일반 사무직이랑 비슷한 수준 아닌가요 .,?
//
//개발자 초봉을 모르잖아요,근데 어차피 교통비 40생각하면 에바.
//경주 취업이 유리함.
//
//(과정 끝나자 마자 경주에서 닥치는대로 취업한 다음 6개월 존버, 입학하는 것이 유리)
//
//또한 지금 "그냥 회계나 계속할걸"이라는 고민 또한 그나마 억지로라도 배웠기 때문에
//가능한 미련.
//이 또한 마찬가지로 지금은 개발자 과정에 대한 회의가 들더라도 지나보면
//"그냥 개발이나 계속할걸"하는 생각이 들 수 있다.
//
//대학 입학 이후의 진로에 대한 고민.
//
//회계사를 준비하는 것은 어떨까.
//(설령 그렇다 하더라도 지금부터 미리 준비한다는 것은 어불상설.
//1년만에 끝낼 수 있는 공부도 아닐 뿐더러 
//직장생활과의 병행이 쉽지 않을 것. 조급해하지 말자.
//다시 백수신세로 전락할 순 없다. 어차피 공부 똑바로 안할 것)
//
//회계 세무 12학점
//경제학 3학점,
//경영학 6점,
//IT 정보기술 3학점.
// + 지텔프
//
//1학년 내에 필요 요건 충족 후 불교학과로 계속 유지하는 것도 방법일 수 있다.
//타전공생 수강가능여부 확인 필.
//
//나를 힘들게 하는 것 : 다른 사람과의 비교.
//이럴거면 그냥 빨리 대학이나 갔지, 하는 생각도 들고.
//막상 바로 진학했으면 자퇴했을 거면서.....
//인생 자체에 대한 회의도 들고.
//그럴수록 더 열심히 살자.
//지금 억지로 시켜서 하는 일도 똑바로 못하면서 뭘 하겠단건지.
//너가 지금 직장다니면 이만큼 안힘들 자신있니, 없잖아.
//원래 돈받고 하는 일들은 다 개좆같다.
