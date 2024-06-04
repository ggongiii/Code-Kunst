

//--------------------
//�˶���� �����ϴ� ���� ����
//--------------------
//������� .������Ʈ�� ��������!
//--------------------
//[�⺻�����ϴ� �޴���]https://docs.google.com/document/d/1mX-WxuoGs8Hy-QalhHcvuV17n50uGI2Sg_GHofgiePE/edit 
//[�˶��Ű]https://www.aladin.co.kr/ttb/wblog_manage.aspx 
//[�˶��Ű]ttbyonex941928001
//[�����;��� url] http://www.aladdin.co.kr/ttb/api/ItemList.aspx?
//[����URL] http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=TTBKey&itemIdType=ISBN13&ItemId=������ISBN&output=xml
//[����ISBN] 9791188331796
//[����URL���ֱ�]http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=ttbyonex941928001&itemIdType=ISBN13&ItemId=9791188331796&output=xml

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
	public Item item; 	//DTO �� Item�ε�?
	private boolean inItemElement = false; //�ʱⰪ flase�� �ΰ� 
	private String tempValue;
	
	public AladdinExampleAPI( ){
		Items = new ArrayList<Item>();
	}
	

	
	
	/*
	 * ���� �±�("<")�� ������ �� �߻��ϴ� �̺�Ʈ
	 */
	public void startElement(String namespace, String localName, String qName, Attributes atts) {
		/*
		 * namespace : uri
		 * localname : DTO�� �ִ� �Ӽ��̸��ε�
		 * qName : �Ӽ��� <-�̰ǹ���
		 */
		if (localName.equals("item")) {
			item = new Item();
			inItemElement = true; // ���ó��Ӱ� DTO�� �����ϸ� ���ǹ߻��ε�
			
			//�װԾƴϸ� ��� ���� ä���ִ´� 
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
		//������ 
		//�Ӽ����� �� DTO�� �־���ҵ�
	}
	
	
	/*
	 * �±׿� �±� ������ ������ ó��
	 * ch�� xml���������� �����Ͱ� ������
	 */
	
	
	public void characters(char[] ch, int start, int length) throws SAXException{
		tempValue = tempValue + new String(ch,start,length); // �����̰�
	} 
	
	
	
	/*
	 * �� �±�(">")�� ������ �� ȣ��Ǵ� �Լ�
	 */
	public void endElement(String namespaceURI, String localName,String qName) {
		if(inItemElement){
			
			if (localName.equals("item")) {
				Items.add(item);
				item = null;
				inItemElement = false;
			} 
			else if (localName.equals("title")) {
				item.setProduct_title(tempValue); // tempValue : �̹� �� �Ӽ��� ������ �������. title�̸� å ������ tempValue�� �������
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


