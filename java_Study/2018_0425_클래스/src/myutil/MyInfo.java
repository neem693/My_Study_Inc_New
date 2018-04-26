package myutil;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyInfo {

	private int year;
	private int month;
	private int current_year;
	private int current_month;

	public MyInfo() {
		Calendar gs = GregorianCalendar.getInstance();
		current_year = gs.get(Calendar.YEAR);
		current_month = gs.get(Calendar.MONTH) +1;
	}
	public int getYear(){	
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getCurrent_year() {
		return current_month;
	}


	

	public int getAge() {
		if(year<100) {
			year += 1900;
		}
		
		return current_year - year;
	}

	public String getZi() {

		String gan="";
		String zi="";

		switch (year % 10) {
		case 4:
			gan = "��";
			break;
		case 5:
			gan = "��";
			break;
		case 6:
			gan = "��";
			break;
		case 7:
			gan = "��";
			break;
		case 8:
			gan = "��";
			break;
		case 9:
			gan = "��";
			break;
		case 0:
			gan = "��";
			break;
		case 1:
			gan = "��";
			break;
		case 2:
			gan = "��";
			break;
		case 3:
			gan = "��";
			break;
		}
		switch (year % 12) {
		case 4:
			zi = "��";
			break;
		case 5:
			zi = "��";
			break;
		case 6:
			zi = "��";
			break;
		case 7:
			zi = "��";
			break;
		case 8:
			zi = "��";
			break;
		case 9:
			zi = "��";
			break;
		case 10:
			zi = "��";
			break;
		case 11:
			zi = "��";
			break;
		case 0:
			zi = "��";
			break;
		case 1:
			zi = "��";
			break;
		case 2:
			zi = "��";
			break;
		case 3:
			zi = "��";
			break;
		}
		return gan.concat(zi);
	}
	
	public String getTti() {
		String zi ="";
		switch (year % 12) {
		case 4:
			zi = "��";
			break;
		case 5:
			zi = "��";
			break;
		case 6:
			zi = "ȣ����";
			break;
		case 7:
			zi = "�䳢";
			break;
		case 8:
			zi = "�巡��";
			break;
		case 9:
			zi = "��";
			break;
		case 10:
			zi = "��";
			break;
		case 11:
			zi = "��";
			break;
		case 0:
			zi = "������";
			break;
		case 1:
			zi = "��";
			break;
		case 2:
			zi = "��";
			break;
		case 3:
			zi = "����";
			break;
		}
		zi.concat("��");
		return zi;
	}

}
