package com.yedam.ref;

import com.yedam.Variable.Member;

public class ArrayExe2 {
	public static void main(String[] args) {
		String[] strAry = {"Hello", "World", "20", "23.4" };
		// 확장 for. 배열의 크기가 정해져있는
		for (String str : strAry) {
			System.out.println(str);
		}
		// 크기지정.
		strAry = new String[10]; // 정수의 크기가 정해지면 정수의 초기값은 0, 객체의 초기값 null // {null, null, ... , null}
		strAry[0] = new String("Nice");
		for (String str : strAry) {
			System.out.println(str);
		}
		// Member 클래스.
		Member[] memAry = new Member[10]; // {null, null, ..., null};
		memAry[0] = new Member(); // 인스턴스 생성(객체생성)
		memAry[0].setMember("홍길동", 80); // 80 -> 90
		memAry[0].setScore(90);
		memAry[0].showInfo();
		
		memAry[1] = new Member();
		memAry[1].setMember("박민동", 85); // 85 -> 95
		memAry[1].setScore(100);
		memAry[1].showInfo();
		
		memAry[2] = new Member("최민혁", 77);
		memAry[2].showInfo();
		
		for (int i = 0; i < memAry.length; i++) {
			if (memAry[i] != null)
				memAry[i].showInfo();
		}
		// 값할당
	}
}
