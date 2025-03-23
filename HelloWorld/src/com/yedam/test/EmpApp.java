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

