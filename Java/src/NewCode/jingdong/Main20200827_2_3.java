package NewCode.jingdong;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/27
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200827_2_3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while (m > 0) {

            int t = scanner.nextInt();
            if (t == 1) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                //插入数据
                list.add(index - 1, value);
            }
            //删除数据
            if (t == 2) {
                int index = scanner.nextInt();
                list.remove(index - 1);
            }
            //查询数据
            if (t == 3) {
                for (Integer integer : list) {
                    System.out.print(integer);
                    System.out.print(" ");
                }
                System.out.println();
            }

            m--;
        }
    }
}
