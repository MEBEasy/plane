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
    public int healthPoint;
    public int speedX;
    public int speedY;
    Bullet dan;

    public Plane() {
        this.positionX = 200;
        this.positionY = 300;

        try {
            this.image = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public Plane(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;

        try {
            this.image = ImageIO.read(new File("Resources/PLANE3.png"));
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
    }
    public  void shootEnemy(int x,int y){
        dan= new Bullet(200,300,"Resources/DAN.png");
    }
}