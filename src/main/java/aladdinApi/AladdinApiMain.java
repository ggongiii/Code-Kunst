package aladdinApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.ParserAdapter;

public class AladdinApiMain extends DefaultHandler {

    private List<BookDTO> books;
    private BookDTO bDTO;
    private StringBuilder content;

    public static void main(String[] args) {
        AladdinAPIUrl api = new AladdinAPIUrl();
        BookDAO dao = new BookDAO();

        try {
            String url = api.apiUrl();
            System.out.println("Generated URL: " + url);

            AladdinApiMain parser = new AladdinApiMain();
            parser.parseXml(url);

            for (BookDTO book : parser.getBooks()) {
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
        	//----카테고리넣을만한xml값이 없어서 이걸로대체!
        	AladdinAPIUrl aUrl = new AladdinAPIUrl();
        	bDTO.setBook_category(aUrl.CATEGORY_ID); 
        	
            switch (qName.toLowerCase()) {
               // case "itemId":
                //	bDTO.setBook_id(parseInt(content.toString()));
            //        break;
                case "title":
                	bDTO.setBook_name(content.toString());
                    break;
                case "isbn13":
                	bDTO.setIsbn(content.toString());
                    break;
                case "pricestandard":
                	//System.out.println("PriceStandard: " + content.toString());
                    bDTO.setBook_price(parseInt(content.toString()));
                    break;
                case "pubDate":
                	System.out.println("pubDate: " + content.toString());
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
               // case "searchCategoryName": //카테고리넣을만한게없어서 위에서 DAO 처리
                	//bDTO.setBook_category(content.toString());
                //    break;
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

    private static long parseLong(String value) {
        if (value == null || value.isEmpty()) {
            return 0L;
        }
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
