package 고양이게임_20221016신현서;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Heart extends GameObject {
    private static final String HEART_IMAGE_NORMAL = "heart";
    private static final String HEART_IMAGE_DAMAGE = "blackheart";

    private boolean damaged; // 나쁜 음식에 닿았는지 여부

    public Heart(int x, int y) {
        super(HEART_IMAGE_NORMAL, 0, x, y);
        damaged = false;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
        // 이미지 변경
        if (damaged) {
            setImage(HEART_IMAGE_DAMAGE);
        } else {
            setImage(HEART_IMAGE_NORMAL);
        }
    }

    private void setImage(String imageName) {
        try {
            this.img = ImageIO.read(new File("img//" + imageName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean isDamaged() {
        return damaged;
    }

    @Override
    public void update() {
        // 하트 업데이트 로직
    }
}

class HeartManager {
    private List<Heart> hearts;
    private int count;

    public HeartManager() {
    	count = 3;
        hearts = new ArrayList<>();
        
        // 초기에 3개의 하트를 생성
        for (int i = 0; i < count; i++) {
            hearts.add(new Heart(650 + i * 40, 20));
        }
    }

    public List<Heart> getHearts() {
        return hearts;
    }

    public void handleCollisionWithBadFood() {
        // 나쁜 음식에 닿았을 때 호출되는 메서드
    	count--;
    	
        // 하트 이미지 변경
        for (Heart heart : hearts) {
            if (!heart.isDamaged()) {
                heart.setDamaged(true);
                break;
            }
        }
    }
    
    boolean isGameOver() {
        return count <= 0;
    }
}
