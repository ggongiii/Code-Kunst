package kr.co.soldesk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.soldesk.beans.BookDTO;

public interface BookMapper {
	
	@Select("select board_info_idx, board_info_name,board_Info_name_en " +
	         "from board_info_table " + 
	         "order by board_info_idx")
	List<BookDTO> getTopMenuList();

}
