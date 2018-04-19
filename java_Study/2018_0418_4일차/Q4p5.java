import java.util.Scanner;
import java.util.GregorianCalendar;
class Q4p5{
	public static void main(String [] args){
		GregorianCalendar gcl = new GregorianCalendar();
		int year = gcl.get(GregorianCalendar.YEAR);
		int birth_int,age;
		Scanner s = new Scanner(System.in);
		
		String birth = s.next();
		birth = birth.substring(0,4);
		
		
		
		
		birth_int = Integer.parseInt(birth);
		
		System.out.println(birth_int);
		age = year - birth_int;
		System.out.printf("당신은 한국나이로 %d 살 입니다. 만으로 %d 살입니다.",age+1,age);
		
		
	}
}
		