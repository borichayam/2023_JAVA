package 고양이게임_20221016신현서;

import java.util.Random;

public class FoodThread extends Thread {
    private GamePanel gamePanel;

    public FoodThread(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {
        while (true) {
            generateFood();
            try {
                sleep(1000); // 음식 생성 주기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateFood() {
        Random random = new Random();
        int x = random.nextInt(770); // 랜덤한 x 좌표
        int y = 0; // 시작 위치

        GoodFood goodFood = new GoodFood(3, x, y);

        // 게임 패널에 알림
        gamePanel.addGoodFood(goodFood);

        while (goodFood.getY() < 550) {
            try {
                sleep(10); // 이동 주기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            goodFood.setY(goodFood.getY() + goodFood.getSpeed());

            // 음식이 고양이와 만났을 때
            if (gamePanel.checkCollisionWithCat(goodFood)) {
                // 점수 올리기
                gamePanel.increaseScore(100);
                break;
            }
            else if(goodFood.getY() > 500) {
            	break;
            }
        }

        // 게임 패널에 알림
        gamePanel.removeGoodFood(goodFood);
    }
}

