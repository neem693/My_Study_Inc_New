package network;

import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

import pv.Character_User;
import pv.Character_ox;
import utill.Pan;

public class Ox_Survive_Data implements Serializable {
	
	
	public static int USER_IN = 1;
	public static int USER_OUT = 2;
	public static int RESET_PAN = 4;//PAN�� chlist�� �����Ѵ�.
	public static int CHARACTER_MOVE = 8;//��Ƽ�÷��̾��� ĳ���Ͱ� �����δ�.
	///////��������
	int protocol;
	Pan xpan,opan;
	ArrayList<Character_ox> ch_list;
	ArrayList<Character_User> ch_user;
	int key;
	String message;
	//KeyEvent key;
	

}
