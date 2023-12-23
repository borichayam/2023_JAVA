package 고양이게임_20221016신현서;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
	//private List<GameObject> gameObjects; // 모든 게임 오브젝트를 담는 리스트
    private List<GoodFood> goodFoods; // 좋은 음식 리스트
    private List<BadFood> badFoods; // 나쁜 음식 리스트
    private List<Heart> hearts; // 하트 리스트
    private HeartManager heartManager;
    private Cat cat; // 고양이 객체
    private int score; // 점수
    private boolean gameOver; // 게임 오버 여부를 나타내는 변수
    private boolean gameClear; // 게임 클리어 여부를 나타내는 변수

    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        
        // 초기화
        //gameObjects = new ArrayList<>();
        goodFoods = new ArrayList<>();
        badFoods = new ArrayList<>();
        cat = new Cat(5, 400, 450);
        score = 0;
        gameOver = false; 
        gameClear = false; 
        
        // 하트 매니저 초기화 및 추가
        heartManager = new HeartManager();
        hearts = heartManager.getHearts();
        
        // 좋은 음식 추가 스레드 시작
        FoodThread foodThread = new FoodThread(this);
        foodThread.start();
        
        // 나쁜 음식 추가 스레드 시작
        BadFoodThread badFoodThread = new BadFoodThread(this);
        badFoodThread.start();
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                cat.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        addKeyListener(this);
        setFocusable(true);
    }
    
    // 화면 그리기 메서드
    public void paint(Graphics g) {
        super.paint(g);
        
        // 배경 그리기
        if (gameOver) {
            // 게임 오버 시 검정색 배경
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());
        } else {
            // 게임 중일 때 배경 설정
            // 하늘색
            g.setColor(new Color(135, 206, 235)); // RGB 값으로 하늘색 지정 (Sky Blue)
            g.fillRect(0, 0, getWidth(), 400);

            // 초록색
            g.setColor(new Color(0, 128, 0)); // RGB 값으로 초록색 지정 (Green)
            g.fillRect(0, 400, getWidth(), 200);
        }
        
        
        if (!gameOver && !gameClear) { // 게임 오버, 클리어 상태가 아닌 경우에만 게임 화면을 그림
            cat.draw(g);

            for (GoodFood goodFood : goodFoods) {
                goodFood.draw(g);
            }

            for (BadFood badFood : badFoods) {
                badFood.draw(g);
            }

            // 하트 그리기
            for (Heart heart : hearts) {
                heart.draw(g);
            }

            // 점수 표시
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Score: " + score, 10, 30);
            
        } else if (gameOver) { // 게임 오버 상태일 때는 'GameOver' 표시
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", getWidth() / 2 - 130, getHeight() / 2);
            
            ImageIcon img = new ImageIcon("img//kitty_gameover.png");
            g.drawImage(img.getImage(), 350, 450, this);
            
        } else {
        	// 게임 클리어 상태일 때는 'GameClear' 표시
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("**Game Clear**", getWidth() / 2 - 130, getHeight() / 2);

            // 이미지 그리기
            ImageIcon img = new ImageIcon("img//kitty_gameclear.png");
            g.drawImage(img.getImage(), 400, 450, this);
        }
    }

    // 게임 업데이트 메서드
    public void updateGame() {
        cat.update();

        /*for (GoodFood goodFood : goodFoods) {
            goodFood.update();
            if (goodFood.y > getHeight()) {
                goodFoods.remove(goodFood);
            }
        }

        for (BadFood badFood : badFoods) {
            badFood.update();
            if (badFood.y > getHeight()) {
                badFoods.remove(badFood);
            } else if (cat.x < badFood.x + badFood.img.getWidth() &&
                    cat.x + cat.img.getWidth() > badFood.x &&
                    cat.y < badFood.y + badFood.img.getHeight() &&
                    cat.y + cat.img.getHeight() > badFood.y) {
                badFoods.remove(badFood);
                // 나쁜 음식과의 충돌 처리 (점수 및 생명력 감소)
            }
        }*/
        
        // 하트 업데이트 로직
        for (Heart heart : hearts) {
            heart.update();
        }
    }
    
    // 좋은 음식 추가 메서드
    public void addGoodFood(GoodFood goodFood) {
        goodFoods.add(goodFood);
    }

    // 좋은 음식 제거 메서드
    public void removeGoodFood(GoodFood goodFood) {
        goodFoods.remove(goodFood);
    }

    // 점수 증가 메서드
    public void increaseScore(int points) {
        score += points;
        
        if (isGameClear()) {
        	showGameClearScreen();
        }
    }
    
    // 좋은 음식과 충돌 여부 메서드
    boolean checkCollisionWithCat(GameObject goodFood) {
        // 고양이와 음식의 충돌 여부 확인
        int catX = cat.getX();
        int catY = cat.getY();
        int foodX = goodFood.getX();
        int foodY = goodFood.getY();
        int distance = (int) Math.sqrt(Math.pow(catX - foodX, 2) + Math.pow(catY - foodY, 2));

        return distance < 100; // 임의의 거리값
    }
    
    // 나쁜 음식 추가 메서드
    public void addBadFood(BadFood badFood) {
    	badFoods.add(badFood);
    }

    // 좋은 음식 제거 메서드
    public void removeBadFood(BadFood badFood) {
    	badFoods.remove(badFood);
    }

    // 점수 감소 메서드 + 생명 깎임
    public void decreaseScore(int points) {
        score -= points;
        
        // 생명 깎임
        heartManager.handleCollisionWithBadFood();
        
        // 게임 종료 여부 확인
        if (heartManager.isGameOver()) {
            // 게임 오버 처리
            showGameOverScreen();
        }
    }
    
    // 게임 오버 화면 표시 메서드
    private void showGameOverScreen() {
        // 화면의 모든 이미지를 없애는 작업
        goodFoods.clear();
        badFoods.clear();
        
        gameOver = true;
        

        // 화면에 'GameOver' 표시
        repaint(); // 화면 갱신
    }
    
    public boolean isGameClear() {
        return score >= 1000; // 예제에서는 1000점에 도달하면 클리어로 가정
    }
    
    private void showGameClearScreen() {
        // 화면의 모든 이미지를 없애는 작업
        goodFoods.clear();
        badFoods.clear();
        
        gameClear = true;

        // 화면에 'GameClear' 표시
        repaint(); // 화면 갱신
    }

    @Override
    public void keyPressed(KeyEvent e) {
        cat.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 키 릴리즈 처리
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 키 타입 처리
    }
}

