import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class AirManager {

	Air air = new Air();// ����� ��ü
	//public List<Air> air_list = new ArrayList<Air>();
	
	public void air_pos(int x, int y)
	{
		
	}
	
	public boolean move()
	{
		return air.move();//�׸������� �� ���ҳ�?
		
	}
	public void draw(Graphics g)
	{
		//for(Air air : air_list) 
		
			air.draw(g);
		
	}
}
