package assignment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovingCar extends JFrame {

	int img_x=150, img_y=150;
	JButton leftB, rightB;
	
	public MovingCar() {
		setSize(600, 300);
		
		JPanel moveP = new JPanel();
		JPanel buttonP = new JPanel();
		
		ImageIcon icon = new ImageIcon("src//car.png");
		JLabel carL = new JLabel();
		carL.setIcon(icon);
		carL.setSize(200,100);
		carL.setLocation(img_x, img_y);
		
		JPanel panel = new JPanel();
		leftB = new JButton("LEFT");
		rightB = new JButton("RIGHT");
		panel.setLayout(null);
		
		moveP.add(carL);
		buttonP.add(leftB);
		buttonP.add(rightB);
		
		
		});
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		MovingCar f = new MovingCar();
	}

}
