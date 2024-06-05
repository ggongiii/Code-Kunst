package kr.co.soldesk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.soldesk.beans.BookDTO;

public interface BookMapper {
	
	@Select("select book_id"
			+ "book_name,"
			+ "isbn,"
			+ "book_price,"
			+ "publish_date,"
			+ "book_pic,"
			+ "book_info,"
			+ "inventory,"
			+ "publisher,"
			+ "book_category,"
			+ "author,"
			+ "from book; " + 
	         "order by book")
	List<BookDTO> getTopMenuList();

}
