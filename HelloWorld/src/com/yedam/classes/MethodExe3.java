package com.yedam.classes;

public class MethodExe3 {
	
	// 구구단출력.
	String gugudan(int num, int toNum) {
		// 2 * 1 = 2
		// 2 * 3 = 4
		// ...
		// 2 * 9 = 18
	void printStar(int cnt, String str) {
	}
		String str = " ";
		for (int n = num; n <= toNum; n++) {
			int dan = n;
			for (int i = 1; i <= 9; i++) {
//				System.out.println(num + " * " + i + " = " + (num * i));
				str += dan + " * " + i + " = " + (dan * i) + "\n";
				}
		} return str;
	}
}
	void printCard() {
		// 배열선언.
		int[] intAry = new int[16];
		// 1 ~ 16까지의 임의수 할당.
		for (int i = 0; i < intAry.length; i++) {
			intAry[i] = (int) (Math.random() * 16) + 1;
		}
		// 출력.
		for (int i = 0; i < intAry.length; i++) {
			System.out.println("%3d", intAry[i]);
			if (i % 4 == 3) {
				System.out.println();
			}
		}
	}