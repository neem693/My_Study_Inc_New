class Exam_1
{
	public static void main(String[] args)
	{
		int money = 67750;
		int com_m= 50000;
		
		
		int count_50000;
		int count_10000;
		int count_5000;
		int count_1000;
		int count_500;
		int count_100;
		int count_50;
		int count_10;
		count_50000=count_10000=count_5000=count_1000=count_500=count_100=count_50=count_10=0;
		
		
		if(money >com_m){
			count_50000 = money/com_m;
			money %=com_m;
		}
		com_m =10000;
		if(money>com_m){
			count_10000 = money/com_m;
			money %= com_m;
		}
		
		com_m=5000;
		if(money>com_m){
			count_5000 = money/com_m;
			money %= com_m;
		}
		
		com_m = 1000;
		if(money>com_m){
			count_1000 = money/com_m;
			money %= com_m;
		}
		
		com_m = 500;
		if(money>com_m){
			count_500 = money/com_m;
			money %= com_m;
		}
		com_m = 100;
		if(money>com_m){
			count_100 = money/com_m;
			money %= com_m;
		}
		com_m = 50;
		if(money>com_m){
			count_50 = money/com_m;
			money %= com_m;
		}
		com_m =10;
		if(money>com_m){
			count_10 = money/com_m;
			money %= com_m;
		}
		
		
		/*
		if(count_10000 = money/10000)
			count_10000 = money/10000;
		*/
		System.out.println(money);
		System.out.println("5���� ��" + count_50000);
		System.out.println("���� �� " + count_10000);
		System.out.println("5000�� �� " + count_5000);
		System.out.println("1000�� �� " + count_1000);
		System.out.println("500�� " +count_500);
		System.out.println("100�� " + count_100);
		System.out.println("50�� " +count_50);
		System.out.println("10�� " +count_10);
				int all = count_50000 * 50000+count_10000 * 10000 +count_5000 * 5000 +count_1000 * 1000 +count_500* 500+count_100 * 100+count_50 * 50 +count_10 * 10;
		System.out.println(all);
	}
	
}