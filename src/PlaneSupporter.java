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
}
