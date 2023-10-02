package assignment;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class Person {
	String name;
	String tel;
	String address;
	
	public String getName() {
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String t) {
		this.name = t;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String a) {
		this.name = a;
	}
	
	public Person(String n, String t, String a) {
		super();
		this.name = n;
		this.tel = t;
		this.address = a;
	}
}

public class DirectoryTest extends JFrame{
	ArrayList<Person> list = new ArrayList<>();
	private JPanel contentP;
	private JTextField nameTF;
	private JTextField telTF;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelNumber frame = new TelNumber();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// 프레임 시작
	public DirectoryTest() {
		setTitle("Address Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 252);
		contentP = new JPanel();
		contentP.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentP);
		contentP.setLayout(null);
		
		JLabel 
	}
}
