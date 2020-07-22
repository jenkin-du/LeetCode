package DesignPattern;

import java.util.ArrayList;

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
public class ObserverPattern {
    //观察接口
    public interface Observer {
        void update(String msg);
    }

    //主题接口
    public interface Subject {

        void addObserver(Observer observer);

        void removeObserver(Observer observer);

        void notifyObservers(String msg);

        void operate();
    }


    public class Observer1 implements Observer {

        @Override
        public void update(String msg) {
            System.out.println("observer1 received the msg:" + msg);
        }
    }

    public class Observer2 implements Observer {

        @Override
        public void update(String msg) {
            System.out.println("observer2 received the msg:" + msg);
        }
    }

    public abstract class AbstractSubject implements Subject {

        private ArrayList<Observer> observers = new ArrayList<>();

        @Override
        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers(String msg) {
            for (Observer o : observers) {
                o.update(msg);
            }
        }
    }

    public class MySubject extends AbstractSubject {

        @Override
        public void operate() {
            String msg = "MySubject send msg";
            notifyObservers(msg);
        }
    }


}
