package com.yedam.inheritance;
/*
 * 추상클래스.(abstract)
 * 추상메소드 : 선언부분만 존재.
 */
public abstract class Animal {
	abstract void sound(); // 자식클래스에 규칙을 지정. (메소드를 통해 강제 지정가능)
	void eat() {
		System.out.println("먹는다.");
	}
}
