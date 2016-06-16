/**
 * Created by huynh on 16-Jun-16.
 */
public interface Subject {
    void addRocketListener(IRocketlistener iRocketlistener);
    void delRockerListener(IRocketlistener iRocketlistener);
    void FireRocket();
}
