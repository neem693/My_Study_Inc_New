package myutil;

public class Mabangjin {

	int chasu;
	int[][] mabangArray;

	public void setChasu(int chasu) {
		this.chasu = chasu;
		// ������ ����
		make_mabangjin();
	}

	private void make_mabangjin() {
		mabangArray = new int[chasu][chasu];

		int row = 0;
		int col = chasu / 2; // ���߾�
		int su = 1;

		mabangArray[row][col] = su++;
		for (int i = 0; i < chasu * chasu - 1; i++) {
			// ����
			// �� &���� ��� ������ ��
			// �밢���� �̵�
			row--;
			col++;

			// �� & ���� ��� �������� : ������ġ���� �Ʒ������� �̵�
			if (row < 0 && col >= chasu) {
				row += 2;
				col--;
			} else if (row < 0) {
				// ���� �������� : �Ʒ����̵�
				row = chasu - 1;
			} else if (col >= chasu) {
				// �������� �������� : ������ �̵�
				col = 0;
			}
			// �̹� ���� ä�������� : ������ġ���� �Ʒ������� �̵�
			if (mabangArray[row][col] != 0) {
				row += 2;
				col--;
			}
			// �̵��� ��ġ�� ���� �ִ´�
			mabangArray[row][col] = su++;

		}
	}

	public void display() {
		int sum_col = 0;
		int[] sum_row = new int[chasu];
		int again = 0;
		for (int i = 0; i < chasu; i++) {
			for (int j = 0; j < chasu; j++) {
				System.out.printf("%4d", mabangArray[i][j]);
				sum_col += mabangArray[i][j];
				sum_row[j] += mabangArray[i][j];
			}
			System.out.printf("|%4d", sum_col);
			System.out.println();
			sum_col = 0;

		}
		while (true) {

			for (int i = 0; i < chasu; i++) {
				if (again==0)
					System.out.printf("%4s", "--");
				else
					System.out.printf("%4d", sum_row[i]);
			}
			
			again ++;
			if(again == 2) {
				break;
			}
			
			System.out.println();

		}
		System.out.println();
		
	}

	public int getChasu() {
		return chasu;
	}

}
