package 고양이게임_20221016신현서;

import java.util.Random;

public class BadFoodThread extends Thread {
    private GamePanel gamePanel;

    public BadFoodThread(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {
        while (true) {
            generateFood();
            try {
                sleep(1500); // 음식 생성 주기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateFood() {
        Random random = new Random();
        int x = random.nextInt(770); // 랜덤한 x 좌표
        int y = 0; // 시작 위치

        BadFood badFood = new BadFood(3, x, y);

        // 게임 패널에 알림
        gamePanel.addBadFood(badFood);

        while (badFood.getY() < 550) {
            try {
                sleep(15); // 이동 주기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            badFood.setY(badFood.getY() + badFood.getSpeed());

            // 음식이 고양이와 만났을 때
            if (gamePanel.checkCollisionWithCat(badFood)) {
                // 점수 올리기
                gamePanel.decreaseScore(200);
                break;
            }
            else if(badFood.getY() > 500) {
            	break;
            }
        }

        // 게임 패널에 알림
        gamePanel.removeBadFood(badFood);
    }
}
