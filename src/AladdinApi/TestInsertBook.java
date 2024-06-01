package AladdinApi;

import java.util.Date;

public class TestInsertBook {

	//DB테스트용
    public static void main(String[] args) {
        // BookDTO 객체 생성 및 데이터 설정
        BookDTO book = new BookDTO();
        book.setBook_id(1);
        book.setBook_name("Sample Book");
        book.setIsbn("123456789");
        book.setBook_price(1999);
        book.setPublish_date("2024/02/02"); // 현재 날짜로 설정
        book.setBook_pic("sample.jpg");
        book.setBook_info("This is a sample book description.");
        book.setInventory("100");
        book.setPublisher("Sample Publisher");
        book.setBook_category("Fiction");
        book.setAuthor("John Doe");

        // BookDAO 객체 생성 및 데이터 삽입
        BookDAO bookDAO = new BookDAO();
        bookDAO.insertBook(book);

        System.out.println("Data inserted successfully!");
    }
}
