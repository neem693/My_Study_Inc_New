class ������������{
	public static void main(String[] args){
		int a= 7;
		int b= 5;
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(a));
		System.out.printf("[%32s]\n",Integer.toBinaryString(b));
		System.out.printf("[%32s]\n",Integer.toBinaryString(a&b));
		System.out.printf("[%32s]\n",Integer.toBinaryString(a|b));
		System.out.printf("[%32s]\n",Integer.toBinaryString(a^b));
		
		int birthday = 0x19880815;
		int year = birthday >>> 16; 
		//�̷��� �ص� ����� ����. >>�� ����� ���ٴ� ��.
		int month = birthday >> 8 & 0xff; 
		// & �Ѵٴ°� 0x000000ff �� �Ѵٴ� ���� �ǹ��Ѵ�. �ᱹ 1�� ���ִ� ���� 1�� and����Ǽ� ���´ٴ� �� 
		//�ٽ� ���ؼ� f�� 1111�� �ǹ��Ѵ�. 0011 & 1111 = 0011�̴�.  ��, 0011 & 0xf = 0011�̶�� ��!!!!!!!!!!!!!
		int day = birthday & 0xff;
		System.out.printf("[%x]��\n",year);
		System.out.printf("[%02x]��\n",month);
		System.out.printf("[%02x]��\n",day);
		//08���� �Ұ��ϰ� 12���� ������� �Ѵ�.
		
		//birthday = birthday & 0xffff00ff;
		birthday = birthday ^ 0x00000800; 
		// 1000 ^ 1000 = 0000
		// 0001 ^ 0000 = 0001
		// 1001 ^ 0000 = 1001
		birthday = birthday | 0x00001200;
		
		System.out.printf("%x",birthday);
	
	
	}
}
