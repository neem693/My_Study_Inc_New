class �ڷ���_double
{
	public static void main(String[] args)
	{
		//�Ǽ���: �⺻���� double
		//��� : 0.0 1.2E+002(����) E+002�� ���⼭ 10^2 �� ���Ѵ�.
		//    : 0.0F <= float ���
		//��¼���: %f %e <= �Ҽ��� 6�ڸ��� ���
		//%g <= �ڸ����� ���������� ���
		
		double d = 1.2345;
		System.out.printf("%f\n",d);
		System.out.printf("%e\n",d);
		System.out.printf("%g\n",d);
		System.out.println();
		d= 424.4589;
		System.out.printf("%f\n",d);
		System.out.printf("%e\n",d);
		System.out.printf("%g\n",d);
		
		System.out.printf("[%10.1f]\n",d);	
		System.out.printf("[%010.1f]\n",d);
		
	}
}