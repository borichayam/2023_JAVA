package 고양이게임_20221016신현서;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class CatGame extends JFrame {
	 private GamePanel gamePanel;
	 private GameMenuPanel menuPanel;
	 private GameDescriptionPanel descriptionPanel;

    public CatGame() {
        setTitle("Cat Game");
        setSize(800, 600);
        setResizable(false);  // 창 고정
        
        // 각 패널 초기화
        gamePanel = new GamePanel();
        menuPanel = new GameMenuPanel();
        descriptionPanel = new GameDescriptionPanel();

        setContentPane(menuPanel);  // 초기 화면은 메뉴 패널로 설정
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 게임 루프
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        gamePanel.updateGame();
                        gamePanel.repaint();
                    }
                });
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CatGame());
    }
    
    // 게임 화면으로 전환하는 메서드
    public void showGamePanel() {
        setContentPane(gamePanel);
        revalidate();
        repaint();
    }

    // 게임 메뉴 화면으로 전환하는 메서드
    public void showMenuScreen() {
        setContentPane(menuPanel);
        revalidate();
        repaint();
    }

    // 게임 설명 화면으로 전환하는 메서드
    public void showDescriptionPanel() {
        setContentPane(descriptionPanel);
        revalidate();
        repaint();
    }
    
    // 게임 패널 반환 메서드 추가
    public GamePanel getGamePanel() {
        return gamePanel;
    }
}