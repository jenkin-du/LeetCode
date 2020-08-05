package NewCode.guangfa;

import java.util.HashMap;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/07/31
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main {

    public static void main(String[] args) {

        System.out.println(convert("一百六十三"));
    }

    public static String convert(String number) {
        // write code here
        char[] nums = number.toCharArray();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("零", 0);
        map.put("一", 1);
        map.put("二", 2);
        map.put("三", 3);
        map.put("四", 4);
        map.put("五", 5);
        map.put("六", 6);
        map.put("七", 7);
        map.put("八", 8);
        map.put("九", 9);

        HashMap<String, Long> cn = new HashMap<>();
        cn.put("十", 10L);
        cn.put("百", 100L);
        cn.put("千", 1000L);
        cn.put("万", 10000L);
        cn.put("亿", 100000000L);

        long result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            String str = String.valueOf(nums[i]);
            int tmp = map.get(str);
            if (i + 1 < nums.length) {
                String s = String.valueOf(nums[i + 1]);
                result = result + tmp * cn.get(s);
            } else {
                result = result + tmp;
            }

        }
        return String.valueOf(result);
    }
}
