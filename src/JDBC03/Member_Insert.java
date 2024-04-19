package JDBC03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Member_Insert {

	public static void main(String[] args) throws ParseException {
		
		MemberDao mdao = new MemberDao();
		MemberDto mdto = new MemberDto();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요->");
		String name = sc.nextLine();
		mdto.setName(name);
		
		System.out.println("전화번호를 입력하세요 ->");
		mdto.setPhone(sc.nextLine());
		
		System.out.println("성별을 입력하세요(M/F)");
		mdto.setGender(sc.nextLine());
		
		//bpoint는 default값이 0이 되므로 별도로 입력받지 않습니다.
		
		//생년월일 입력 - simpleDateFormat과 Exception을 이용하여 입력 받을예정
		//String으로 입력받아서 java.util.date형식으로 변환 후 java.sql.date로 변경
		//그래여 memberlist 테이블의 birth(date자료형)필드에 insert가능
		
		//simpleDateFormat class : 날짜 데이터(java.util.date)의 형식을 지정하여 표현해주는 클래스
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		//sdf객체에 날짜 데이터 하나를 적용하면 "yyyy-mm-dd"양식으로 날짜 데이터릀 설정하여 사용가능
		//또한 simpleDateFormat 클래스의 parse메서드는 string양식의 날짜 데이터를
		//실제 java.util.date 로 변환해줌
		
		System.out.print("생년월일을 입력하세요(yyyy-mm-dd)->");
		String input = sc.nextLine();
		java.util.Date d = sdf.parse(input);
		
		//java.util.date을 java.sql.date로 변환
		//d.getTime() 을 java.sql.date의 생성자의 전달 인수로 넣는다
		java.sql.Date birth = new java.sql.Date(d.getTime());
		mdto.setBirth(birth);
		
		Calendar today = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int age = today.get(Calendar.YEAR)-c.get(Calendar.YEAR);
		mdto.setAge(age);
		
		int result = mdao.insertMember(mdto);
		if(result == 1)System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
		
		
		
	}

}


























