package myutil;

public class MyDate {
	
	//���������� �ڷ��� ������;
	private int year;
	protected int month;
	public int day;
	int day_of_year;
	
	
	public void setYear(int y)
	{
		year = y;
	}
	//setter method ��� �Ѵ�.
	//��, ������ �ִ�. �ڱⰡ �ְ� ���� ���� �ִ°��� �ƴϴ�. set�ʵ��()
	
	

	//year���� ������ �޼ҵ� ����
	public int getYear()
	{
		return year;
	}



	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		this.month = month;
	}



	public int getDay() {
		return day;
	}



	public void setDay(int day) {
		this.day = day;
	}



	public int getDay_of_year() {
		return day_of_year;
	}



	public void setDay_of_year(int day_of_year) {
		this.day_of_year = day_of_year;
	}
	
	
	
	

}
