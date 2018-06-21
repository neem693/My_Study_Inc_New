package network;

import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

import pv.Character_User;
import pv.Character_ox;
import utill.Pan;

public class Ox_Survive_Data implements Serializable {
	
	
	public static final int READY_NICKSET = 0;//레디하면 닉네임도 적용됨.
	public static final int USER_IN = 1;
	public static final int USER_OUT = 2;
	public static final int USER_LIST = 4;
	public static final int READY_CANCLE = 8;
	public static final int GAME_START = 16;
	public static final int INITIALIZE_GAME = 32;
	public static final int NEXT_ROUND = 64;//PAN과 chlist, 현재 문제와 답, 번호등이 전송한다.
	public static final int CHARACTER_MOVE = 128;//멀티플레이어의 캐릭터가 움직인다.
	///////프로토콜
	ArrayList<String> quiz_r_n;
	ArrayList<String> quiz_r_m;
	ArrayList<String> quiz_r_c;
	int protocol;
	String nick_name;
	Pan xpan,opan;
	ArrayList<Character_ox> ch_list;
	ArrayList<Character_ox> ch_user_list;
	String [] user_list;
	int key;
	String message;
	//KeyEvent key;
	
	int message_index;
	int user_index;
	
	
	
	
	public ArrayList<String> getQuiz_r_n() {
		return quiz_r_n;
	}
	public void setQuiz_r_n(ArrayList<String> quiz_r_n) {
		this.quiz_r_n = quiz_r_n;
	}
	public ArrayList<String> getQuiz_r_m() {
		return quiz_r_m;
	}
	public void setQuiz_r_m(ArrayList<String> quiz_r_m) {
		this.quiz_r_m = quiz_r_m;
	}
	public ArrayList<String> getQuiz_r_c() {
		return quiz_r_c;
	}
	public void setQuiz_r_c(ArrayList<String> quiz_r_c) {
		this.quiz_r_c = quiz_r_c;
	}
	public int getProtocol() {
		return protocol;
	}
	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public Pan getXpan() {
		return xpan;
	}
	public void setXpan(Pan xpan) {
		this.xpan = xpan;
	}
	public Pan getOpan() {
		return opan;
	}
	public void setOpan(Pan opan) {
		this.opan = opan;
	}
	public ArrayList<Character_ox> getCh_list() {
		return ch_list;
	}
	public void setCh_list(ArrayList<Character_ox> ch_list) {
		this.ch_list = ch_list;
	}

	public String[] getUser_list() {
		return user_list;
	}
	public void setUser_list(String[] user_list) {
		this.user_list = user_list;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMessage_index() {
		return message_index;
	}
	public void setMessage_index(int message_index) {
		this.message_index = message_index;
	}
	public int getUser_index() {
		return user_index;
	}
	public void setUser_index(int user_index) {
		this.user_index = user_index;
	}
	public ArrayList<Character_ox> getCh_user_list() {
		return ch_user_list;
	}
	public void setCh_user_list(ArrayList<Character_ox> ch_user_list) {
		this.ch_user_list = ch_user_list;
	}
	
	
	
	

}
