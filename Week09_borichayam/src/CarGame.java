import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarGame extends JFrame {
	private JLabel raceL;
	
	class MyThread extends Thread {
		private JLabel label;
		private int x,y;
		
		public MyThread(String fname, int x, int y) {
			this.x = x;
			this.y = y;
			
			label = new JLabel();
			label.setIcon(new ImageIcon(fname));
			label.setBounds(x, y, 100, 100);
			add(label);
		}
		
		public void run() {
			for (int i=0; i<200; i++) {
				x += 10*Math.random();
				label.setBounds(x, y, 100, 100);
				repaint();
				
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public CarGame() {
		setTitle("CarRace");
		setSize(600,200);
		setLayout(null);
		
		// race 사진
		raceL = new JLabel();
		raceL.setIcon(new ImageIcon("src//img//race.gif"));
		raceL.setBounds(0, 0, 100, 100);
		add(raceL);
		
		// car 주행
		(new MyThread("src//img//car1.gif", 100, 0)).start();
		(new MyThread("src//img//car2.gif", 100, 50)).start();
		(new MyThread("src//img//car3.gif", 100, 100)).start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	// 결승선 그리기
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(500, 0, 500, 200); // 수직 결승선 그리기
    }
	
	public static void main(String[] args) {
		CarGame t = new CarGame();
	}
}
