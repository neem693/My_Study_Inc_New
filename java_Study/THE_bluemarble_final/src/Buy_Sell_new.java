import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;

public class Buy_Sell_new {

	int my_count = 0;
	int play2_count = 0;

	static String chat = "";
	static String chat1 = "";
	
	static String chat_ai = "";
	static String chat_ai1 = "";
	Blue_Marble frame;

	public Buy_Sell_new(Blue_Marble frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
	}

	public Buy_Sell_new() {
		
	
	}
		
	public void buy() {

		if (check_my_stack_buy()) {
			
			
			Blue_Marble.play.price -= Blue_Marble.con_col.get(Blue_Marble.my_place_stack-1).price;

			
			//System.out.printf("���� �Ϸ�� ��ġ%d   ���� �����ݾ�%d\n", blue_marble.my_place_stack, blue_marble.play.price);
			Blue_Marble.jlb_price.setText(Blue_Marble.play.price + "��"); // ���� �� �ݾ� ǥ��

			my_count++;
			
			Blue_Marble.jlb_building.setText(my_count + "��"); // �ǹ��� ǥ��

			chat = String.format("%s �����߽��ϴ�", Blue_Marble.con_col.get(Blue_Marble.my_place_stack - 1).contry_name);

			frame.jta_chat.append(chat + "\r\n");
			
			active_button();		//������ ��ư Ȱ��ȭ 
		
		
			

		}

		else {
			chat1 = String.format("�̹� �����߰ų� �����Ҽ����� ���Դϴ�.");
			frame.jta_chat.append(chat1 + "\r\n");
			
		}

	}

	public void active_button() {
		// TODO Auto-generated method stub
		 
		
		for(int i =0 ; i<15; i++) {
	
		
		switch(Blue_Marble.play.contry_stack[i]){
     
		case 2:Blue_Marble.����.setEnabled(true);
        		break;
		case 3:Blue_Marble.�븣����.setEnabled(true);
		break;
		case 4:Blue_Marble.���þ�.setEnabled(true);
		break;
		case 5:Blue_Marble.�縶�Ͼ�.setEnabled(true);
		break;
		case 6:Blue_Marble.������.setEnabled(true);
		break;
		case 7:Blue_Marble.�ʶ���.setEnabled(true);
		break;
		case 9:Blue_Marble.������.setEnabled(true);
		break;
		case 10:Blue_Marble.���Ϸ���.setEnabled(true);
		break;
		case 11:Blue_Marble.��Ż����.setEnabled(true);
		break;
		case 13:Blue_Marble.�߱�.setEnabled(true);
		break;
		case 14:Blue_Marble.�Ϻ�.setEnabled(true);
		break;
		case 15:Blue_Marble.�밡��.setEnabled(true);
		break;
		
		
	
       
        default :
          //  System.out.println("������ �� ���� ��ġ");

		
		}
		
	}
	
	
	}

	
	
	public void active_button_ai() {
		// TODO Auto-generated method stub
		 
		
		for(int i =0 ; i<15; i++) {
	
		
		switch(Blue_Marble.play2.contry_stack[i]){
     
		case 2:Blue_Marble.����_ai.setEnabled(true);
        		break;
		case 3:Blue_Marble.�븣����_ai.setEnabled(true);
		break;
		case 4:Blue_Marble.���þ�_ai.setEnabled(true);
		break;
		case 5:Blue_Marble.�縶�Ͼ�_ai.setEnabled(true);
		break;
		case 6:Blue_Marble.������_ai.setEnabled(true);
		break;
		case 7:Blue_Marble.�ʶ���_ai.setEnabled(true);
		break;
		case 9:Blue_Marble.������_ai.setEnabled(true);
		break;
		case 10:Blue_Marble.���Ϸ���_ai.setEnabled(true);
		break;
		case 11:Blue_Marble.��Ż����_ai.setEnabled(true);
		break;
		case 13:Blue_Marble.�߱�_ai.setEnabled(true);
		break;
		case 14:Blue_Marble.�Ϻ�_ai.setEnabled(true);
		break;
		case 15:Blue_Marble.�밡��_ai.setEnabled(true);
		break;
	
       
        default :
           // System.out.println("������ �� ���� ��ġ");
    
		
		}
		
	}
	
	
	}
	
	
	
	
	
	
	
	public void play2_buy() {

		if (check_my_stack_buy_play()) {

			Blue_Marble.play2.price -= Blue_Marble.con_col.get(Blue_Marble.play2_place_stack-1).price;

			System.out.printf("�÷��̾�2:���� �Ϸ�� ��ġ%d   �÷��̾�2�ݾ�%d\n", Blue_Marble.play2_place_stack,
					Blue_Marble.play2.price);
			Blue_Marble.jlb_price_ai.setText(Blue_Marble.play2.price + "��"); // ���� �� �ݾ� ǥ��

				
			/*play2_count++;
			blue_marble.jlb_building.setText(my_count + "��"); // �ǹ��� ǥ��

			chat = String.format("�÷��̾�2��%s �����߽��ϴ�",
					blue_marble.con_col.get(blue_marble.my_place_stack - 1).contry_name);

			frame.jta_chat.append(chat + "\r\n");*/
			
            play2_count++;
			
			Blue_Marble.jlb_building_ai.setText(play2_count + "��"); // �ǹ��� ǥ��

			chat_ai = String.format("%s AI�� �����߽��ϴ�", Blue_Marble.con_col.get(Blue_Marble.play2_place_stack - 1).contry_name);

			frame.jta_ai_chat.append(chat_ai + "\r\n");

			active_button_ai();
			
		
		}

		else {
			chat_ai1 = String.format(" �̹� �����߰ų� �����Ҽ����� ���Դϴ٤���?");
			frame.jta_ai_chat.append(chat_ai1 + "\r\n");
		}

	}

	private void deactive_button_ai(int x) {
		
		switch(x){
	     
		case 2:Blue_Marble.����_ai.setEnabled(false);
        		break;
		case 3:Blue_Marble.�븣����_ai.setEnabled(false);
		break;
		case 4:Blue_Marble.���þ�_ai.setEnabled(false);
		break;
		case 5:Blue_Marble.�縶�Ͼ�_ai.setEnabled(false);
		break;
		case 6:Blue_Marble.������_ai.setEnabled(false);
		break;
		case 7:Blue_Marble.�ʶ���_ai.setEnabled(false);
		break;
		case 9:Blue_Marble.������_ai.setEnabled(false);
		break;
		case 10:Blue_Marble.���Ϸ���_ai.setEnabled(false);
		break;
		case 11:Blue_Marble.��Ż����_ai.setEnabled(false);
		break;
		case 13:Blue_Marble.�߱�_ai.setEnabled(false);
		break;
		case 14:Blue_Marble.�Ϻ�_ai.setEnabled(false);
		break;
		case 15:Blue_Marble.�밡��_ai.setEnabled(false);
		break;
	
       
        default :
           // System.out.println("������ �� ���� ��ġ");
    
		
		}
		
		
		
	}

	public void sell(int uniq_num) {

		if (check_my_stack_sell(uniq_num)) {

			Blue_Marble.play.price += (int) (Blue_Marble.con_col.get(uniq_num-1).price * 0.7);
			// �ǸŽ� 70%�� ȯ�޵˴ϴ�.
			Blue_Marble.jlb_price.setText(Blue_Marble.play.price + "��");

			my_count--;
			chat = String.format("%s �Ǹ��߽��ϴ�", Blue_Marble.con_col.get(uniq_num-1).contry_name);
			Blue_Marble.jlb_building.setText(my_count + "��"); // �ǹ��� ǥ��
			frame.jta_chat.append(chat + "\r\n");

			for (int i = 0; i < 15; i++) { // �̹� �����ؼ� ������ �����ִ°��
				if (Blue_Marble.play.contry_stack[i] == uniq_num)
					Blue_Marble.play.contry_stack[i] = 0;
				// �̹� ������ �� ��ġ�� 0�� �־ �ʱ�ȭ�� ��Ŵ

			}
			
		}

	

	}
	public void play2_sell(int uniq_num) {
		if (check_my_stack_sell_play(uniq_num)) {

			Blue_Marble.play2.price += (int) (Blue_Marble.con_col.get(uniq_num).price * 0.7);
			// �ǸŽ� 70%�� ȯ�޵˴ϴ�.
			Blue_Marble.jlb_price_ai.setText(Blue_Marble.play2.price + "��");

			play2_count--;
			chat_ai = String.format("%s �Ǹ��߽��ϴ�", Blue_Marble.con_col.get(uniq_num - 1).contry_name);
			Blue_Marble.jlb_building_ai.setText(play2_count + "��"); // �ǹ��� ǥ��
			frame.jta_ai_chat.append(chat_ai + "\r\n");

			for (int i = 0; i < 15; i++) { // �̹� �����ؼ� ������ �����ִ°��
				if (Blue_Marble.play2.contry_stack[i] == uniq_num)
					Blue_Marble.play2.contry_stack[i] = 0;
				// �̹� ������ �� ��ġ�� 0�� �־ �ʱ�ȭ�� ��Ŵ

			}
			deactive_button_ai(uniq_num);
		
		
		
		
		
		}

	
	}

	private boolean check_my_stack_sell(int uniq_num) {

		// �Ǹ��ϱ����� ���� �����ϰ��ִ��� Ȯ��
		for (int i = 0; i < 15; i++) { // �̹� �����ؼ� ������ �����ִ°��

			if (Blue_Marble.play.contry_stack[i] == uniq_num)
				return true;

		}

		return false;

	}
	
	private boolean check_my_stack_sell_play(int uniq_num) {
		
		// �Ǹ��ϱ����� ���� �����ϰ��ִ��� Ȯ��
				for (int i = 0; i < 15; i++) { // �̹� �����ؼ� ������ �����ִ°��

					if (Blue_Marble.play2.contry_stack[i] == uniq_num)
						return true;

				}

				return false;
		
	}

	private boolean check_my_stack_buy() {//�÷��̾�

		// ���ΰ��� ��� �� ��

		int n = 0;
		
		if(Blue_Marble.my_place_stack==9||Blue_Marble.my_place_stack==1)return false; //��ŸƮ �� ���ε� ����
		
		for (int i = 0; i < 15; i++) { // �̹� �����ؼ� ������ �����ִ°��,play2�� ���� �����ϰ��ִ°��

			if (Blue_Marble.play.contry_stack[i] == Blue_Marble.my_place_stack)
				return false;
			// �����ð� �÷��̾� 2�� ������ �����Ŀ� ���� ���� 0 �̻��� ��� ������ �����ϰ��ִ°���̹Ƿ� �������.

			if (Blue_Marble.my_place_stack == Blue_Marble.play2.contry_stack[i]) {
				n = Blue_Marble.play2.contry_stack[i];
				if (n > 0) {
					System.out.println("������ �������̰ų� �����Ҽ����� ���Դϴ٤���?.");
					return false;
				}
			}

		}

		for (int k = 0; k < 15; k++) { // �������� �ʴ� ��� ������ ����� �����͸� ����

			//System.out.printf("���� ���� ���� %d\n", blue_marble.play.contry_stack[k]);
			if (Blue_Marble.play.contry_stack[k] == 0) {
				Blue_Marble.play.contry_stack[k] = Blue_Marble.my_place_stack;

				break;
			}

		}

		return true;

	}

	private boolean check_my_stack_buy_play() { //ai

		// ���ΰ��� ��� �� ��

		if(Blue_Marble.play2_place_stack==9||Blue_Marble.play2_place_stack==1)return false; //��ŸƮ �� ���ε� ����
		
		int n = 0;
		for (int i = 0; i < 15; i++) { // �̹� �����ؼ� ������ �����ִ°��,play2�� ���� �����ϰ��ִ°��

			if (Blue_Marble.play2.contry_stack[i] == Blue_Marble.play2_place_stack)
				return false;
			// �����ð� �÷��̾� 2�� ������ �����Ŀ� ���� ���� 0 �̻��� ��� ������ �����ϰ��ִ°���̹Ƿ� �������.

		/*	System.out.printf("���� ���� ���� %d, �÷��̾�2�� ��ġ%d\n", blue_marble.play.contry_stack[i],
					blue_marble.play2_place_stack);
*/
			if (Blue_Marble.play.contry_stack[i] == Blue_Marble.play2_place_stack) {

				n = Blue_Marble.play.contry_stack[i];
				System.out.printf("���ð� %d", n);
				if (n > 0) {
					System.out.println("������ �������̰ų� �����Ҽ����� ���Դϴ� ����?.");
					return false;
				}
			}

		}

		for (int k = 0; k < 15; k++) { // �������� �ʴ� ��� ������ ����� �����͸� ����
			if (Blue_Marble.play2.contry_stack[k] == 0) {
				Blue_Marble.play2.contry_stack[k] = Blue_Marble.play2_place_stack;
					
				break;
			}

		}

		return true;

	}

}
