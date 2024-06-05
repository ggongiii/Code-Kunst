//--------------------
//�˶���� �����ϴ� ���� ����
//--------------------
//������� .������Ʈ�� ��������!
//--------------------
//[�⺻�����ϴ� �޴���]https://docs.google.com/document/d/1mX-WxuoGs8Hy-QalhHcvuV17n50uGI2Sg_GHofgiePE/edit 
//[�˶��Ű]https://www.aladin.co.kr/ttb/wblog_manage.aspx 
//[�˶��Ű]ttbyonex941928002
//[�����;��� url] http://www.aladdin.co.kr/ttb/api/ItemList.aspx?
//[����URL] http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=TTBKey&itemIdType=ISBN13&ItemId=������ISBN&output=xml
//[����ISBN] 9791188331796
//[����URL���ֱ�]http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=ttbyonex941928001&itemIdType=ISBN13&ItemId=9791188331796&output=xml
//---ī�װ�ID---
/*
55890	�ǰ�/���/����	��������	�ǰ�/���/����		
53532	����	��������	�ǰ�/���/����	����	
54709	��	��������	�ǰ�/���/����	����	��
54710	�߱�	��������	�ǰ�/���/����	����	�߱�
54708	�౸	��������	�ǰ�/���/����	����	�౸
53514	���̾�Ʈ	��������	�ǰ�/���/����	���̾�Ʈ	
53523	����/��������	��������	�ǰ�/���/����	����/��������	
53535	��̱�Ÿ	��������	�ǰ�/���/����	��̱�Ÿ	
50831	��������	��������	����	��������	
50832	�Ϻ�����	��������	����	�Ϻ�����	
51012	��������(Ŭ����)	��������	����/���߹�ȭ	����	��������!(Ŭ����)
*/


package kr.co.soldesk.service;

public class AladdinAPIURL {

	//----------�ʼ���------------
    private static final String BASE_URL = "http://www.aladdin.co.kr/ttb/api/ItemList.aspx?";
    private static final String TTB_KEY = "ttbyonex941928001";
    String QUERY_TYPE = "Bestseller";
    // ------------------------------
 		/* --����Ÿ�� ����Ʈ--
 		 * ItemNewAll : �Ű� ��ü ����Ʈ 
 		 * ItemNewSpecial : �ָ��� ���� �Ű� ����Ʈ 
 		 * Bestseller : ����Ʈ���� 
 		 * BlogBest : ��ΰ� ����Ʈ���� (���������� ��ȸ ����)
 		 */
    //----------�ɼǰ�-----------------
    String CATEGORY_ID = "55890"; //ī�װ��� ��ܿ� �����ϱ�
    String VERSION = "20131101"; // �ֽŹ������
    //----------����Ʈ�� ( �ʿ���ϸ� api�� �ֱ� �⺻���� ���Ŷ� ���� ��������)
	/*
	 *--1.�ɼǰ�-- 
	 *Start 1�̻�, ���� ����(�⺻��:1) �˻���� ���������� 
	 *MaxResults 1�̻� 100����, ���� ����(�⺻��:10) �˻���� �� �������� �ִ� ��� ���� 
	 *--2.�ɼǰ�--
	 * SearchTarget Book(�⺻��) : ���� 
	 * --3.�ɼǰ�-- 
	 * Output XML(�⺻��) : REST XML���� ��¹��
	 * --4.�ɼǰ�-- 
	 * Cover Big : ū ũ�� : �ʺ� 200px 
	 * MidBig : �߰� ū ũ�� : �ʺ� 150px 
	 * Mid(�⺻��) :�߰� ũ�� : �ʺ� 85px 
	 * Small : ���� ũ�� : �ʺ� 75px 
	 * Mini : �ſ� ���� ũ�� : �ʺ� 65px 
	 * None : ����
	 * ǥ��ũ��
	 * 
	 */

    public String apiUrl() {
        String url = BASE_URL
            + "ttbkey=" + TTB_KEY
            + "&QueryType=" + QUERY_TYPE
            + "&CategoryId=" + CATEGORY_ID
            + "&start=" +  1 // ����Ʈ�� ���
            + "&MaxResults=10" // ����Ʈ�� ���
            + "&SearchTarget=Book" // ����Ʈ�� ���
            + "&output=xml" // ����Ʈ�� ���
            + "&Version=" + VERSION;
        return url;
    }
	
	
	
}

