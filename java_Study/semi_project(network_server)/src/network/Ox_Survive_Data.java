package network;

import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

import pv.Character_User;
import pv.Character_ox;
import utill.Pan;

public class Ox_Survive_Data implements Serializable {
	
	
	public static final int READY_NICKSET = 0;//�����ϸ� �г��ӵ� �����.
	public static final int USER_IN = 1;
	public static final int USER_OUT = 2;
	public static final int USER_LIST = 4;
	public static final int READY_CANCLE = 8;
	public static final int GAME_START = 16;
	public static final int INITIALIZE_GAME = 32;
	public static final int NEXT_ROUND = 64;//PAN�� chlist, ���� ������ ��, ��ȣ���� �����Ѵ�.
	public static final int CHARACTER_MOVE = 128;//��Ƽ�÷��̾��� ĳ���Ͱ� �����δ�.
	///////��������
	ArrayList<String> quiz_r_n;
	ArrayList<String> quiz_r_m;
	ArrayList<String> quiz_r_c;
	int protocol;
	String nick_name;
	Pan xpan,opan;
	ArrayList<Character_ox> ch_list;
	ArrayList<Character_User> ch_user;
	String [] user_list;
	int key;
	String message;
	//KeyEvent key;
	

}
