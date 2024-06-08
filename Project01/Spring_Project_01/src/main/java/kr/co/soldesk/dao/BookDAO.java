package kr.co.soldesk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.soldesk.beans.BookDTO;
import kr.co.soldesk.mapper.BookMapper;

@Repository
public class BookDAO {

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getBookList() {
        return bookMapper.getBookList();
    }
    
    public BookDTO getBookById(int bookId) {
        return bookMapper.getBookById(bookId);
    }
}
