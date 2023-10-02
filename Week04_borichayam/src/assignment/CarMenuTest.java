package assignment;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarMenuTest extends JFrame{

	JCheckBox[] buttons = new JCheckBox[4];
	String[] items = {"엔진오일 교환", "자동변속기오일 교환", "에어콘필터 교환", "타이어 교환"};
	int[] prices = {45000, 80000, 30000, 100000};
	int money = 0;
	JLabel label;
	
	public CarMenuTest() {

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.X_AXIS));

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JCheckBox(items[i]);
            buttons[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    money = 0; // 합계 초기화
                    for (int j = 0; j < 4; j++) {
                        if (buttons[j].isSelected()) {
                            money += prices[j]; // 선택된 체크박스만 가격 누적
                        }
                    }
                    label.setText("현재까지의 가격은 " + money + "원 입니다.");
                }
            });
            checkBoxPanel.add(buttons[i]);
        } //챗 gpt의 도움... 좀 더 공부하자

        label = new JLabel("현재까지의 가격은 0원 입니다.");
        label.setFont(new Font("굴림", Font.BOLD, 24));

        setLayout(new BorderLayout());
        add(checkBoxPanel, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
	
	public static void main(String[] args) {
		CarMenuTest c = new CarMenuTest();

	}

}
