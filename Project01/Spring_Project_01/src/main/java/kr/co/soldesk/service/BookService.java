package kr.co.soldesk.service;

import java.util.List;
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

    public void addBook(BookDTO bDto) {
        bookDAO.insertBook(bDto);
    }
}