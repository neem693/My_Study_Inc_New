package mymain;
import java.io.File;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		File f2 = new File("c:\\My_Study");
		File [] f_array = f2.listFiles();
		//System.out.println(f_array.length);
		//���� ���͸��� �ִ� �����̳� ���͸� ���� ���
		
		
		for(File f : f_array) {
				String filename = f.getName();
				//���ϸ� �Է¹���
				
				long length = f.length();
				long last_modify = f.lastModified();
				//�ֱ� ���� ��¥.
				if(f.isDirectory()) {
					System.out.printf("[D]:%s(%d)-%s-\n",filename,length,new Date(last_modify));
					
				}else if(f.isFile()) {
					System.out.printf("[F]:%s(%d)-%s-\n",filename,length,new Date(last_modify));
				}
				
			
		}

	}

}
