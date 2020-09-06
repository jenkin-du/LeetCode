package NewCode.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/09/06
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200906_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }

        char threshold = list.get(list.size() - 2).toCharArray()[0];
        String matchedFeature = getFeature(list.get(list.size() - 1), threshold);

        ArrayList<Integer> matchIndexes = new ArrayList<>();
        for (int i = 0; i < list.size() - 2; i++) {
            String feature = getFeature(list.get(i), threshold);
            if (feature.contains(matchedFeature)) {
                matchIndexes.add(i);
            }
        }
        for (Integer index : matchIndexes) {
            System.out.println(list.get(index));
        }
    }

    private static String getFeature(String nums, char thread) {

        char[] arr = nums.toCharArray();

        StringBuilder feature = new StringBuilder();
        for (char c : arr) {
            if (c < thread) {
                feature.append(c);
            }
        }
        return feature.toString();
    }
}
