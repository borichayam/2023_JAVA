package 고양이게임_20221016신현서;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class GameDescriptionPanel extends JPanel {
    public GameDescriptionPanel() {
    	setLayout(null);

    	// 게임 규칙 텍스트 영역
        JTextArea gameRulesTextArea = new JTextArea();
        gameRulesTextArea.setText("고양이에게 해로운 음식을 피해 사냥을 하는 고양이를 도와주세요!\n\n"
        		+ "	<게임 규칙> \n"
        		+ "	1. 좋은 음식, 사냥감을 먹을 시 점수 100 오름\n"
        		+ "	2. 나쁜 음식, 쓰레기 등을 먹을 시 점수 200 깎임 + 생명도 깎임\n"
        		+ "	3. 생명은 3개. 모두 없어지면 게임 오버.\n"
        		+ "	4. 고양이는 좌우로만 움직임(좌우 방향키)\n"
        		+ "	5. 점수 1000점 달성 시 게임 클리어");
        gameRulesTextArea.setEditable(false);
        JScrollPane gameRulesScrollPane = new JScrollPane(gameRulesTextArea);
        gameRulesScrollPane.setBounds(150, 10, 500, 140);
        add(gameRulesScrollPane);

        // 좋은 음식 목록 텍스트 영역
        JTextArea goodFoodListTextArea = new JTextArea();
        goodFoodListTextArea.setText("좋은 음식 목록:\n"
        		+ "	1. 칠면조\n	2. 고양이사료\n	3. 오리\n	4. 구운 생선\n"
        		+ "	5. 과일\n	6. 토끼\n	7. 고구마");
        goodFoodListTextArea.setEditable(false);
        JScrollPane goodFoodListScrollPane = new JScrollPane(goodFoodListTextArea);
        goodFoodListScrollPane.setBounds(150, 160, 500, 80);
        add(goodFoodListScrollPane);

        // 좋은 음식 이미지들
        for (int i = 1; i < 8; i++) {
            ImageIcon goodFoodImage = new ImageIcon("img//goodfood" + i + ".png");
            JLabel goodFoodImageLabel = new JLabel(goodFoodImage);
            goodFoodImageLabel.setBounds(150 + (i-1) * 70, 250, 60, 60);
            add(goodFoodImageLabel);
        }

        // 나쁜 음식 목록 텍스트 영역
        JTextArea badFoodListTextArea = new JTextArea();
        badFoodListTextArea.setText("나쁜 음식 목록:\n"
        		+ "	1. 초콜릿\n	2. 커피콩\n	3. 생선뼈\n	"
        		+ "4. 포도\n	5. 쓰레기\n	6. 상한 고기");
        badFoodListTextArea.setEditable(false);
        JScrollPane badFoodListScrollPane = new JScrollPane(badFoodListTextArea);
        badFoodListScrollPane.setBounds(150, 320, 500, 80);
        add(badFoodListScrollPane);

        // 나쁜 음식 이미지들
        for (int i = 1; i < 7; i++) {
            ImageIcon badFoodImage = new ImageIcon("img//badfood" + i + ".png");
            JLabel badFoodImageLabel = new JLabel(badFoodImage);
            badFoodImageLabel.setBounds(150 + (i-1) * 70, 410, 60, 60);
            add(badFoodImageLabel);
        }

        // "이전" 버튼
        JButton previousButton = new JButton("이전");
        previousButton.setBounds(375, 500, 100, 25);
        add(previousButton);

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 이전 버튼 클릭 시 게임 메뉴 화면으로 돌아가는 코드 작성
            	showMenuScreen();
            }
        });
    }
    
    // 메뉴 화면으로 돌아가는 메서드
    private void showMenuScreen() {
        CatGame catGame = (CatGame) SwingUtilities.getWindowAncestor(this);
        catGame.showMenuScreen();
    }
}

