package aladdinApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class BookDAO {

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String pass = "12345";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private static int bookIdCounter = 0;

	public BookDAO() {
		// 삭제용
	}

	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.con = DriverManager.getConnection(this.url, this.user, this.pass);
		} catch (Exception var1) {
			var1.printStackTrace();
			System.out.println("getCon");
		} // catch
	} // getCon()

	public void insertBook(BookDTO bDto) {
		try {
			this.getCon(); // 연결
			String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = this.con.prepareStatement(sql);

			pstmt.setInt(1, bookIdSum()); // bookid는 1씩증가하는값으로 변경
			pstmt.setString(2, bDto.getBook_name());
			pstmt.setString(3 , bDto.getIsbn());
			pstmt.setInt(4, bDto.getBook_price());
			pstmt.setString(5, bDto.getPublish_date());
			pstmt.setString(6, bDto.getBook_pic());
			pstmt.setString(7, bDto.getBook_info());
			pstmt.setInt(8, bDto.getInventory());
			pstmt.setString(9, bDto.getPublisher());
			pstmt.setString(10, bDto.getBook_category());
			pstmt.setString(11, bDto.getAuthor());

			this.pstmt.executeUpdate();
			System.out.println("db insert 성공");

		} catch (Exception var2) {
			var2.printStackTrace();
			System.out.println("insertBook 오류");
		} 
	} // insertBook

	 private int bookIdSum() {
	        return bookIdCounter++; //랜덤값으로 변경할까생각중
	    }
	

} // BookDAO
