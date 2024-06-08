package kr.co.soldesk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import kr.co.soldesk.beans.BookDTO;

public interface BookMapper {
   
   @Select("SELECT book_id, "
           + "book_name, "
           + "isbn, "
           + "book_price, "
           + "publish_date, "
           + "book_pic, "
           + "book_info, "
           + "inventory, "
           + "publisher, "
           + "book_category, "
           + "author "
           + "FROM book "
           + "ORDER BY book_id")
   List<BookDTO> getBookList(); //getBookListø°¿˙¿Â
 

}
