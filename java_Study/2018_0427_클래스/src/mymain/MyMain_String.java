package mymain;

public class MyMain_String {

	public static void main(String[] args) {
		String str = "�츮���� ���ѹα�";
		System.out.println(str.length());
		int index = str.indexOf('��');
		System.out.println(index);
		System.out.printf("'��'�� ��ġ�� :%d\n",index);
		
		index = str.indexOf("����");
		System.out.printf("'����'�� ��ġ�� :%d\n",index);
		
		str = "I am Tom Tom & Tom";
		
		index = str.indexOf("Tom");
		System.out.printf("\"Tom\"�� ��ġ�� :%d\n",index);
		
		index = str.lastIndexOf("Tom");
		System.out.printf("�ڿ������� �˻��� Tom�� ��ġ�� :%d\n",index);

		//������
		String jumin_no = "901212-1234567";
		char gender = jumin_no.charAt(7);
		System.out.println(gender);
		
		/*
           		1900���� 		2000����
		   ����		1(5:��)		3(7)
		   ����		2(6)		4(8)
		 */
		
		String str_year = jumin_no.substring(0, 2);
		int year = Integer.parseInt(str_year);
		
		
		
		if(gender =='1' || gender == '2'||gender =='5' ||gender=='6')
			year += 1900;
		else
			year += 2000;
		
		System.out.println(year);
		
		String str_month = jumin_no.substring(2,4);
		String season = "";
		
		/*
		 * 3~5 :��
		 * 6-8 :����
		 * 9~11 : ����
		 * 12,1,2 : �ܿ�
		 * 
		 */
		
		switch(str_month)
		{
		case "03":
		case "04":
		case "05": season = "��";break;
		case "06":
		case "07":
		case "08": season = "����";break;
		case "09":
		case "10":
		case "11": season = "����";break;
		default: season = "�ܿ�";
		}
		//�� ���� ���
		System.out.println(season);
		
		int month = Integer.parseInt(str_month);
		switch(month/3) {
		case 1: season = "��"; break;
		case 2: season = "����"; break;
		case 3: season = "����"; break;
		default: season = "�ܿ�";
		}
		
	
		
		
	}
}
