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
        AladdinAPIUrl api = new AladdinAPIUrl("�Ϻ�����"); //���⿡ ī�װ���������� �ؿ� �ּ������
        
        /*
        55890	�ǰ�
		53532	����
		54709	��
		54710	�߱�
		54708	�౸
		53514	���̾�Ʈ
		53523	����
		53535	��̱�Ÿ
		50831	��������
		50832	�Ϻ�����
		53491	�Ϻ��丮
		53492	�߱��丮
		53494	������ �丮
		53490	�ѱ��丮
		53474	���̾�Ʈ �丮
		53501	�м�
		53473	�����丮
		53472	��Ȱ�丮
		51012	��������
		51018	����
		51014	��/��


        */
        
        BookDAO dao = new BookDAO();

        try {
            String url = api.apiUrl();
            System.out.println("Generated URL: " + url);

            AladdinApiMain parser = new AladdinApiMain();
            parser.parseXml(url);

            for (BookDTO book : parser.getBooks()) {
                book.setBook_category(api.CATEGORY_NAME); // ī�װ� �̸��� ����
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
        if (qName.equalsIgnoreCase("item")) { //xml�±׾ȿ� item�������� ����!
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
