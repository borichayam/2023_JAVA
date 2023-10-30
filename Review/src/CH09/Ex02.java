package CH09;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex02 extends JFrame {
	protected JTextField mileTF, kmTF;
	protected JButton enterB;
	protected JPanel p;
	
	public Ex02() {
		setSize(350,100);
		setTitle("Mile->Km");
		
		p = new JPanel();
		p.add(new JLabel("마일을 입력하시오"));
		
		mileTF = new JTextField(10);
		p.add(mileTF);
		
		p.add(new JLabel("->"));
		
		kmTF = new JTextField(10);
		kmTF.setEditable(false);
		p.add(kmTF);
		
		enterB = new JButton("변환");
		
		enterB.addActionListener(e -> {
			int mile = Integer.parseInt(mileTF.getText());
			kmTF.setText(" "+mile*1.609344);
		});
		
		p.add(enterB);
		
		add(p);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ex02 e = new Ex02();
	}

}
