package aladdinApi;
import java.util.Date;

public class TestInsertBook {

	//�׽�Ʈ��
    public static void main(String[] args) {
        BookDTO book = new BookDTO();
        book.setBook_id(2);
        book.setBook_name("�̵���");
        book.setIsbn("1234567890");
        book.setBook_price(1999);
        book.setPublish_date("2024/02/02");
        book.setBook_pic("sample.jpg");
        book.setBook_info("�̵����̾�å");
        book.setInventory(100);
        book.setPublisher("�ۺ���");
        book.setBook_category("�ڵ�");
        book.setAuthor("å����1");

        BookDAO bookDAO = new BookDAO();
        bookDAO.insertBook(book);

        System.out.println("����!");
    }
}
