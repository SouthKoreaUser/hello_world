package com.yedam.classes;

import java.util.List;
import java.util.Scanner;

public class MethodMain {
	public static void main(String[] args) {
		Scanner scn;
		officeApp();

	} // end of main.

	static void officeApp() {

		// 목록,추가,수정, 삭제...
		boolean run = true;
		MethodExe2 m2 = new MethodExe2();// 기능정의

		Scanner scn = new Scanner(System.in);
		// 사용자입력 받아서 1.목록, 2.추가, 3.수정, 4.삭제 9.종료 구현.

		while (run) {
			System.out.println("1.목록 2.추가 3.수정 4.삭제 9.종료");
			System.out.println("선택>> ");
			int menu = scn.nextInt();
			scn.nextLine(); // 입력버퍼 비우기
		
			switch (menu) {
			case 1:
				System.out.println("목록출력");
				Product prd = new Product();
				prd.setProductName("ALL");

				List<Product> list = m2.productList(prd);
				for (int i = 0; i < list.size(); i++) {
					
						System.out.println(list.get(i).showList());
					}
				break;
				
			case 2:
				System.out.println("상품코드 입력>> ");
				String code = scn.nextLine();
				System.out.println("상품명 입력>> ");
				String title = scn.nextLine();
				System.out.println("상품가격 입력>> ");
				int price = Integer.parseInt(scn.nextLine());
				Product addprd = new Product(code, title, price);
				if (m2.add(addprd)) {
					System.out.println("등록되었습니다");
				} else {
					System.out.println("등록실패.");
				}
				break;
			case 3:
				System.out.println("상품코드 입력>> ");
				code = scn.nextLine();
				System.out.println("상품명 입력>> ");
				title = scn.nextLine();
				System.out.println("상품가격 입력>> ");
				price = Integer.parseInt(scn.nextLine());
				Product add = new Product (code, title, price);
				if (m2.modify(add)){
					System.out.println("변경완료");
				} else {
					System.out.println("변경실패.");
				}
				break;
			case 4:
				System.out.println("상품코드명 입력>>");
				code = scn.nextLine();
				if(m2.remove(code)) {
					System.out.println("삭제완료.");
				} else {
					System.out.println("삭제실패");
				}
				break;
			case 9:
				System.out.println("종료>>");
				run = false;
				m2.save();
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요");
			}
		}
		// 입력메시지 정의 구현.

	}
}
//	void method4() {
//		MethodExe4 m4 = new MethodExe4;
//		MethodExe4.main();
//		}
//		Scanner scn = new Scanner(System.in);
//
//		boolean run = true;
//		while (run) {
//			System.out.println("1.목록 2.추가 3.수정 4.삭제 9.종료");
//			int menu = Integer.parseInt(scn.nextLine());
////			System.out.println("!");
//			switch (menu) {
//			case 1:
//				System.out.println("목록출력");
//				Product prd = new Product();
//				prd.setProductName("ALL");
//				
//				Product[] list = m2.productList(prd);
//				for(int i = 0; i < list.length; i++) {
//					if(list[i] != null) {
//					System.out.println(list[i].showList());
//					}
//				}
//				
//			case 2:		
//				System.out.println("추가>>");
//				String title = scn.nextLine();
//				if (title != null) {
//					System.out.println("이미 등록되었습니다");
//					return;
//				}	
//			case 3:
//				System.out.println("수정>>");
//				
//			case 4:
//				System.out.println("삭제>>");
//			case 9:
//				System.out.println("종료>>");
//				run : false;
//			defult
//			}
//		}
//	}
//	
//	void method4() {
////		MethodExe4.m4 = new MethodExe4();
////		MethodExe4.main();
//	}
//	
//	void method3() {
//		MethodExe3 m3 = new MethodExe3();
//		System.out.println(m3.gugudan(3, 5));
//	}
//	
//	void printStar(int cnt, String str) {
//		
//	}
//	
//	void method2() {
//		// 상품코드 : M001, 상품명 : 만년필, 가격 10000;
//		MethodExe2 m2 = new MethodExe2();
//		// 상품코드, 상품명, 가격 - modify(Product prod)
//		Product prod = new Product("A001", "지우개1000", 0);
//		if (m2.modify(prod)) {
//			System.out.println("수정성공");
//		}
//		
//		Product search = new Product();
//		search.setProductName("ALL"); // 상품코드, 상품명, 가격
//		search.setPrice(700);
//		
//		Product[] list = m2.productList(search);
//		for (int i = 0; i < list.length; i++) {
//			if (list[i] != null) {
//				System.out.println(list[i].showList());
//			}
//		}
//	} // end.
//	void method1() {
//		MethodExe1 m1 = new MethodExe1();
//		//	System.out.println(m1);
//		// 메소드 호출 ('printString' 괄호 안에는 실제 값이 들어가야함)
//		int n= 5;
//		m1.printString(n, "왕밤빵");
//		
//		double result = m1.sum(n, 10.5);
//		System.out.println(result);
//		
//		int sum = m1.sum(new int[]  { 10, 20, 30} );
//		result = m1.sum(new double[] { 10.5, 22.1, 34.5});
//		System.out.println(sum);
//		}
//	}