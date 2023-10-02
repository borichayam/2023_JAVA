import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TriCicle extends JFrame {
	public TriCicle() {
		super("삼색원");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new ThreeCor());
		setSize(120, 150);
		setVisible(true);
	}
	class ThreeCor extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.CYAN);
			g.fillArc(10, 10, 100, 100, 90, 120);
			g.setColor(Color.MAGENTA);
			g.fillArc(10, 10, 100, 100, 210, 120);
			g.setColor(Color.ORANGE);
			g.fillArc(10, 10, 100, 100, 330, 120);
		}
	}
	public static void main(String[] args) {
		new TriCicle();
	}

}
