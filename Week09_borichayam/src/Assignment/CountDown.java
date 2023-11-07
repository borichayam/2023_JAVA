package Assignment;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDown extends JFrame {
	private JLabel label;
	Thread t;
	
	class Counter extends Thread {
		public void run() {
			for (int i=0; i<=1000; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					//e.printStackTrace();
					return;
				}
				label.setText(i+"");
			}
		}
	}
 	
	public CountDown() {
		setTitle("카운트 다운");
		setSize(400,150);
		getContentPane().setLayout(null); 
		
		label = new JLabel("0");
		label.setBounds(0, 0, 384, 111); 
		label.setFont(new Font("Serif", Font.BOLD, 100));
		getContentPane().add(label); 
		
		// 멈춤 버튼 추가
		JButton stopB = new JButton("카운터 중지");
		stopB.setBounds(247, 25, 125, 30);
		stopB.addActionListener(e -> t.interrupt());
		getContentPane().add(stopB);
		// 재시작 버튼 추가
		JButton restartB = new JButton("카운트 다시 시작");
		restartB.setBounds(247, 60, 125, 30);
		restartB.addActionListener(e -> {
			if (t.isAlive()) {
				
			} else {
				t = new Counter();
				t.start();
			}
		});
		getContentPane().add(restartB);
		
		setVisible(true);
		
		// 스레드 설정
		//(new MyThread()).start();
		t = new Counter();
		t.start();
	}

	public static void main(String[] args) {
		CountDown t = new CountDown();
	}
}