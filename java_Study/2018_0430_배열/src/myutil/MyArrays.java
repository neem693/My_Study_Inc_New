package myutil;

public class MyArrays {
	
	public static void display_array(int [] mr) {
		System.out.printf("[");
		for(int i =0;i<mr.length;i++)
			System.out.printf("%3d",mr[i]);
		System.out.println(" ]");
	}
	
	public static void display_array(String [] mr) {
		System.out.print("[");
		for(int i =0;i<mr.length;i++)
			System.out.printf("%5s",mr[i]);
		System.out.println(" ]");
	}
	
	public static void sort_asc(int [] mr) {
		int temp;
		for(int i =0;i<mr.length-1;i++) {
			for(int j =i+1;j<mr.length;j++) {
				if(mr[i]>mr[j]) {
					temp = mr[i];
					mr[i] = mr[j];
					mr[j] = temp;
				}
			}
		}
	}
	
	public static void sort_desc(int [] mr) {
		int temp;
		for(int i =0;i<mr.length-1;i++) {
			for(int j =i+1;j<mr.length;j++) {
				if(mr[i]<mr[j]) {
					temp = mr[i];
					mr[i] = mr[j];
					mr[j] = temp;
				}
			}
		}
	}
	

}
