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


package aladdinApi;

public class AladdinAPIUrl {

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
    String CATEGORY_NAME; // ī�װ� �̸�
    String CATEGORY_ID; // ī�װ� ID
    String VERSION = "20131101"; // �ֽŹ������
    String COVER = "Big"; //ȭ���� �����Ƽ� ū �Ű����;ߴ�
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

    public AladdinAPIUrl(String categoryName) {
        this.CATEGORY_NAME = categoryName;
        this.CATEGORY_ID = getCategoryId(categoryName);
    }

    public String apiUrl() {
        String url = BASE_URL
            + "ttbkey=" + TTB_KEY
            + "&QueryType=" + QUERY_TYPE
            + "&CategoryId=" + CATEGORY_ID
            + "&start=" +  1 // ����Ʈ�� ���
            + "&MaxResults=" + 20 // ����Ʈ�� ���
            + "&SearchTarget=Book" // ����Ʈ�� ���
            + "&output=xml" // ����Ʈ�� ���
            + "&Version=" + VERSION
            + "&Cover=" + COVER;
        return url;
    }

    private String getCategoryId(String categoryName) {
        switch (categoryName) {
        case "�ǰ�":
            return "55890";
        case "����":
            return "53532";
        case "��":
            return "54709";
        case "�߱�":
            return "54710";
        case "�౸":
            return "54708";
        case "���̾�Ʈ":
            return "53514";
        case "����":
            return "53523";
        case "��̱�Ÿ":
            return "53535";
        case "��������":
            return "50831";
        case "�Ϻ�����":
            return "50832";
        case "��������":
            return "51012";
        case "�Ϻ��丮":
            return "53491";
        case "�߱��丮":
            return "53492";
        case "������ �丮":
            return "53494";
        case "�ѱ��丮":
            return "53490";
        case "���̾�Ʈ �丮":
            return "53474";
        case "�м�":
            return "53501";
        case "�����丮":
            return "53473";
        case "��Ȱ�丮":
            return "53472";
        case "����":
            return "51018";
        case "��":
            return "51014";    
            
            
            
            
            
        
        default:
            throw new IllegalArgumentException("�� �� ���� ī�װ� �̸�: " + categoryName);
        }
    }
}

