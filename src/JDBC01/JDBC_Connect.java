package JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connect {

	public static void main(String[] args) {

		//1.JDBC를 통한 데이터 베이스 연결 클래스의 객체 : Connection생성
		Connection con = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "tiger";
		
		//외부장치와의 연결은 항상 예외처리가 필수.
		try {
			//연결될 데이터 베이스의 드라이버 파일 지정하는 명령
			Class.forName(driver);
			
			//DriverManager 라는 클래스의 스태틱메서드인 getConnection을 이용해서 실제로 데이터 베이스를
			//연결하고 연결결과 객체를 con에 저장한다.
			con = DriverManager.getConnection(url,id,pw);
			System.out.println("테이터베이스에 연결 성공했습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con != null)con.close();
			System.out.println("테이터베이스 종료");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
