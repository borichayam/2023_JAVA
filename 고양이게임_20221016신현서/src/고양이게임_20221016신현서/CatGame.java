package 고양이게임_20221016신현서;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class CatGame extends JFrame {
	private GamePanel gamePanel;

    public CatGame() {
        setTitle("Cat Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gamePanel = new GamePanel();
        setContentPane(gamePanel);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

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
}