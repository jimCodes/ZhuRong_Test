package sjms.observer.source;


/**
 * jdk源码
 * @author R.Zhu
 *
 */
public interface Observer {
    void update(Observable observable, Object arg);
}