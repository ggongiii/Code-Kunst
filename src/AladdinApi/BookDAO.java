package AladdinApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String pass = "12345";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public BookDAO() {
		// 초기화하기위해
	}

	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.con = DriverManager.getConnection(this.url, this.user, this.pass);
		} catch (Exception var1) {
			var1.printStackTrace();

		} // catch문
	} // getCon()

	public void insertBook(BookDTO bDto) {
		try {
			this.getCon(); // 연결
			String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?)";
			this.pstmt = this.con.prepareStatement(sql);
			this.pstmt.setInt(1, bDto.getBook_id());
			this.pstmt.setString(2, bDto.getBook_name());
			this.pstmt.setString(3, bDto.getIsbn());
			this.pstmt.setInt(4, bDto.getBook_price());
			this.pstmt.setString(5,bDto.publish_date);
			this.pstmt.setString(6, bDto.getBook_pic());
			this.pstmt.setString(7, bDto.getBook_info());
			this.pstmt.setInt(8, Integer.parseInt(bDto.getInventory()));
			this.pstmt.setString(9, bDto.getPublisher());
			this.pstmt.setString(10, bDto.getBook_category());
			this.pstmt.setString(11, bDto.getAuthor());

		} catch (Exception var2) {
			var2.printStackTrace();
		}finally {
            try {
                if (this.pstmt != null) this.pstmt.close();
                if (this.con != null) this.con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

} // BookDAO
