package middle;

import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex01 extends JFrame {
	protected JTextField nameTF, numTF, gradeTF;
	protected JLabel titleL;
	protected JButton yesB, noB;
	protected JPanel inputP, buttonP;
	
	public Ex01() {
		setTitle("덕성여대 화이팅");
		setSize(300, 200);
		
		// 등록 패널
		inputP = new JPanel(new GridLayout(3, 2));
		inputP.add(new JLabel("이름"));
        nameTF = new JTextField();
        inputP.add(nameTF);
		inputP.add(new JLabel("학번"));
        numTF = new JTextField();
        inputP.add(numTF);
        inputP.add(new JLabel("성적"));
        gradeTF = new JTextField();
        inputP.add(gradeTF);
        
        // 버튼 패널
        buttonP = new JPanel();
        yesB = new JButton("등록하기");
        yesB.addActionListener(e -> {
        	String name = nameTF.getText();
        	String num = numTF.getText();
        	String grade = gradeTF.getText();
        	
        	System.out.println("이름: "+name+" 학번: "+num+" 성적: "+grade);
        });
        noB = new JButton("취소");
        noB.addActionListener(e -> {
        	System.exit(0);
        });
        buttonP.add(yesB);
        buttonP.add(noB);
        
        // 프레임에 추가
        add(inputP, "Center");
        add(buttonP, "South");
        
        // 타이틀 레이블
        titleL = new JLabel("학생 등록하기");
        titleL.setFont(new Font("굴림", Font.PLAIN, 24));
        add(titleL, "North");
        
        // 프레임 설정
        setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ex01 e = new Ex01();
	}

}
