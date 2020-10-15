package NewCode.tencent;

import java.util.Scanner;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/08/23
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Main20200823_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
            char[] arr = str.toCharArray();
            boolean flag = false;
            if (m == 1) {
                flag = true;
            } else {
                if (m % 2 == 1) {
                    for (int i = m / 2; i < n - m / 2; i++) {
                        int pre = i - 1;
                        int post = i + 1;
                        int count = 1;
                        for (; pre >= 0 && post < n; pre--, post++) {
                            if (arr[pre] == arr[post]) {
                                count += 2;
                                if (count == m) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (count == m) {
                            flag = true;
                            break;
                        }

                    }
                }

                if (m % 2 == 0) {
                    for (int i = 0; i < n; i++) {
                        int pre = i;
                        int post = i + 1;
                        int count = 0;
                        for (; pre >= 0 && post < n; pre--, post++) {
                            if (arr[pre] == arr[post]) {
                                count += 2;
                                if (count == m) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (count == m) {
                            flag = true;
                            break;
                        }

                    }
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


            t--;
        }
    }
}
