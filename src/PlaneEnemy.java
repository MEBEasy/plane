/**
 * Created by huynh on 16-Jun-16.
 */
public class PlaneEnemy extends Plane implements IRocketlistener {
    public PlaneEnemy(int positionX, int positionY, String link) {
        super(positionX, positionY, link);
    }



    @Override
    public int planeFireRocket() {

        System.out.println("chet roi nhe !");

        return 1;
    }
}
