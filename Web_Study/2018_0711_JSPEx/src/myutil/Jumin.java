package myutil;


public class Jumin extends MyInfo {
	private String jumin_no;
	private int current_year;

	// 901212-1234567
	// 01234567890123
	/*
	 * ����Ư���� : 00~08
	 * 
	 * �λ걤���� : 09~12
	 * 
	 * ��õ������ : 13~15
	 * 
	 * ��⵵ : 16~25
	 * 
	 * ������ : 26~34
	 * 
	 * ��û�ϵ� : 35~39
	 * 
	 * ���������� : 40
	 * 
	 * ��û���� : 41~43, 45~47
	 * 
	 * ����Ư����ġ�� : 44, 96
	 * 
	 * ����ϵ� : 48~54
	 * 
	 * ���󳲵� : 55~66
	 * 
	 * ���ֱ����� : 55, 56
	 * 
	 * �뱸������ : 67~70
	 * 
	 * ���ϵ� : 71~81
	 * 
	 * ��󳲵� : 82~84, 86~90
	 * 
	 * ��걤���� : 85
	 * 
	 * ����Ư����ġ�� : 91~95
	 */
	public Jumin() {
		super();
	}


	public Jumin(String jumin_no) {
		this();
		this.jumin_no = jumin_no;
		super.setYear(this.getYear());
		this.current_year = super.getCurrent_year();
	}

	public String getJumin_no() {
		return jumin_no;
	}

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
		super.setYear(this.getYear());
		this.current_year = super.getCurrent_year();
	}

	public int getYear() {
		String year = jumin_no.substring(0, 2);
		int year_int = Integer.parseInt(year);
		switch (jumin_no.substring(7, 8)) {
		case "1":
		case "2":
		case "5":
		case "6":
			year_int += 1900;
			break;
		case "3":
		case "4":
		case "7":
		case "8":
			year_int += 2000;
			break;
		}
		return year_int;
	};

	public int getAge() {
		return this.current_year - this.getYear() + 1;
	};

	public String getSex() {
		String sp = this.jumin_no.substring(7, 8);
		String sex = "����";
		switch (sp) {
		case "1":
		case "3":
		case "5":
		case "7":
			sex = "����";
			break;
		case "2":
		case "4":
		case "6":
		case "8":
			sex = "����";
			break;
		}
		return sex;
	}

	public String getLocal() {
		String result = "";
		String local_str = jumin_no.substring(8, 10);
		int local_number = Integer.parseInt(local_str);
		if (local_number >= 0 && local_number <= 8)
			result = "����Ư����";
		else if (local_number >= 9 && local_number <= 12)
			result = "�λ걤����";
		else if (local_number >= 13 && local_number <= 15)
			result = "��õ������";
		else if (local_number >= 16 && local_number <= 25)
			result = "��⵵";
		else if (local_number >= 26 && local_number <= 34)
			result = "������";
		else if (local_number >= 35 && local_number <= 39)
			result = "��û�ϵ�";
		else if (local_number == 40)
			result = "����������";
		else if (local_number >= 41 && local_number <= 43 || local_number >= 45 && local_number <= 47)
			result = "��û����";
		else if (local_number == 44 || local_number == 96)
			result = "����Ư����ġ��";
		else if (local_number >= 48 && local_number <= 54)
			result = "����ϵ�";
		else if (local_number >= 55 && local_number <= 66)
			result = "���󳲵�";
		else if (local_number == 55 || local_number == 56)
			result = "���󳲵� ���ֱ�����";
		else if (local_number >= 55 && local_number <= 66)
			result = "���󳲵�";
		else if (local_number >= 67 && local_number <= 70)
			result = "�뱸������";
		else if (local_number >= 71 && local_number <= 81)
			result = "���ϵ�";
		else if (local_number >= 82 && local_number <= 84 || local_number >= 86 && local_number <= 90)
			result = "��󳲵�";
		else if (local_number == 85)
			result = "��걤����";
		else if (local_number >= 91 && local_number <= 95)
			result = "��󳲵�";
		return result;
	}

	public String getSeason() {
		String result = "";
		int sn = Integer.parseInt(jumin_no.substring(2, 4));
		switch (sn / 3) {
		case 1:
			result = "��";
			break;
		case 2:
			result = "����";
			break;
		case 3:
			result = "����";
			break;
		default:
			result = "�ܿ�";

		}
		return result;

	}
	/*
	 * 3~5 :�� 6-8 :���� 9~11 : ���� 12,1,2 : �ܿ�
	 * 
	 */

}
