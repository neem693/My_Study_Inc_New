class �ڷ���_char
{
	public static void main(String[] args)
	{
		
		
		System.out.printf("%c %c %c %c\n",'A','1','��','��');
		System.out.printf("������%c\n%c\n",'A','B');
		System.out.printf("tab���%c\t%c\n",'A','B');
		System.out.printf("%c\b%c\n",'A','B');
		
		char ch = 65; // 'A' <= 65
		
		System.out.printf("%c %c %c\n",ch,ch+1,ch+2);
		
		ch = '��';
		
		System.out.printf("[%c]�� �ڵ尪�� (%d) (%x)\n",ch,(int)ch,(int)ch);
		
		char ch1=0xac00;
		System.out.printf("ch1 = %c\n",ch1);
		
		System.out.printf("ȫ�浿�� �ڵ尪 : %x %x %x\n",(int)'ȫ',(int)'��',(int)'��');
		
		
	}
}