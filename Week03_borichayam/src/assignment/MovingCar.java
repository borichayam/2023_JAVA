package assignment;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovingCar extends JFrame {

	int img_x=0;
	JButton leftB, rightB;
	
	public MovingCar() {
		setSize(600, 300);
		JPanel buttonP = new JPanel();
		setSize(600, 200);
		setLayout(new BorderLayout());
		
		ImageIcon icon = new ImageIcon("src//car.png");
		JLabel carL = new JLabel();
		carL.setIcon(icon);
		carL.setSize(200,100);
		carL.setLocation(img_x, carL.getY());
		carL.setHorizontalAlignment(JLabel.CENTER);
		
		leftB = new JButton("LEFT");
		rightB = new JButton("RIGHT");
		
		leftB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                img_x -= 10;
                carL.setLocation(img_x, carL.getY());
            }
        });

        rightB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                img_x += 10;
                carL.setLocation(img_x, carL.getY());
            }
        });
		
		buttonP.add(leftB);
		buttonP.add(rightB);
		
		add(carL, BorderLayout.CENTER);
        add(buttonP, BorderLayout.SOUTH);
		
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		MovingCar f = new MovingCar();
	}
}
