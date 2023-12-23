package 고양이게임_20221016신현서;

import java.util.Random;

public class GoodFood extends GameObject {
	private int dy;
	private static final String[] GOOD_FOOD_IMAGES = {
    		"goodfood1", "goodfood2", "goodfood3", "goodfood4", 
    		"goodfood5", "goodfood6", "goodfood7"};

	public GoodFood(int speed, int x, int y) {
    	super(GOOD_FOOD_IMAGES[new Random().nextInt(GOOD_FOOD_IMAGES.length)], speed, x, y);
        
    	Random random = new Random();
        this.dy = random.nextInt(3) + 1; // 랜덤한 속도
    }

    @Override
    public void update() {
        y += dy;
        super.update();
    }
}