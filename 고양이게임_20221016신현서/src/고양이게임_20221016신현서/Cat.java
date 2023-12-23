package 고양이게임_20221016신현서;

import java.awt.event.KeyEvent;

public class Cat extends GameObject {
	
    public Cat(int speed, int x, int y) {
        super("kitty_run", speed, x, y);
    }

    @Override
    public void update() {
        super.update();
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && x > 0) {
            x -= speed;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && x < 770) {
            x += speed;
        }
    }
}