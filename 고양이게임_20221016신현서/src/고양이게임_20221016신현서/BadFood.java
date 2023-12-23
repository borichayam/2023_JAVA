package 고양이게임_20221016신현서;

import java.util.Random;

public class BadFood extends GameObject {
	private int dy;
	private static final String[] BAD_FOOD_IMAGES = {
    		"badfood1", "badfood2", "badfood3",
    		"badfood4", "badfood5", "badfood6"};

    public BadFood(int speed, int x, int y) {
    	super(BAD_FOOD_IMAGES[new Random().nextInt(BAD_FOOD_IMAGES.length)], speed, x, y);
        
    	Random random = new Random();
        this.dy = random.nextInt(100) + 1; // 랜덤한 속도
    }

    @Override
    public void update() {
        y += dy;
        super.update();
    }
}