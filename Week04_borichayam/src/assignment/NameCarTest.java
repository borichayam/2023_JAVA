package assignment;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NameCarTest extends JFrame{
	private JPanel mainP;
	private JPanel imageP;
	private JPanel textP;
	private JLabel imageL;
	private JLabel textL_1;
	private JLabel textL_2;
	private JLabel textL_3;
	
	public NameCarTest() {
		mainP = new JPanel();
		imageP = new JPanel();
		textP = new JPanel();
		
		// 원본 이미지 로드
        ImageIcon originalIcon = new ImageIcon("src/image1.png"); // 이미지 파일 경로 수정 필요
        Image originalImage = originalIcon.getImage();

        // 축소할 크기 설정
        int newWidth = 100;
        int newHeight = 100;

        // 이미지를 새로운 크기로 조정
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        
        // 새로운 이미지를 JLabel에 표시
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
		imageL = new JLabel();
		imageL.setIcon(scaledIcon);
		imageP.add(imageL);
		
		textL_1 = new JLabel("덕새");
		textL_2 = new JLabel("덕성여자대학교");
		textL_3 = new JLabel("사이버보안학과");
		
		textP.setLayout(new GridLayout(3, 1));
		textP.add(textL_1);
		textP.add(textL_2);
		textP.add(textL_3);
		
		//화면 넣기
		mainP.add(imageP);
		mainP.add(textP);
		add(mainP);
		
		pack(); // 컴포넌트 크기에 맞게 프레임 크기 조정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		NameCarTest a = new NameCarTest();
	}

}
