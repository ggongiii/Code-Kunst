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
        return bookMapper.getTopMenuList();
    }
    
    public void insertBook(BookDTO bDto) {
        bookMapper.insertBook(bDto);
    }
}