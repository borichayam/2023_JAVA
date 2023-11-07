import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest extends JFrame {
	private JLabel label;
	Thread t; // 추가
	
	class Counter extends Thread {
		public void run() {
			for (int i=0; i<=1000; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					//e.printStackTrace();
					return; // 추가
				}
				label.setText(i+"");
			}
		}
	}
 	
	public CountDownTest() {
		setTitle("카운트 다운");
		setSize(400,150);
		getContentPane().setLayout(null); // 추가
		
		label = new JLabel("0");
		label.setBounds(0, 0, 384, 111); // 추가
		label.setFont(new Font("Serif", Font.BOLD, 100));
		getContentPane().add(label); // 추가
		
		// 버튼 추가
		JButton stopB = new JButton("카운터 중지");
		stopB.setBounds(247, 25, 125, 23);
		stopB.addActionListener(e -> t.interrupt());
		getContentPane().add(stopB);
		
		setVisible(true);
		
		// 스레드 설정
		//(new MyThread()).start();
		t = new Counter();
		t.start();
	}
	
	public static void main(String[] args) {
		CountDownTest t = new CountDownTest();
	}
}
