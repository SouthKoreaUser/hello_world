package com.yedam.Variable;

import java.util.Scanner;

public class VarExe6 {
	public static void test() {
		// 임의의 정수 1 ~ 50 임의의 값.
		// for (int i = 1; i < 5; i++)
		//System.out.println((int)(Math.random() * 50) + 1); //0 <= x < 50
		// 학생의 점수(30 ~ 100 사이의 점수)
		// 정수 (int) -> 5개 저장.
		int[] scores = new int[5];
		for(int i = 0; i < 5; i++) {
			scores[i] = (int)(Math.random() * 71) + 30;
		}
		// 홀수의 값을 출력.
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] %2 == 1) {
				System.out.println(scores[i]);
			}
		}
	}//end of test().
	
public static void main(String[] args) {
	Scanner scn = new Scanner(System.in);
	
	int score;
	Member m1 = new Member(); //인스턴스 생성
//	m1.name = "홍길동";
	m1.setName("홍길동"); // setter.
	System.out.println(m1.score);
	Member m2 = new Member(); //인스턴스 생성
//	m2.name = "최민수";
	m2.setName("최민수"); // setter.
	Member m3 = new Member(); //인스턴스 생성
//	m3.name = "김병수";
	m3.setName("김병수"); // setter.
	Member m4 = new Member(); //인스턴스 생성
//	m4.name = "박인만";
	m4.setName("박인만"); // setter.
	//배열.
	Member[] members = {m1, m2, m3, m4};
	//70 ~ 100 사이의 임의값으로 점수지정.
	for (int i = 0; i < members.length; i++) {
//		members[i].score = (int) (Math.random() * 31) + 70;
		score = (int) (Math.random() * 31) + 70;
		members[i].setScore(score);
	}
	//점수가 가장 높은 사람의 이름.
//	int max = members[0].score;
//	String name = members[0].name;
//	for(int i = 0; i < members.length; i++) {
//		System.out.println(members[i].name + "," + members[i].score);
//		if(max < members[i].score) {
//		   max = members[i].score;
//		   name = members[i].name;
//		}
//	}
	//조회이름을 입력 -> 점수출력.
	System.out.println("조회할 이름 입력>> ");
	String search = scn.nextLine();
	
	// for 반복문 활용.
	// 비교시 30 == 30, members[i].name.equals(search)
	for(int i = 0; i < members.length; i++) {
	if(members[i].getName().equals(search)) {
		System.out.println("학생점수>>" + members[i].getScore());
		}
	}
}
}
//	
//	System.out.println("최고점수는" + name);
// end of main();