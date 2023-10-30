package CH11;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex02 extends JFrame {
	JCheckBox[] buttons = new JCheckBox[4];
	String[] items = {"엔진오일 교환", "자동변속기오일 교환", "에어콘필터 교환", "타이어 교환"};
	int[] prices = {45000, 80000, 30000, 100000};
	int money = 0;
	JLabel label;
	
	public Ex02() {
		setTitle("CheckBoxDemo");
		setSize(530,200);
		
		JPanel checkP = new JPanel();
		
		label = new JLabel("현재까지의 가격은 0원입니다.");
		label.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 30));
		
		// 체크박스 생성 및 이벤트 
		for (int i=0; i<4; i++) {
			buttons[i] = new JCheckBox(items[i]);
			
			// 이벤트
			buttons[i].addItemListener(e -> {
				money = 0; // 합계 초기화
				for (int j=0; j<4; j++) {
					if (buttons[j].isSelected()) {
						money += prices[j];
					}
				}
				label.setText("현재까지의 가격은 "+money+"원입니다.");
			});
			checkP.add(buttons[i]);
		}
		
		add(checkP, "Center");
		add(label, "South");
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ex02 e = new Ex02();
	}

}
