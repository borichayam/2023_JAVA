import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradeTest extends JFrame {

	private JPanel mainP;
	private JTextField gradeTF;
	private JTextField averageTF;
	ArrayList<Integer> gradeAL = new ArrayList<> ();
	
	public GradeTest() {
		setSize(300,300);
		mainP = new JPanel(new GridLayout(3,2,10,5));
		
		JLabel gradeL = new JLabel("성적");
		gradeTF= new JTextField(10);
		
		JButton enterB = new JButton("입력");
		JButton computeB = new JButton("평균계산");
		
		JLabel everageL = new JLabel("모든 학생의 평균");
		averageTF = new JTextField(10);
		averageTF.setEditable(false);
		
		//화면에 추가
		mainP.add(gradeL);
		mainP.add(gradeTF);
		mainP.add(enterB);
		mainP.add(computeB);
		mainP.add(everageL);
		mainP.add(averageTF);
		add(mainP);
		
		//이벤트
		enterB.addActionListener(e -> {
			gradeAL.add(Integer.parseInt(gradeTF.getText()));
		});
		computeB.addActionListener(e -> {
			int sum = 0;
			for(int i:gradeAL) {
				sum += i;
			}
			averageTF.setText(sum/gradeAL.size()+"점");
		});
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		GradeTest test = new GradeTest();
	}

}
