

//--------------------
//알라딘이 제공하는 예시 파일
//--------------------
//참고용임 .프로젝트때 삭제예정!
//--------------------
//[기본제공하는 메뉴얼]https://docs.google.com/document/d/1mX-WxuoGs8Hy-QalhHcvuV17n50uGI2Sg_GHofgiePE/edit 
//[알라딘키]https://www.aladin.co.kr/ttb/wblog_manage.aspx 
//[알라딘키]ttbyonex941928001
//[가져와야할 url] http://www.aladdin.co.kr/ttb/api/ItemList.aspx?
//[참고URL] http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=TTBKey&itemIdType=ISBN13&ItemId=도서의ISBN&output=xml
//[예시ISBN] 9791188331796
//[참고URL값넣기]http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=ttbyonex941928001&itemIdType=ISBN13&ItemId=9791188331796&output=xml

package aladdinApi;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;


public class AladdinExampleAPI extends DefaultHandler {
	public static List<Item> Items;
	public Item item; 	//DTO 가 Item인듯?
	private boolean inItemElement = false; //초기값 flase로 두고 
	private String tempValue;
	
	public AladdinExampleAPI( ){
		Items = new ArrayList<Item>();
	}
	

	
	
	/*
	 * 시작 태그("<")를 만났을 때 발생하는 이벤트
	 */
	public void startElement(String namespace, String localName, String qName, Attributes atts) {
		/*
		 * namespace : uri
		 * localname : DTO에 있는 속성이름인듯
		 * qName : 속성명 <-이건뭐냐
		 */
		if (localName.equals("item")) {
			item = new Item();
			inItemElement = true; // 로컬네임과 DTO와 동일하면 조건발생인듯
			
			//그게아니면 모두 빈값을 채워넣는다 
		} else if (localName.equals("title")) {
			tempValue = "";
		} else if (localName.equals("isbn")) {
			tempValue = "";
		} else if (localName.equals("cover")) {
			tempValue = "";
		} else if (localName.equals("author")) {
			tempValue = "";
		}  else if (localName.equals("pubDate")) {
			tempValue = "";
		} else if (localName.equals("description")) {
			tempValue = "";
		} else if (localName.equals("priceSales")) {
			tempValue = "";
		} else if (localName.equals("publisher")) {
			tempValue = "";
		} else if (localName.equals("customerReviewRank")) {
			tempValue = "";
		} else if (localName.equals("link")) {
			tempValue = "";
		} else if (localName.equals("itemPage")) {
			tempValue = "";
		}
		//여까지 
		//속성명을 내 DTO에 넣어야할듯
	}
	
	
	/*
	 * 태그와 태그 사이의 내용을 처리
	 * ch에 xml파일형식의 데이터가 들어가있음
	 */
	
	
	public void characters(char[] ch, int start, int length) throws SAXException{
		tempValue = tempValue + new String(ch,start,length); // 뭐지이게
	} 
	
	
	
	/*
	 * 끝 태그(">")를 만났을 때 호출되는 함수
	 */
	public void endElement(String namespaceURI, String localName,String qName) {
		if(inItemElement){
			
			if (localName.equals("item")) {
				Items.add(item);
				item = null;
				inItemElement = false;
			} 
			else if (localName.equals("title")) {
				item.setProduct_title(tempValue); // tempValue : 이미 각 속성의 값들이 들어있음. title이면 책 제목이 tempValue에 담겨있음
			} 
			else if (localName.equals("cover")) {
				item.setProduct_cover(tempValue);
			} 
			else if (localName.equals("author")) {
				item.setProduct_author(tempValue);
			} 
			else if (localName.equals("pubDate")) {
				item.setProduct_publish_date(tempValue);
			} 
			else if (localName.equals("description")) {
				item.setProduct_des(tempValue);
			} 
			else if (localName.equals("priceSales")) {
				item.setProduct_price(Integer.parseInt(tempValue));
			} 
			else if (localName.equals("publisher")) {
				item.setProduct_publisher(tempValue);
			} 
			else if (localName.equals("itemPage")) {
				System.out.println("itemPage : " + tempValue);
				item.setProduct_page(Integer.parseInt(tempValue));
			}
			else if (localName.equals("isbn")) {
				item.setProduct_isbn(tempValue);
			}
			
		}
	}
	
	public void parseXml(String xmlUrl) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        ParserAdapter pa = new ParserAdapter(sp.getParser());
        pa.setContentHandler(this);
		pa.parse(xmlUrl);
	}
}


