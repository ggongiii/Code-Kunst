package kr.co.soldesk.service;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.soldesk.beans.BookDTO;
import kr.co.soldesk.dao.BookDAO;

@Service
public class BookService {
    
    @Autowired
    private BookDAO bookDAO;
    
    public List<BookDTO> getBookList() {
        return bookDAO.getBookList();
    }
    
    public BookDTO getBookById(int bookId) {
        return bookDAO.getBookById(bookId);
    }

    public List<BookDTO> getBooksByCategory(String category) {
        return bookDAO.getBooksByCategory(category);
    }

    public List<BookDTO> getRandomBooksByCategory(String category, int limit) {
        List<BookDTO> books = bookDAO.getBooksByCategory(category);
        Random rand = new Random();
        while (books.size() > limit) {
            books.remove(rand.nextInt(books.size()));
        }
        return books;
    }
}
