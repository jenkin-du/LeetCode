package com.hw;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] worlds = line.split(" ");
        line = sc.nextLine();
        char[] chars = line.toCharArray();

        System.out.println(wordsLength(worlds, chars));
    }

    private static int wordsLength(String[] worlds, char[] chars) {

        if (worlds.length == 0 || chars.length == 0) return 0;
        ArrayList<String> result = new ArrayList<>();
        int[] indexes = new int[256];
        for (char c : chars) {
            indexes[c - ' ']++;
        }

        for (String word : worlds) {
            char[] cArr = word.toCharArray();
            boolean flag = true;
            int[] tempIndexes = new int[256];
            System.arraycopy(indexes, 0, tempIndexes, 0, 256);
            for (char c : cArr) {
                int index = c - ' ';
                if (tempIndexes[index] > 0) {
                    tempIndexes[index]--;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(word);
            }
        }
        int length = 0;
        for (String word : result) {
            length += word.length();
        }
        return length;

//        ArrayList<String> result=new ArrayList<>();
//        ArrayList<Character> list=new ArrayList<>();
//        for (char aChar : chars) {
//            list.add(aChar);
//        }
//        for(String word:worlds){
//            char[] cArr=word.toCharArray();
//            boolean flag=true;
//            HashSet<Character> set=new HashSet<Character>();
//            for (char value : cArr) {
//                set.add(value);
//            }
//            ArrayList<Character> tempList=new ArrayList<>();
//            for (char c : set) {
//                int index = list.indexOf(c);
//                if (index != -1) {
//                    tempList.add(c);
//                } else {
//                    list.addAll(tempList);
//                    flag=false;
//                    break;
//                }
//            }
//            if (flag){
//                result.add(word);
//            }
//        }
//
//        int length=0;
//        for (String word:result){
//            length+=word.length();
//        }
//        return length;
    }
}
