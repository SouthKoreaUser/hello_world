package com.yedam.bookApp;

import java.util.Scanner;

/*
 * 등록, 수정, 삭제, 목록  다른 값이 들어올 경우
 */

public class BookMain {
	// 2. 정적필드. 할당.
	private static BookMain instance = new BookMain();
	// 1. 생성자 private 선언.
	private BookMain() {
		
	}
	// 3. getInstance() 제공.
	public static BookMain getInstance() {
		return instance;
	}
	
	// 저장공간.
	 //Book[] bookStore = new Book[100];
//	 User[] members = {new User("user01", "홍길동", "1111")
//			 , new User("user02", "김민규", "2222")
//			 , new User("user03", "김민식", "3333")};
	
	 // 스캐너 객체선언.
	 Scanner scn = new Scanner(System.in);
	 // jdbc 처리.
	 bookjdbc dao = new bookjdbc();
	 
	 // 아이디, 비밀번호 입력.
	 private User login(String id, String pw) {
		 MemberJdbc dao = new MemberJdbc();
		 return dao.login(id, pw);
//	 	for(int i = 0; i < members.length; i++) {
//	 		if (members[i] !=null &&members[i].getUserid().equals(id) && (members[i].getPassword().equals(pw))) {
//	 			return true;
//	 		}
//	 	}
//	 	return false;
	 }
	// 순번생성.
	public int getSequnceNo() {
		int max = 0;
//		for (int i = 0; i < bookStore.length; i++) {
//			if (bookStore[i] != null && bookStore[i].getOrderNo() > max) {
//				max = bookStore[i].getOrderNo();
//			}
//		}
		return max + 1; // 현재 마지막 번호 + 1;
	} // end of getSequnceNo().
	
	// 등록.
	// 1. 이미 존재하는 제목은 입력 불가
	public void add() {
		
		System.out.print("도서코드입력>> ");
		String bookcode = scn.nextLine();
//		
//		if (searchBook(bookcode) != null) {
//			System.out.println("이미 등록된 도서코드입니다.");
//			return;
//		}
		System.out.print("제목입력>> ");
		String title = scn.nextLine();
		System.out.print("저자입력>> ");
		String author = scn.nextLine();
		System.out.print("출판사입력>> ");
		String company = scn.nextLine();
		System.out.print("금액입력>> ");
		String price = scn.nextLine();
		// 입력항목을 확인
		if (title.isBlank() || author.isBlank() || company.isBlank() || price.isBlank()) {
			System.out.print("항목을 입력하세요>>");
			return; // 메소드 종료.
		}
		// Book 데이터를 생성.
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setBookCode(bookcode);
		book.setPrice(Integer.parseInt(price));
		book.setCompany(company);
		
		// 배열에 추가. - > ojdbc로 변경
			if (dao.insert(book)) {
				System.out.println("등록되었습니다.");
			} else {
				System.out.println("등록예외.");
			}
	} // end of add().

	private  Object searchBook(String title) {
		return null;
	}

	// 수정
	public  void edit() {
		// 책제목을 입력하지 않으면 메소드를 종료하는 방식
		System.out.print("도서코드입력>>");
		String bcode = scn.nextLine();
		if (bcode.isBlank()) {
			System.out.println("도서코드를 반드시 입력");
			return;
		}
		
		System.out.print("저자입력>> ");
		String author = scn.nextLine();
		System.out.print("제목입력>> ");
		String title = scn.nextLine();
		System.out.print("금액입력>> ");
		String price = scn.nextLine();
		
		// update (파라미터)
		Book book = new Book();
		book.setBookCode(bcode);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(Integer.parseInt(price));
		
		// 조회 및 수정.
//		boolean isExist = false;
//		for (int i = 0; i < bookStore.length; i++) {
//			if (bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
//				// 항목수정.
//				if (!author.isBlank()) {
//					bookStore[i].setAuthor(author);
//				}
//				if (!company.isBlank()) {
//					bookStore[i].setCompany(company);
//				}
//				if (!price.isBlank()) {
//					bookStore[i].setPrice(Integer.parseInt(price));
//				}
//				isExist = true;
//				System.out.println("수정완료.");
//			}
//		}
		// 찾을 책이 없을 경우 메시지
		if (dao.update(book)) {
			System.out.println("수정성공.");
		} else {
			System.out.println("수정예외.");
		}
	}// end of edit();
	
	public  void delete() {
		// 책제목을 입력하지 않으면 반드시 값을 입력받는 방식.
		String bcode = " ";
		while (true) {
			System.out.print("도서코드입력>>");
			bcode = scn.nextLine();
			if (!bcode.isBlank()) { // 제목을 입력한 경우에..
				break;
			}
			System.out.println("코드를 입력하세요!!");
		}
		// 삭제.
		boolean isExist = false;
		for (int i = 0; i < bcode.length(); i++) {
			if (bcode != null && bcode.equals(bcode)) {
				bcode = null;
				System.out.println("삭제완료.");
				isExist = true;
				break;
			}
		}
		// 찾는 책이 없을 경우에 메시지.
		if (!isExist) {
			System.out.println("찾을 수 없습니다.");
		}
	}// end of delete;
	
	public  void list() {
	// 순번정렬
	// 순번 1> 순번 2, 제외 :순번 2(null), 순번1 (null)
		Book temp = null;
		for (int i = 0; i < bcode.length -1; i++) {
			for (int j = 0; j < bcode.length - 1; j++) {
				if (bcode[j + 1] == null) { // 변경 x
					continue;
				}
				if (bcode[j] == null // 변경 o
						|| bcode[j].getOrderNo() > bcode[j + 1].getOrderNo()) {
					temp = bcode[j];
					bcode[j] = bcode[j + 1];
					bcode[j] = temp;
				}
			}
		} // end of for.
		
		int seqNo = 1;
		System.out.println("순번  제목       저자  가격");
		System.out.println("======================");
		for (Book bok : bcode) {
			if(bok != null) {
				
				System.out.println(seqNo++ + " " + bok.showList());
				}
			}
		}
	 // end of list();
		// list 와 listCompany에서 활용할 공통메소드
		public  Book[] searchList(String keyword) {
			Book[] list = new Book[100];
			int idx = 0;
			for (int i = 0; i < bcode.length; i++) {
				if(bcode[i] != null) 
					if(keyword == null || bcode[i].getCompany().equals(keyword)){
						list[idx++] = bcode[i];
						}
				}
				return list;
		}
	
	
		public  void listCompany() {
		System.out.print("조회할 출판사 정보>> ");
		String company = scn.nextLine();
		
		int seqNo = 1;
		System.out.println("순번  제목       저자  가격");
		System.out.println("======================");
		Book[] list = searchList(company);
		for (Book bok : bcode) {
			if(bok != null) {
				if (bok.getCompany().equals(company)) {
					System.out.println(seqNo++ + " " + bok.showList());
		}
	}
	
}
	}// end of listCompany.

	public  void bookInfo() {
		// 반드시 값을 입력받도록.
		String title = " ";
		while (true) {
			System.out.print("제목입력>> ");
			title = scn.nextLine();
			if (!title.isBlank()) { // 제목을 입력한 경우에..
				break;
			}
			System.out.println("제목을 입력하세요.");
		}		
	// 상세조회.
	Book result = searchBook1(title);
	if (result == null) {
		System.out.println("조회결과가 없습니다.");
		return;
		}
	System.out.println(result.showBookInfo());
	} // end of bookInfo();
	
	// 도서명으로 조회하는 기능
	public  Book searchBook1(String bcode) {
		return null; // 조회결과가 없을 경우에는 null 을 반환.
	} // end of searchBook(String title).
	
	public  void main(String[] args) {
		// id, password 확인
		while(true) {
			System.out.print("id입력>>");
			String id = scn.nextLine();
			System.out.println("password입력>>");
			String pw = scn.nextLine();
			// User 클래스, Map 컬렉션.
			User user = login (id, pw);
			if (user != null) {
				System.out.println(user.getUserName() + ", 환영합니다.");
				break;
			}
			// id, password 비정상.
			System.out.println("id와 password를 확인하세요.");
		}
		
	
		// 저장공간.
		boolean run = true; // 반복문을 위한 변수
		while (run) {
			System.out.println("1.도서등록 2.수정 3.삭제 4.목록 5.상세조회 9.종료");
			System.out.print("선택>> ");
			// 예외처리.
			int menu = 0;
			while (true) {
			try {
				menu = Integer.parseInt(scn.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("정수값을 입력하세요.");
			}
		}
	}
		System.out.println("end of prog.");
	}// end of main().
	
	
	
}