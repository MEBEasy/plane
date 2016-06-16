import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HUYNHDUC on 6/9/2016.
 */
public class PlaneFighter extends Plane implements Ifighter, Subject {

    private ArrayList<IRocketlistener> iRocketlistenerArrayList = new ArrayList<>();


    private ArrayList<Bullet> listBullet;
    private static PlaneFighter sharePointer;

    public ArrayList<Bullet> getListBullet() {
        return listBullet;
    }

    public static PlaneFighter getInstance() {

        if (sharePointer == null) {
            sharePointer = new PlaneFighter(100, 200, "Resources/PLANE2.png");
        }
        return sharePointer;
    }

    public PlaneFighter(int positionX, int positionY, String link) {
        super(positionX, positionY, link);
        listBullet = new ArrayList<>();
    }

    @Override
    public void update() {
        super.update();
        for (Bullet b : listBullet) {
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (Bullet b : listBullet) {
            b.draw(g);
        }
    }

    public void shot() {
        listBullet.add(new Bullet(this.positionX, this.positionY, "Resources/DAN.png"));
    }

    @Override
    public void dropBoom() {
        System.out.println("the boom");
    }

    @Override
    public void addRocketListener(IRocketlistener iRocketlistener) {
        iRocketlistenerArrayList.add(iRocketlistener);

    }

    @Override
    public void delRockerListener(IRocketlistener iRocketlistener) {
        iRocketlistenerArrayList.remove(iRocketlistener);
    }

    @Override
    public void FireRocket() {
        System.out.println("ban ten lua");
        for (IRocketlistener iRocketlistener : iRocketlistenerArrayList) {
            iRocketlistener.planeFireRocket();
        }
    }
}
