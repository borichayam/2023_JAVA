package assignment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Change extends JFrame {
	int km = 0;
	
	public Change() {
		setTitle("Mile -> Km");
		JPanel p = new JPanel();
		add(p);
		
		JLabel expL = new JLabel("마일을 입력하시오");
		JTextField kmTF = new JTextField(10);
		JLabel arrowL = new JLabel("->");
		JTextField mileTF = new JTextField(10);
		mileTF.setEditable(false);
		JButton changeB = new JButton("변환");
		
		p.add(expL);
		p.add(kmTF);
		p.add(arrowL);
		p.add(mileTF);
		p.add(changeB);
		
		changeB.addActionListener(e -> {
			km = Integer.parseInt(kmTF.getText());
			mileTF.setText(km*1.609344+"km");
		});
		
		setSize(500,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Change c = new Change();
	}

}
