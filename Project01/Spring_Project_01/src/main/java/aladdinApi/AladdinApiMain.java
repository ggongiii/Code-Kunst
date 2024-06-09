package aladdinApi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;

public class AladdinApiMain extends DefaultHandler {

    private List<BookDTO> books;
    private BookDTO bDTO;
    private StringBuilder content;

    public static void main(String[] args) {
        AladdinAPIUrl api = new AladdinAPIUrl("일본여행"); //여기에 카테고리를넣으면됨 밑에 주석열어보셈
        
        /*
        55890	건강
		53532	공예
		54709	농구
		54710	야구
		54708	축구
		53514	다이어트
		53523	수영
		53535	취미기타
		50831	유럽여행
		50832	일본여행
		53491	일본요리
		53492	중국요리
		53494	프랑스 요리
		53490	한국요리
		53474	다이어트 요리
		53501	패션
		53473	사찰요리
		53472	생활요리
		51012	서양음악
		51018	재즈
		51014	팝/록


        */
        
        BookDAO dao = new BookDAO();

        try {
            String url = api.apiUrl();
            System.out.println("Generated URL: " + url);

            AladdinApiMain parser = new AladdinApiMain();
            parser.parseXml(url);

            for (BookDTO book : parser.getBooks()) {
                book.setBook_category(api.CATEGORY_NAME); // 카테고리 이름을 저장
                dao.insertBook(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void parseXml(String xmlUrl) throws Exception {
        books = new ArrayList<>();
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        ParserAdapter pa = new ParserAdapter(sp.getParser());
        pa.setContentHandler(this);
        pa.parse(xmlUrl);
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        if (qName.equalsIgnoreCase("item")) { //xml태그안에 item을만나면 읽음!
            bDTO = new BookDTO();
        }
        content = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (bDTO != null) {
            switch (qName.toLowerCase()) {
                case "title":
                    bDTO.setBook_name(content.toString());
                    break;
                case "isbn13":
                    bDTO.setIsbn(content.toString());
                    break;
                case "pricestandard":
                    bDTO.setBook_price(parseInt(content.toString()));
                    break;
                case "pubdate":
                    bDTO.setPublish_date(content.toString());
                    break;
                case "cover":
                    bDTO.setBook_pic(content.toString());
                    break;
                case "description":
                    bDTO.setBook_info(content.toString());
                    break;
                case "inventory":
                    bDTO.setInventory(parseInt(content.toString()));
                    break;
                case "publisher":
                    bDTO.setPublisher(content.toString());
                    break;
                case "author":
                    bDTO.setAuthor(content.toString());
                    break;
                case "item":
                    books.add(bDTO);
                    break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content.append(ch, start, length);
    }

    private static int parseInt(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
