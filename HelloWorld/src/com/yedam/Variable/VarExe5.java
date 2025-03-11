package com.yedam.Variable;

import java.util.Scanner;

// 예금, 출금, 잔고 확인가능

public class VarExe5 {
	public static void main(String[] args) {
		boolean run = true;
		int balance = 0; //예금액을 저장하는 변수.
		//최대 10만원, 잔액 > 0 조건식
		int amt = 0;
		Scanner scn = new Scanner(System.in);
			while(run) {
				System.out.println("1. 예금 2. 출금 3. 잔고 4. 종료");
				int menu = scn.nextInt();
				switch(menu) {
				case 1:
					System.out.print("입금 금액을 입력>>");
					amt = scn.nextInt();
					//최대잔고 10만원
					if (balance + amt > 100000) {
						System.out.println("10만원을 초과합니다.");
					}else {
						balance = balance + amt;
					}
					break; //case 1 종료.
				case 2:
					System.out.print("출금 금액을 입력>>");
					amt = scn.nextInt();
					// 잔고가 안되도록
					if (balance < amt) {
						System.out.println("잔액초과 출금할 수 없습니다.ㅣ");
					}else {
						balance = balance - amt;
					}
					break; //case 2 종료.
				case 3:
					System.out.print("잔액은" + balance + "입니다");
					break; //case 3 종료.
				case 4:
					run = false;
				}
			}System.out.println("end of prog.");
	} // end of main().
}