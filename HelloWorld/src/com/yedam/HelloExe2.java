package com.yedam;

public class HelloExe2 {
	// 기능 (함수) => main 메소드
	public static void main(String[] args) {
		// 1. 32000 변수 선언과 할당
		int num = 32000;
		
		// 2. 34, 32, 88, 23
		int[] numbers = {34, 32, 88, 23};
		
		// 3. 문자 : 32
		String ch = "32";
		
		// 4. 정수변수에 저장.
		int intValue = 32;
		
		// 5. Hello, Nice, Good

		String[] greeting = {"Hello", "Nice", "Good"};
		
		// 6. 정수 5개 저장.
		// Math.random() -> 60 ~ 100
		int[] randomScores = new int[5];
		for (int i = 0; i < randomScores.length; i++) {
			randomScores[i] = 60 + (int)(Math.random() * 41);  // Random number between 60 and 100
        }
		
		// 7. 이름, 연락처, 나이선언.
		// 홍길동, 010-1234-1234, 20
		String name1 = "홍길동";
        String phone1 = "010-1234-1234";
        int age1 = 20;	
        
		// 8. 위에서 선언한 데이터타입을 3개정도 담을 수 있도록
		// 홍길동, 010-1234-1234, 20
		// 김민식, 010-2222-2222, 22
		// 최문식, 010-3333-3333, 23
		// [3]
        String[] names = {"홍길동", "김민식", "최문식"};
        String[] phones = {"010-1234-1234", "010-2222-2222", "010-3333-3333"};
        int[] ages = {20, 22, 23};
        
		// 9. 나이가 제일 많은 사람의 이름을 출력
        Student[] students = new Student[3];
        students[0] = new Student ("홍길동", "010-1234-1234", 20);
        students[1] = new Student ("김민식", "010-2222-2222", 22);
        students[2] = new Student ("최문식", "010-3333-3333", 23);
        	
    	 Student oldestStudent = students[0];
         for (int i = 1; i < students.length; i++) {
             if (students[i].age > oldestStudent.age) {
                 oldestStudent = students[i];
        }
	}
}        System.out.println("나이가 제일 많은 사람의 이름: " + oldestStudent);