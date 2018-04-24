package Question;

public class Q_11 {

	public static void main(String[] args) {
		double mf = 1.0;
		double result =0.0;
		for(int i =1; i<=100000000;i+=2) {
			result += mf*(4.0/i);
			mf*=-1.0;
		}
		System.out.println(result);

	}

}
