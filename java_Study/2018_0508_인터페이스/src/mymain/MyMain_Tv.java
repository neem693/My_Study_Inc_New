package mymain;

import java.io.IOException;
import inter.RemoteCon;
import inter.Tv;

public class MyMain_Tv {

	public static void main(String[] args) throws IOException {
		
		//��뼳�� 	= 		��ǰ���輭
		//interface      =         class
		
		RemoteCon remo = new Tv();
		
		while(true)
		{
			int key = System.in.read();
			if(key == 'o')
				remo.onOff();
			else if(key == '+')
				remo.volumeUp();
			else if(key == '-')
				remo.volumDown();
		}
	}
}
