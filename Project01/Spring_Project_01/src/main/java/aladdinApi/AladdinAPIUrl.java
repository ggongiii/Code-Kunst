//--------------------
//알라딘이 제공하는 예시 파일
//--------------------
//참고용임 .프로젝트때 삭제예정!
//--------------------
//[기본제공하는 메뉴얼]https://docs.google.com/document/d/1mX-WxuoGs8Hy-QalhHcvuV17n50uGI2Sg_GHofgiePE/edit 
//[알라딘키]https://www.aladin.co.kr/ttb/wblog_manage.aspx 
//[알라딘키]ttbyonex941928002
//[가져와야할 url] http://www.aladdin.co.kr/ttb/api/ItemList.aspx?
//[참고URL] http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=TTBKey&itemIdType=ISBN13&ItemId=도서의ISBN&output=xml
//[예시ISBN] 9791188331796
//[참고URL값넣기]http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=ttbyonex941928001&itemIdType=ISBN13&ItemId=9791188331796&output=xml
//---카테고리ID---
/*
55890	건강/취미/레저	국내도서	건강/취미/레저		
53532	공예	국내도서	건강/취미/레저	공예	
54709	농구	국내도서	건강/취미/레저	구기	농구
54710	야구	국내도서	건강/취미/레저	구기	야구
54708	축구	국내도서	건강/취미/레저	구기	축구
53514	다이어트	국내도서	건강/취미/레저	다이어트	
53523	수영/수상스포츠	국내도서	건강/취미/레저	수영/수상스포츠	
53535	취미기타	국내도서	건강/취미/레저	취미기타	
50831	유럽여행	국내도서	여행	유럽여행	
50832	일본여행	국내도서	여행	일본여행	
51012	서양음악(클래식)	국내도서	예술/대중문화	음악	서양음악!(클래식)
*/


package aladdinApi;

public class AladdinAPIUrl {

	//----------필수값------------
    private static final String BASE_URL = "http://www.aladdin.co.kr/ttb/api/ItemList.aspx?";
    private static final String TTB_KEY = "ttbyonex941928001";
    String QUERY_TYPE = "Bestseller";
    // ------------------------------
 		/* --쿼리타입 리스트--
 		 * ItemNewAll : 신간 전체 리스트 
 		 * ItemNewSpecial : 주목할 만한 신간 리스트 
 		 * Bestseller : 베스트셀러 
 		 * BlogBest : 블로거 베스트셀러 (국내도서만 조회 가능)
 		 */
    //----------옵션값-----------------
    String CATEGORY_ID = "55890"; //카테고리는 상단에 정리하기
    String VERSION = "20131101"; // 최신버전사용
    //----------디폴트값 ( 필요로하면 api에 넣기 기본값을 쓸거라 따로 지정안함)
	/*
	 *--1.옵션값-- 
	 *Start 1이상, 양의 정수(기본값:1) 검색결과 시작페이지 
	 *MaxResults 1이상 100이하, 양의 정수(기본값:10) 검색결과 한 페이지당 최대 출력 개수 
	 *--2.옵션값--
	 * SearchTarget Book(기본값) : 도서 
	 * --3.옵션값-- 
	 * Output XML(기본값) : REST XML형식 출력방법
	 * --4.옵션값-- 
	 * Cover Big : 큰 크기 : 너비 200px 
	 * MidBig : 중간 큰 크기 : 너비 150px 
	 * Mid(기본값) :중간 크기 : 너비 85px 
	 * Small : 작은 크기 : 너비 75px 
	 * Mini : 매우 작은 크기 : 너비 65px 
	 * None : 없음
	 * 표지크기
	 * 
	 */

    public String apiUrl() {
        String url = BASE_URL
            + "ttbkey=" + TTB_KEY
            + "&QueryType=" + QUERY_TYPE
            + "&CategoryId=" + CATEGORY_ID
            + "&start=" +  1 // 디폴트갑 사용
            + "&MaxResults=10" // 디폴트값 사용
            + "&SearchTarget=Book" // 디폴트값 사용
            + "&output=xml" // 디폴트값 사용
            + "&Version=" + VERSION;
        return url;
    }
	
	
	
}

