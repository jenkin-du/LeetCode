package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/11
 *     标题   : 数组中的逆序数
 *     题目   :
 *     思路   :
 * </pre>
 */
class InversePairs_51 {

    public static void main(String[] args) {

        int[] arr = {14, 12, 15, 13, 11, 16, 9};
        System.out.println(reversePairs(arr));

    }

    private static int reversePairs(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int start, int end) {

        if (start == end) {
            return 0;
        }

        int length = end - start;
        int middle = start + length / 2;
        int start2 = middle + 1;

        //对前半段进行归并排序
        int left = mergeSort(arr, start, middle);
        //对后半段进行归并排序
        int right = mergeSort(arr, start2, end);

        //合并时的逆序数
        int count = 0;
        //对排好序的两段进行合并
        int[] aux = new int[length + 1];
        int p1 = middle;
        int p2 = end;
        int p3 = length + 1;
        while (p1 >= start || p2 >= start2) {
            p3--;
            if (p1 >= start && p2 < start2) {
                aux[p3] = arr[p1];
                p1--;
                continue;
            }
            if (p1 < start && p2 >= start2) {
                aux[p3] = arr[p2];
                p2--;
                continue;
            }
            if (arr[p1] > arr[p2]) {
                aux[p3] = arr[p1];
                p1--;

                //这里计算逆序数，其他的部分作归并排序代码
                count += p2 - start2 + 1;
            } else {
                aux[p3] = arr[p2];
                p2--;
            }
        }
        //合并之后复制到原来的数组
        p1 = start;
        for (int i = 0; i < length + 1; i++) {
            arr[p1] = aux[i];
            p1++;
        }

        return left + right + count;
    }
}
