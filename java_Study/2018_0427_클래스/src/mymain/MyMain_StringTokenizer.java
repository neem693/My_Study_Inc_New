package mymain;

import java.util.StringTokenizer;

public class MyMain_StringTokenizer {
	public static void main(String[] args) {
		String str = "���� ��� ��õ ���� �뱸 ����";
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			// ������ū������ �� ���� ��ū���� �̵�
			System.out.println(token);
		}
		System.out.println("--------------");
		System.out.println("split �޼ҵ� ���");
		String[] sido_array = str.split(" ");
		// " " �����̶�� String ������ �ش� ���ڿ� ���� �и��Ѵ�.
		for (String s : sido_array)
			// for(int i =0; i<sido_array.length;i++)
			// System.out.println(sido_array[i]);
			// �� ����.
			System.out.println(s);
	}
}
