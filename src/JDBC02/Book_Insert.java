package JDBC02;

import java.util.Scanner;

public class Book_Insert {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BookDto bdto = new BookDto();
		
		System.out.println("제목을 입력하세요");
		bdto.setSubject(sc.nextLine());
		//String Subject = sc.nextLine();
		//bdto.setSubject(sc.nextLine());
		
		System.out.println("출판년도를 입력하세요");
		bdto.setMakeyear(Integer.parseInt(sc.nextLine()));
	
		System.out.println("입고가격을 입력하세요");
		bdto.setInprice(Integer.parseInt(sc.nextLine()));
		
		System.out.println("출고가격을 입력하세요");
		bdto.setRentprice(Integer.parseInt(sc.nextLine()));
		
		System.out.println("출판년도를 입력하세요");
		bdto.setGrade(sc.nextLine());
		
		BookDao bdao = new BookDao();
		int result = bdao.insertBook(bdto);
		
		if(result == 1)System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
	}

}
