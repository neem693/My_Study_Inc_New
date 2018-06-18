package network;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ox_survive.Ox_Suvive;

public class Ox_survive_Client extends JFrame {
	JPanel panel;
	JButton send_button;
	Socket socket;
	
	ObjectInputStream ios;
	ObjectOutputStream oos;
	
	public Ox_survive_Client() {
		super("내가만든 윈도우");
		this.setLocation(200,100);
		//this.setBounds(200, 100, 400, 300);
		init_panel();
		init_socket();
		init_event();
		this.pack();
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_socket() {
		// TODO Auto-generated method stub
		
		try {
			socket = new Socket("192.168.0.5", 7000);
			
			oos = new ObjectOutputStream(socket.getOutputStream());
			ios = new ObjectInputStream(socket.getInputStream());
			
			Ox_Survive_Data data = new Ox_Survive_Data();
			data.protocol = Ox_Survive_Data.USER_IN;
			oos.writeObject(data);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}

	private void init_event() {
		// TODO Auto-generated method stub
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(send_button == e.getSource()) {
					
				}
			}
		};
		
	}

	private void init_panel() {
		// TODO Auto-generated method stub
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 400));
		send_button = new JButton("보내기");
		panel.add(send_button);
		this.add(panel);
		
		
	}

	public static void main(String[] args) {
		new Ox_survive_Client();
		//new Ox_Suvive();
		

	}

}