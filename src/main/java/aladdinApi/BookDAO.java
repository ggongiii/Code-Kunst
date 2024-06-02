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
			this.pstmt = this.con.prepareStatement(sql);

			// book_id가 중복되지 않도록 생성
			this.pstmt.setInt(1, generateUniqueId());
			this.pstmt.setString(2, bDto.getBook_name());
			this.pstmt.setLong(3, bDto.getIsbn());
			this.pstmt.setInt(4, bDto.getBook_price());
			this.pstmt.setString(5, bDto.getPublish_date());
			this.pstmt.setString(6, bDto.getBook_pic());
			this.pstmt.setString(7, bDto.getBook_info());
			this.pstmt.setInt(8, bDto.getInventory());
			this.pstmt.setString(9, bDto.getPublisher());
			this.pstmt.setString(10, bDto.getBook_category());
			this.pstmt.setString(11, bDto.getAuthor());

			this.pstmt.executeUpdate();
			System.out.println("db insert 성공");

		} catch (Exception var2) {
			var2.printStackTrace();
			System.out.println("insertBook 오류");
		} 
	} // insertBook

	private int generateUniqueId() {
		// 간단한 예시로, 중복되지 않는 book_id를 생성하는 방법입니다.
		// 실제 구현에서는 더 복잡한 로직이 필요할 수 있습니다.
		return Math.abs(UUID.randomUUID().hashCode());
	}

} // BookDAO
