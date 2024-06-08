package aladdinApi;

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
        // ������
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
            this.getCon(); // ����!
            //--------------------
            // ����� �κ�: book_id�� book_seq.NEXTVAL�� ����
            //--------------------
            String sql = "insert into book (book_id, book_name, isbn, book_price, publish_date, book_pic, book_info, inventory, publisher, book_category, author) values(book_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
            pstmt = this.con.prepareStatement(sql);
            //--------------------
            
            pstmt.setString(1, bDto.getBook_name());
            pstmt.setString(2, bDto.getIsbn());
            pstmt.setInt(3, bDto.getBook_price());
            pstmt.setString(4, bDto.getPublish_date());
            pstmt.setString(5, bDto.getBook_pic());
            pstmt.setString(6, bDto.getBook_info());
            pstmt.setInt(7, bDto.getInventory());
            pstmt.setString(8, bDto.getPublisher());
            pstmt.setString(9, bDto.getBook_category());
            pstmt.setString(10, bDto.getAuthor());

            this.pstmt.executeUpdate();
            System.out.println("db insert ����");

        } catch (Exception var2) {
            var2.printStackTrace();
            System.out.println("insertBook ����");
        }
    } // insertBook
} // BookDAO
