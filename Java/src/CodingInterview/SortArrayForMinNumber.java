import java.util.ArrayList;

/**
 * 面试题45：把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数组拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * </pre>
 */
class SortArrayForMinNumber {

    public String PrintMinNumber(int[] numbers) {

        ArrayList<Integer> arrays = new ArrayList<Integer>(numbers.length);
        for (int number : numbers) {
            arrays.add(number);
        }
        arrays.sort((o1, o2) -> {
            int a = o1;
            int b = o2;

            String strA = String.valueOf(a);
            String strB = String.valueOf(b);

            String AB = strA + strB;
            String BA = strB + strA;

            return AB.compareTo(BA);
        });

        StringBuilder result = new StringBuilder();
        for (Integer integer : arrays) {
            result.append(integer);
        }
        return result.toString();
    }
}
