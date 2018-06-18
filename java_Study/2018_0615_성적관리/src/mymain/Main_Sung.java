package mymain;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import dao.SungTBDao;
import vo.SungVo;

public class Main_Sung extends JFrame {

	// ��,����ʵ�
	JTextField jtf_no, jtf_name, jtf_kor, jtf_eng, jtf_mat, jtf_tot, jtf_avg, jtf_rank;

	// �۾���ư
	JButton jbt_new, jbt_update, jbt_delete, jbt_prev, jbt_next;

	// ��ȸ
	JTable jtb_display;

	List<SungVo> sung_list;

	boolean bAdd = false;// �߰� or �����۾�����

	int current_pos = -1;// ���� ��µǴ� ������ �ε���

	public Main_Sung() {
		// TODO Auto-generated constructor stub
		super("��������");// Ÿ��Ʋ

		// ������ʵ� �� �۾���ư �ʱ�ȭ
		init_inputs();
		// ��ȸâ �ʱ�ȭ
		init_display();

		// ��ü������ ���
		display_total_list();
		// �����Ͱ� �����ϸ�

		if (sung_list.size() > 0)
			current_pos = 0;
		display_input_data();

		// ��ġ �� ũ������
		// setBounds(200, 100, 400, 300);
		setLocation(300, 100);

		setResizable(false);

		pack();

		// �������
		setVisible(true);

		// ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void display_input_data() {
		// TODO Auto-generated method stub
		if (current_pos == -1)
			return;
		SungVo vo = sung_list.get(current_pos);

		jtf_no.setText(String.valueOf(vo.getIdx()));
		jtf_name.setText(vo.getName());
		jtf_kor.setText(String.valueOf(vo.getKor()));
		jtf_eng.setText(String.valueOf(vo.getEng()));
		jtf_mat.setText(String.valueOf(vo.getMat()));
		jtf_tot.setText(String.valueOf(vo.getTot()));
		jtf_avg.setText(String.valueOf(vo.getAvg()));
		jtf_rank.setText(String.valueOf(vo.getRank()));
		
		check_enable_buttons();

	}

	private void check_enable_buttons() {
		// TODO Auto-generated method stub
		jbt_prev.setEnabled(current_pos>0);
		jbt_next.setEnabled(current_pos<sung_list.size()-1);
		
	}

	// JTable ��ġ ������

	private void display_total_list() {
		// TODO Auto-generated method stub
		sung_list = SungTBDao.getInstance().selectList();

		class MyTableModel extends AbstractTableModel {

			// Ÿ��Ʋ
			String[] title = { "��ȣ", "�̸�", "����", "����", "����", "����", "���", "���" };

			@Override
			public String getColumnName(int column) {
				// TODO Auto-generated method stub
				return title[column];
			}

			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return sung_list.size();
			}

			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return title.length;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				Object ob = null;
				switch (columnIndex) {
				case 0:
					ob = sung_list.get(rowIndex).getIdx();
					break;
				case 1:
					ob = sung_list.get(rowIndex).getName();
					break;
				case 2:
					ob = sung_list.get(rowIndex).getKor();
					break;
				case 3:
					ob = sung_list.get(rowIndex).getEng();
					break;
				case 4:
					ob = sung_list.get(rowIndex).getMat();
					break;
				case 5:
					ob = sung_list.get(rowIndex).getTot();
					break;
				case 6:
					ob = sung_list.get(rowIndex).getAvg();
					break;
				case 7:
					ob = sung_list.get(rowIndex).getRank();
					break;

				}

				return ob;
			}

		}

		// JTable�� ������ ������ ����
		jtb_display.setModel(new MyTableModel());

	}

	private void init_inputs() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		// �Է�â
		JPanel p1 = new JPanel(new GridLayout(4, 2));
		p1.add(new JLabel("��ȣ:"));
		p1.add(jtf_no = new JTextField());

		p1.add(new JLabel("�̸�:"));
		p1.add(jtf_name = new JTextField());

		p1.add(new JLabel("����:"));
		p1.add(jtf_kor = new JTextField());

		p1.add(new JLabel("����:"));
		p1.add(jtf_tot = new JTextField());

		p1.add(new JLabel("����:"));
		p1.add(jtf_eng = new JTextField());

		p1.add(new JLabel("���:"));
		p1.add(jtf_avg = new JTextField());

		p1.add(new JLabel("����:"));
		p1.add(jtf_mat = new JTextField());

		p1.add(new JLabel("���:"));
		p1.add(jtf_rank = new JTextField());

		// ���â
		JPanel p2 = new JPanel(new GridLayout(1, 5));
		p2.add(jbt_prev = new JButton("����"));
		p2.add(jbt_new = new JButton("�߰�"));
		p2.add(jbt_update = new JButton("����"));
		p2.add(jbt_delete = new JButton("����"));
		p2.add(jbt_next = new JButton("����"));

		p.add(p1, "Center");
		p.add(p2, "South");

		this.add(p, "Center");

		// ��ư�̺�Ʈ �ʱ�ȭ
		init_button_event();

	}

	private void init_button_event() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// �̺�Ʈ�� �߻���Ų ��ư
				Object evt_src = e.getSource();

				if (evt_src == jbt_new)
					on_new();
				else if (evt_src == jbt_update)
					on_update();
				else if (evt_src == jbt_delete)
					on_delete();
				else if (evt_src == jbt_prev)
					on_prev();
				else if (evt_src == jbt_next)
					on_next();

			}
		};

		jbt_new.addActionListener(listener);
		jbt_update.addActionListener(listener);
		jbt_delete.addActionListener(listener);
		jbt_prev.addActionListener(listener);
		jbt_next.addActionListener(listener);

	}

	protected void on_next() {
		// TODO Auto-generated method stub
		if (current_pos == sung_list.size() - 1) {
			current_pos = 0;
		} else
			current_pos++;

		display_input_data();

	}

	protected void on_prev() {
		// TODO Auto-generated method stub
		if (current_pos == 0) {
			current_pos = sung_list.size() - 1;

		} else
			current_pos--;
		display_input_data();

	}

	protected void on_delete() {
		// TODO Auto-generated method stub

	}

	protected void on_update() {
		// TODO Auto-generated method stub

	}

	protected void on_new() {
		// TODO Auto-generated method stub

	}

	private void init_display() {
		// TODO Auto-generated method stub
		jtb_display = new JTable();
		JScrollPane jsp = new JScrollPane(jtb_display);

		jsp.setPreferredSize(new Dimension(400, 200));

		this.add(jsp, "South");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main_Sung();
	}

}