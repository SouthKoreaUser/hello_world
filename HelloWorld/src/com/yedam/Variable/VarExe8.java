package com.yedam.Variable;

public class VarExe8 {

	public static void main(String[] args) {
		int n1 = 10;
		byte b1 = 20;
		byte result = b1 + 30; // -128 ~ 127 형변환//우항은 int 값인데 좌항은 byte값이기 때문;
		byte result1 = (byte) (b1 + 130);
		System.out.println("더한 결과 : " + result1);
		// byte -> int (자동형변환: promotion)
		n1 = (int) b1;
		System.out.println(n1);
		n1 = 200;
		b1 = (byte) n1;
		System.out.println(b1);
		
		for (int i = 1; i < 15; i++);
		System.out.println(b1++);
	}

}
