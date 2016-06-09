/**
 * Created by HUYNHDUC on 6/9/2016.
 */
public class PlaneFighter extends Plane implements Ifighter {
    public PlaneFighter(int positionX, int positionY, String link) {
        super(positionX, positionY, link);
    }

    @Override
    public void shot() {
        System.out.println("shot ");
    }
}
