package com.yedam.bookApp;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * 실행클래스 (main메소드)
 */
public class BookApp {
	public static void main(String[] args) {
		
//		MemberJdbc dao = new MemberJdbc();
//		List<Map<String, String>> list = dao.memberList();
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String json = gson.toJson(list);
//		System.out.println(json);
		
		// singleton
		BookMain mainApp1 = BookMain.getInstance();	//정보등록
		mainApp1.main(args);
//		BookMain mainApp2 = BookMain.getInstance();	//목록보기	
		//mainApp1.add();		// 1번에 등록
//		mainApp1.list();
		
//		mainApp2.list();	// 2번 목록
	}

}
