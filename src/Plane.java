import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by HUYNHDUC on 6/7/2016.
 */
public class Plane {
    public int positionX;
    public int positionY;
    public BufferedImage image;
    public int damage;
    public int maxHP;

    public int healthPoint;
    public int speedX;
    public int speedY;
    private Image hpBar;





    public Plane(int positionX, int positionY,String link) {
        this.positionX = positionX;
        this.positionY = positionY;
healthPoint =200;
        maxHP =200;


        try {
            this.image = ImageIO.read(new File(link));
            this.hpBar = ImageIO.read(new File("Resources/HP.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void move(int x, int y) {
        positionY = y;
        positionX = x;
    }

    public void update() {
        this.positionX += this.speedX;
        this.positionY += this.speedY;
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, this.positionX, this.positionY, null);
        g.drawImage(this.hpBar, this.positionX, this.positionY + 65,
                this.positionX + 70 * healthPoint/maxHP, this.positionY + 79,
                0, 0, 200, 14, null);
    }


}
