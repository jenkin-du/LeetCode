package NewCode.NetEasy;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/08
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200808_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            if (map.containsKey(word)) {
                int value = map.get(word);
                map.put(word, value + 1);
            } else {
                map.put(word, 1);
            }
        }

        int result = 0;
        Set<String> keys = map.keySet();
        for (String key : keys) {
            int count = map.get(key);

            double ratio = count * 1.0 / n;
            if (ratio > 0.01) {
                result++;
            }
        }

        System.out.println(result);
    }
}
