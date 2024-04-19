package JDBC02;

import java.util.ArrayList;

public class Book_Select {

	public static void main(String[] args) {
		
		//Data Access Object
		BookDao bdao = new BookDao();
		
		//bdto라는 객체를 생성하고 .get으로 booklist의 정보를 쓰는구나
		//DTO : Data Transfer Object
		ArrayList<BookDto> list = bdao.getBooklist();

		System.out.println("    도서번호\t출판년도\t입고가격\t대여가격\t등급\t제목");
		System.out.println("-----------------------------------------------------------");
		for(BookDto bdto : list)
			System.out.printf("%8d\t%d\t%d\t%d\t%s\t%s\n",
					bdto.getBooknum(),bdto.getMakeyear(),bdto.getInprice(),bdto.getRentprice(),
					bdto.getGrade(),bdto.getSubject());
			
		
	}

}
