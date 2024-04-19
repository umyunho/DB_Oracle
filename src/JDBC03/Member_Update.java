package JDBC03;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import JDBC02.BookDao;
import JDBC02.BookDto;

public class Member_Update {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 회원의 번호를 입력하세요");
		int membernum = Integer.parseInt( sc.nextLine() );
		MemberDao mdao = new MemberDao();
		MemberDto mdto = mdao.getMember( membernum ); 
		
		if( mdto == null ) {
			System.out.println("입력한 번호의 회원이 존재하시 않습니다\n프로그램을 종료합니다.");
			return;
		}
		
		String input = "";
		System.out.printf("\n이름 : %s \n수정할 이름을 입력하세요(수정안하며 Enter입력) -> ", mdto.getName() );
		input = sc.nextLine();
		if( !input.equals("") ) mdto.setName(input);
		
		System.out.printf("전화번호 : %s\n" , mdto.getPhone() );
		System.out.println("수정할 전화번호를 입력하세요. (수정하지 않으려면 엔터만 입력) -> ");
		input = sc.nextLine();
		if( !input.equals("") ) mdto.setPhone( input );
		
		System.out.printf("성별 : %s\n" , mdto.getGender() );
		System.out.println("수정할 성별을 입력하세요. (수정하지 않으려면 엔터만 입력) -> ");
		input = sc.nextLine();
		if( !input.equals("") ) mdto.setGender( input );

		System.out.printf("보너스포인트 : %s\n" , mdto.getBpoint() );
		System.out.println("수정할 포인트 점수를 입력하세요. (수정하지 않으려면 엔터만 입력) -> ");
		input = sc.nextLine();
		if( !input.equals("") ) mdto.setBpoint( Integer.parseInt( input ) );
		
		System.out.printf("생년월일 : %s\n", mdto.getBirth() );
		System.out.print("수정할 생일을 입력하세요(YYYY-MM-DD), (수정하지 않으려면 엔터만 입력)-> ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		input = sc.nextLine();  // String 입력
		if( !input.equals("") ) {  // 입력한 내용이 있다면  
			java.util.Date d = sdf.parse( input );  //  java.util.Date 로 변환
			java.sql.Date birth = new java.sql.Date( d.getTime() );   //java.sql.Date 로 변환
			mdto.setBirth( birth );  // mdto 에 저장
			Calendar c = Calendar.getInstance();    // 나이 계산
			Calendar today = Calendar.getInstance();   // 오늘날짜
			c.setTime( d );   // 입력한 날짜
			int age = today.get( Calendar.YEAR ) - c.get( Calendar.YEAR );
			mdto.setAge(age);
		}
		int result = mdao.updateMember(mdto);
		if( result == 1 ) System.out.println("레코드 수정 성공");
		else System.out.println("레코드 수정 실패");
		
		
	}
	}