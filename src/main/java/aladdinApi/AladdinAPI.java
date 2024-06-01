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
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import org.xml.sax.helpers.DefaultHandler;

public class AladdinAPI extends DefaultHandler {

    private static final String BASE_URL = "http://www.aladdin.co.kr/ttb/api/ItemList.aspx?";
    public static List<BookDTO> BDTO;
    private boolean inItemElement = false;
    private String tempValue;
    
    //---필수---
    private final String TTBKey = "ttbyonex941928001"; // 오픈api키
    private String QueryType = "Bestseller";
    
    //---옵션----
    int Version = 20131101; //최신버전 20131101이라고함 
    int Start; //1이상, 양의 정수(기본값:1)
    int MaxResults; // 양의 정수(기본값:10)
    
    
    
    public AladdinAPI() {
        BDTO = new ArrayList<BookDTO>();
    }

    public static String GetUrl(int i) throws Exception {
        Map<String, String> hm = new HashMap<String, String>();
        
        hm.put("ttbkey", "ttbyonex941928001");
        hm.put("QueryType", "Bestseller");
        hm.put("CategoryId", "486");
        hm.put("start", Integer.toString(i));
        hm.put("MaxResults", "50");
        hm.put("SearchTarget", "Book");
        hm.put("output", "xml");
        hm.put("Version", "20131101");
        
        StringBuffer sb = new StringBuffer();
        Iterator<String> iter = hm.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            String val = hm.get(key);
            sb.append(key).append("=").append(val).append("&");
        }
        return (BASE_URL + sb.toString()).substring(0, (BASE_URL + sb.toString()).length() - 1);
    }


    
}


