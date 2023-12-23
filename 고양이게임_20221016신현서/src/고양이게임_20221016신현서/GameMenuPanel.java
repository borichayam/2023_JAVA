package 고양이게임_20221016신현서;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameMenuPanel extends JPanel {
	private ImageIcon catImage;
	
    public GameMenuPanel() {
    	setLayout(null); // 레이아웃 매니저를 사용하지 않음
        setPreferredSize(new Dimension(800, 600));
        
        catImage = new ImageIcon("img//kitty_menu.png");

        // '고양이 사냥 게임' 글씨
        JLabel titleLabel = new JLabel("고양이 사냥 게임");
        titleLabel.setFont(new Font("돋움", Font.BOLD, 40));
        titleLabel.setBounds(250, 50, 400, 50); // x, y, width, height
        add(titleLabel);

        // 버튼 생성 및 위치 설정
        JButton startButton = new JButton("게임 시작");
        startButton.setBounds(375, 200, 100, 25); // x, y, width, height
        add(startButton);

        JButton descriptionButton = new JButton("게임 설명");
        descriptionButton.setBounds(375, 235, 100, 25); 
        add(descriptionButton);

        JButton exitButton = new JButton("종료");
        exitButton.setBounds(375, 270, 100, 25); 
        add(exitButton);
        
        // 버튼 액션 리스너 등록
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 게임 시작 버튼 클릭 시 게임을 시작하는 코드 작성
                showGamePanel();
            }
        });

        descriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 게임 설명 버튼 클릭 시 게임 설명 화면을 보여주는 코드 작성
                showDescriptionPanel();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 종료 버튼 클릭 시 게임 종료 코드 작성
                System.exit(0);
            }
        });
    }
    
    // 배경 그리기
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // 하늘색
        g.setColor(new Color(135, 206, 235)); // RGB 값으로 하늘색 지정 (Sky Blue)
        g.fillRect(0, 0, getWidth(), 400);

        // 초록색
        g.setColor(new Color(0, 128, 0)); // RGB 값으로 초록색 지정 (Green)
        g.fillRect(0, 400, getWidth(), 200);
        
        // 이미지 그리기
        //ImageIcon img = new ImageIcon("img//kitty_menu.png");
        catImage.paintIcon(this, g, 350, 450);
    }

    // 게임 화면으로 전환하는 메서드
    private void showGamePanel() {
        CatGame catGame = (CatGame) SwingUtilities.getWindowAncestor(this);
        catGame.showGamePanel();
        
        // 포커스를 GamePanel로 이동
        catGame.getGamePanel().requestFocusInWindow();
    }

    // 게임 설명 화면으로 전환하는 메서드
    private void showDescriptionPanel() {
        CatGame catGame = (CatGame) SwingUtilities.getWindowAncestor(this);
        catGame.showDescriptionPanel();
    }
}

