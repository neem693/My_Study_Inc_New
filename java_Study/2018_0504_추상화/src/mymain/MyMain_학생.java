package mymain;

import myutil.����л�;
import myutil.���л�;
import myutil.�ʵ��л�;
import myutil.�л�;

public class MyMain_�л� {
	
	
	static void ��Ӵ�_��(�л� [] student_array) {
		for(�л� s : student_array)
			s.�����Ѵ�();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*�л� [] student_array = {
				new �ʵ��л�(),
				new ���л�(),
				new ����л�()
		};*/
		//�� ���� �� �Ʒ����� ����.
		
		�л� [] student_array = new �л�[3];
		student_array[0] = new �ʵ��л�();
		student_array[1] = new ���л�();
		student_array[2] = new ����л�();
		
		//�л� s = new �л�(); �̰� �ȵȴ�.
		//�߻�Ŭ������ ��ü���� ���Ѵ�.
		//��? �迭�� �� �ǳ�?
		//�迭�� �� �ǰڳ�? ������ �װ� �迭�̰� �װ� ���� �ǹ��ϱ� ������ �߻�Ŭ������ �����ϴ�.
		//�׷��� �� ��ü�� ����� ���� �Ұ��� �ϴ�.
		
		
		��Ӵ�_��(student_array);

	}

}
