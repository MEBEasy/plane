import java.awt.*;
import java.util.List;

/**
 * Created by huynh on 15-Jun-16.
 */
public class PlaneSupporter extends Plane implements ISupport {
    public PlaneSupporter(int positionX, int positionY, String link) {
        super(positionX, positionY, link);
    }

    @Override
    public void bonusHP(List<Plane> planes) {
        for (Plane plane : planes) {
            plane.healthPoint += 10;
            System.out.println(plane.healthPoint);
        }
    }

    @Override
    public void bonusHP(Plane plane) {
        plane.healthPoint += 10;
        System.out.println(plane.healthPoint);
    }

    @Override
    public void update() {
        super.update();
        Rectangle myPlane = new Rectangle(this.positionX, this.positionY, this.image.getWidth(), this.image.getHeight());
        for (Bullet b : PlaneFighter.getInstance().getListBullet()) {
            Rectangle rectBullet = new Rectangle(b.postionX, b.postionY, b.getImage().getWidth(), b.getImage().getHeight());

            if (myPlane.intersects(rectBullet)) {
                System.out.println("va cham");

                if(this.healthPoint >= 5){
                    this.healthPoint -= 5;
                }
            }
        }

    }
}
