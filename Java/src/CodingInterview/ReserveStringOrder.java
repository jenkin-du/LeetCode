import java.util.Scanner;
import java.util.Stack;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ReserveStringOrder {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();


        Stack<String> stacks = new Stack<>();
        String[] arr = str.split("\\s+");
        for (String s : arr) {
            stacks.push(s);
        }
        while (!stacks.empty()) {
            String out = stacks.peek();
            System.out.print(out);
            System.out.print(" ");

            stacks.pop();
        }
        System.out.print("\n");
    }
}
