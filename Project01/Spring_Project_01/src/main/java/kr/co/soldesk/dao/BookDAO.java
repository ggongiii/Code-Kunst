package kr.co.soldesk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import kr.co.soldesk.beans.BookDTO;

public class BookDAO {


	PreparedStatement pstmt;
	ResultSet rs;
	
	private static int bookIdCounter = 0;



	public void insertBook(BookDTO bDto) {
		try {
			String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?)";

			pstmt.setInt(1, bookIdSum()); // bookid�� 1�������ϴ°����� ����
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
			System.out.println("db insert ����");

		} catch (Exception var2) {
			var2.printStackTrace();
			System.out.println("insertBook ����");
		} 
	} // insertBook

	 private int bookIdSum() {
	        return bookIdCounter++; //���������� �����ұ������
	    }
	

} // BookDAO
