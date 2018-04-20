class For_Ex3
{
	public static void main(String[] args){
		//ABCD........Z
		for(int ch = 'A'; ch<='Z';ch++)
			System.out.printf("%c(%d)",ch,ch);
		
		System.out.println();
//----------------------------------------------
		for(int i =0; i<26;i++)
			System.out.printf("%c",'A'+i);
		System.out.println();
//----------------------------------------------
		for(int i =0; i<26;i++){
			if(i%2==0)
				System.out.printf("%c", 'A' + i);
			else
				System.out.printf("%c",'a'+i);
		}
		System.out.println();
//--------------------------------------------------
		for(int i=0; i<26;i++)
			System.out.printf("%c",'Z'-i);
		
		System.out.println();
//--------------------------------------------------
		int n = 5;
		int result =0;
		for(int i =1; i<=n;i++)
			if(i%2==1)
				result += i;
		System.out.println(result);
		result = 0;
		
//-------------------------------------------
		for(int i =1; i<=n; i++)
			if(i%3==0)
				result += i;
		System.out.println(result);
			
	}
	
}