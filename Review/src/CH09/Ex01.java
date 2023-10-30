package CH09;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex01 extends JFrame {
	private JButton yesB, noB;
	private JTextField nameTF, pwTF, emailTF, telTF;
	private JLabel titleL, nameL, pwL, emailL, telL;
	private JPanel titleP, bodyP;
	
	public Ex01() {
		setSize(500, 300);
		setTitle("회원 등록하기");
		
		titleP = new JPanel();
		titleL = new JLabel("회원 등록하기");
		titleP.add(titleL);
		
		bodyP = new JPanel(new GridLayout(5,2,5,5));
		
		bodyP.add(new JLabel("이름"));
		nameTF = new JTextField(10);
		bodyP.add(nameTF);
		bodyP.add(new JLabel("패스워드"));
		nameTF = new JTextField(10);
		bodyP.add(nameTF);
		bodyP.add(new JLabel("이메일 주소"));
		nameTF = new JTextField(10);
		bodyP.add(nameTF);
		bodyP.add(new JLabel("전화번호"));
		nameTF = new JTextField(10);
		bodyP.add(nameTF);
		
		yesB = new JButton("등록하기");
		bodyP.add(yesB);
		noB = new JButton("취소");
		bodyP.add(noB);
		
		add(titleP, "North"); // "North" 위치에 titleP 추가
        add(bodyP, "Center"); // "Center" 위치에 bodyP 추가
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Ex01 e = new Ex01();
	}

}
