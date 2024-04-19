package JDBC03;

import java.util.Scanner;

public class Member_Delete {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 회원의 번호를 입력하세요 : ");
		int memberNum = Integer.parseInt(sc.nextLine());
		MemberDao mdao = new MemberDao();
		MemberDto mdto = mdao.getMember(memberNum);

		if (mdto == null) {
			System.out.println("입력하신 번호의 회원이 존재하지 않습니다\n프로그램을 종료합니다.");
			return;
		}
		
		int result = mdao.deleteMember(memberNum);
		if(result ==1) System.out.println("삭제 성공");
		else System.out.println("삭제 실패");

	}
}
