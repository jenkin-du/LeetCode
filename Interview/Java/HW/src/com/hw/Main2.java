package com.hw;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/09/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Main2 {

    public class Queue {

        public int[] arr;
        public int head = -1;
        public int tail = -1;

        public int capcity = 10;

        public Queue() {
            arr = new int[capcity];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return (tail + 1) % capcity == head;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str == null || str.length() == 0) {
            System.out.println(0);
            return;
        }
        char[] cArr = str.toCharArray();
        int[] indexes = new int[256];
        for (int i = 0; i < 256; i++) {
            indexes[i] = -1;
        }
        int maxLength = 1;
        int currentLength = 1;
        indexes[cArr[0] - ' '] = 0;
        for (int i = 1; i < cArr.length; i++) {
            int index = cArr[i] - ' ';
            if (indexes[index] == -1 || (i - currentLength) > indexes[index]) {
                currentLength++;
            } else {
                currentLength = i - indexes[index];
            }
            indexes[index] = i;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        System.out.println(maxLength);

    }
}
