import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by HUYNHDUC on 6/7/2016.
 */
public class Bullet {
    public int postionX;
    public int postionY;
    public int speedX = 0;
    public int speedY = 0;
    public BufferedImage image;

    //contrucster

    public Bullet(int postionX, int postionY, String pathImage) {

        this.postionX = postionX;
        this.postionY = postionY;
        try {
            this.image = ImageIO.read(new File(pathImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(int x, int y) {

        postionX = x;
        postionY = y;

    }

    public void update() {
        this.postionY -= this.speedY;
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, this.postionX, this.postionY, null);
    }
}
