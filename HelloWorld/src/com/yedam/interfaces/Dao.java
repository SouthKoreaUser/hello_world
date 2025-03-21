package com.yedam.interfaces;

/*
 * Data Access Object
 * 인터페이스 내의 메소드는 추상메소드.
 * MySql을 1차 프로젝트로 사용,
 * Oracle을 2차 프로젝트로
 */

public interface Dao {
	void insert();
	void update();
	void delete();
}
