package 고양이게임_20221016신현서;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameObject {
	protected static BufferedImage defaultImage;
	protected BufferedImage img;
    protected int speed;
    protected int x;
    protected int y;
    
    static {
        try {
            defaultImage = ImageIO.read(new File("img//default.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameObject(String name, int speed, int x, int y) {
    	try {
            if (name != null && !name.isEmpty()) {
                this.img = ImageIO.read(new File("img//" + name + ".png"));
            } else {
                this.img = defaultImage;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public void update() {
    	
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }
    
    public void keyPressed(KeyEvent e) {
    	
    }
    
    public int getSpeed() {
        return speed;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
