package com.yedam.inheritance;
/*
 *  Friend 상속.
 */
public class UnivFriend extends Friend {
		private String univName;
		private String major;
		
		public UnivFriend() {
			super();
		}
		public UnivFriend(String name, String tel, String univName, String major) {
			super(name, tel); // 부모생성자.
			this.univName = univName;
			this.major = major;
		}
		
		// 부모의 메소드 -> 자식이 재정의. overriding.
		@Override //어노테이션 : 컴파일, 또는 실행 시점에 특별한 기능부여
		public String getName(int no) {
			return super.getName();
		}
		
//		@Override
//		public final void setName(String name) {
//			//부모 final 메소드는 overiding 안됨.
//		}
		
		public String getUnivName() {
			return univName;
		}

		public void setUnivName(String univName) {
			this.univName = univName;
		}

		public String getMajor() {
			return major;
		}

		public void setMajor(String major) {
			this.major = major;
		}
		
	}
