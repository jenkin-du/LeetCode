package DesignPattern;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/07
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class ProducerAndConsumer {

    public static final int CAPACITY = 5;

    public static int data;

    public static class Producer extends Thread {

        final Queue<Integer> queue;
        String name;
        int maxSize;


        public Producer(String name, Queue<Integer> queue) {
            this.name = name;
            this.queue = queue;
            this.maxSize = CAPACITY;
        }

        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()) {
                synchronized (queue) {
                    while (queue.size() == maxSize) {
                        try {
                            System.out.println("Producer :" + name + " waiting!");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    data++;
                    queue.offer(data);
                    queue.notifyAll();
                    System.out.println("Producer :" + name + " produce " + data);
                }

                Random r = new Random();
                try {
                    Thread.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static class Consumer extends Thread {
        final Queue<Integer> queue;
        String name;

        public Consumer(String name, Queue<Integer> queue) {
            this.name = name;
            this.queue = queue;
        }


        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("Consumer :" + name + " waiting!");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int data = queue.poll();
                    queue.notifyAll();
                    System.out.println("Consumer :" + name + " consume " + data);

                }

                Random r = new Random();
                try {
                    Thread.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        Thread producer1 = new Producer("P-1", queue);
//        Thread producer2 = new Producer("P-2", queue);
//        Thread producer3 = new Producer("P-3", queue);
//        Thread producer4 = new Producer("P-4", queue);
//        Thread producer5 = new Producer("P-5", queue);
//        Thread producer6 = new Producer("P-5", queue);

        Thread consumer1 = new Consumer("C-1", queue);
        Thread consumer2 = new Consumer("C-2", queue);
        Thread consumer3 = new Consumer("C-3", queue);

        producer1.start();
//        producer2.start();
//        producer3.start();
//        producer4.start();
//        producer5.start();
//        producer6.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
