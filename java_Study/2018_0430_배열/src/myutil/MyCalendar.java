package myutil;

import java.util.Calendar;

public class MyCalendar {

	/*
	 * ���� ó��(Ÿ��Ʋ) 0�� ó�� �������� ������������ ��� getYoil_all�ϼ�
	 */

	int[] month_array = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	// 1�� ���� 12�� ���� ��¥ �� �迭
	int year;
	int month;
	int[][] cal_array;

	public void setDate(int year, int month) {
		this.year = year;
		this.month = month;

		cal_array = new int[6][7];
		// �⺻���� �޷��� �������� ���Ѵ�.
		make_calendar();

	}

	boolean isYoon() {
		return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
	}

	boolean isYoon(int year) {
		return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
	}

	int getYoil_all() {
		// 1-1-1�������� �ش� ������ 1�ϱ����� �ѳ� �� ���
		int all_day = 0;
		for (int i = 1; i <= year - 1; i++) {
			all_day += 365;
			if(isYoon(i))
				all_day+=1;
		}
		for (int j = 0; j < month - 1; j++) {
			if (j == 1 && isYoon()) {
				month_array[1] = 29;
			} else
				month_array[1] = 28;
			all_day += month_array[j];
		}
		// ���� = �ѳ���%7(0~6)
		return (all_day + 1) % 7;
	}

	int getYoil() {
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, 1);

		int yoil = c.get(Calendar.DAY_OF_WEEK) - 1;
		return yoil;
	}

	private void make_calendar() {

		int yoil = getYoil_all();
		// �迭�� 6�� �̶�� �ϴ��� 0����� �����ϱ� ������
		int week = 0;
		int su = 1;
		int diff; // �� ������ ������ ��Ÿ��

		// ����üũ = > 2���� ���������� 29 or 28����

		if (isYoon())
			month_array[1] = 29;
		else
			month_array[1] = 28;

		if (month == 1)
			diff = month_array[11] - (yoil - 1);// 1�� �ٷ� �� �ϼ��� �̱� ���ؼ� yoil�� -1�� ����
												// ��, �̰� 1�� ���� 31���̶�� ���� Ȯ���� �ϴ� ���� ����
		else
			diff = month_array[month - 2] - (yoil - 1);

		if (yoil == 0) {
			week++;// �Ͽ��ϳ� 1���̸� ���� ��ĭ ���.
			for (su = 0; su < 7; su++)
				cal_array[0][su] = diff - 7 + su;
		} else
			for (int i = 0; i < yoil; i++)
				cal_array[0][i] = diff + i;

		for (int i = 1; i <= month_array[month - 1]; i++) {

			cal_array[week][yoil] = i;
			yoil++;
			if (yoil > 6) {
				week++;
				yoil = 0;
			}
		}
	}

	public void display() {
		String[] dow = new String[7];
		dow[0] = "Sun";
		dow[1] = "Mon";
		dow[2] = "Tue";
		dow[3] = "Wen";
		dow[4] = "Thu";
		dow[5] = "Fri";
		dow[6] = "Sat";

		for (int i = 0; i < dow.length; i++) {
			System.out.printf("%4s", dow[i]);
		}
		System.out.println();

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (cal_array[i][j] == 0)
					System.out.printf("%4s", " ");
				else
					System.out.printf("%4d", cal_array[i][j]);
			}
			System.out.println();
		}
	}
}
