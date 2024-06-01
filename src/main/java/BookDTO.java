

public class BookDTO {

    int book_id; //기본키
    String book_name; //책이름
    String isbn; // 책고유번호 int -> string으로 변경 /"값이 있음
    int book_price; // 책가격
    String publish_date; //출판일 int -> string으로 변경 "/"값이 있음
    String book_pic;//책표지
    String book_info;//책소개
    int inventory;//책재고
    String publisher;//책출판사
    String book_category;//책카테고리
    String author;//저자
    
    // Getter and Setter methods

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getBook_price() {
        return book_price;
    }

    public void setBook_price(int book_price) {
        this.book_price = book_price;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getBook_pic() {
        return book_pic;
    }

    public void setBook_pic(String book_pic) {
        this.book_pic = book_pic;
    }

    public String getBook_info() {
        return book_info;
    }

    public void setBook_info(String book_info) {
        this.book_info = book_info;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBook_category() {
        return book_category;
    }

    public void setBook_category(String book_category) {
        this.book_category = book_category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
