package com.yedam.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * List 컬렉션.
 */
public class ListExe {
	public static void main(String[] args) {
		// 배열 : int[], String[], Member[]
		// 컬렉션 : List<Integer>, List<String>, List<Member>
		// intList.get(0), intList.add(30)
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(100);
		intList.add(150);
		intList.add(100);
		
		for(int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}
		
		// Set 컬렉션. 중복된 값은 저장할 수 없음.
		Set<Integer> intSet = new HashSet<Integer>();
		intSet.add(100);
		intSet.add(150);
		intSet.add(200);
		intSet.add(100);
		System.out.println("-----------------");
		for (Integer num : intSet) {
			System.out.println(num);
		}
		
		// Set<Member>
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 20));
		members.add(new Member("박태욱", 21));
		members.add(new Member("최선욱", 22));
		members.add(new Member("홍길동", 20)); // hashCode, equals => 동등객체
		System.out.println("---------------");
		for(Member mbr : members) {
			System.out.println(mbr.toString());
		}
	}
}