package CH09;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex03 extends JFrame {
	protected JButton leftB, rightB;
	protected JLabel carL;
	protected JPanel buttonP;
	int img_x;
	
	public Ex03() {
		setTitle("left&right");
		setSize(500,300);
		
		// 이미지
		ImageIcon car = new ImageIcon("car.png");
		carL = new JLabel();
		carL.setIcon(car);
		add(carL, "Center");
		
		buttonP = new JPanel();
		leftB = new JButton("left");
		rightB = new JButton("right");
		// 버튼 이벤트
		leftB.addActionListener(e -> {
			img_x -= 10;
			carL.setLocation(img_x, carL.getY());
		});
		rightB.addActionListener(e -> {
			img_x += 10;
			carL.setLocation(img_x, carL.getY());
		});
		// 버튼 추가
		buttonP.add(leftB);
		buttonP.add(rightB);
		add(buttonP, "South");
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ex03 e = new Ex03();

	}

}
