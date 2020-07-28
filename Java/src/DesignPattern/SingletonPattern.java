package DesignPattern;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/07/16
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
public class SingletonPattern {

    private static volatile SingletonPattern singleton = null;

    private SingletonPattern() {

    }

    public static SingletonPattern getInstance() {
        if (singleton == null) {
            synchronized (SingletonPattern.class) {
                if (singleton == null) {
                    singleton = new SingletonPattern();
                }
            }
        }
        return singleton;
    }
}
