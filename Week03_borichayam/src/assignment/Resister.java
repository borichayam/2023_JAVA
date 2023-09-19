package assignment;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Resister extends JFrame {
	public Resister() {
		
		JPanel p = new JPanel();
		JPanel titleP = new JPanel();
		JPanel bodyP = new JPanel(new GridLayout(5,2,5,5));
		
		JLabel titleL = new JLabel("회원 등록하기");
		titleP.add(titleL);
		
		JLabel nameL = new JLabel("이름");
		JLabel pwL = new JLabel("패스워드");
		JLabel emailL = new JLabel("이메일 주소");
		JLabel pnL = new JLabel("전화번호");
		JTextField nameTF = new JTextField(10);
		JTextField pwTF = new JTextField(10);
		JTextField emailTF = new JTextField(10);
		JTextField pnTF = new JTextField(10);
		bodyP.add(nameL);
		bodyP.add(nameTF);
		bodyP.add(pwL);
		bodyP.add(pwTF);
		bodyP.add(emailL);
		bodyP.add(emailTF);
		bodyP.add(pnL);
		bodyP.add(pnTF);
		
		JButton resB = new JButton("등록하기");
		JButton conB = new JButton("취소");
		bodyP.add(resB);
		bodyP.add(conB);
		
		p.add(titleP);
		p.add(bodyP);
		add(p);
		
		setSize(300,300);
		setVisible(true);
 	}
	public static void main(String[] args) {
		Resister r = new Resister();
	}

}
