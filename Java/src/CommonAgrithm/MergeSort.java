package CommonAgrithm;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/11
 *     标题   : 归并排序
 * </pre>
 */
class MergeSort {

    public static void main(String[] args) {

        int[] arr = {14, 12, 15, 13, 11, 16, 9};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {

        if (start == end) {
            return;
        }

        int length = end - start;
        int middle = start + length / 2;
        int start2 = middle + 1;

        //对前半段进行归并排序
        mergeSort(arr, start, middle);
        //对后半段半段进行归并排序
        mergeSort(arr, start2, end);

        //对排好序的两段进行合并
        int[] aux = new int[length + 1];
        int p1 = start;
        int p2 = start2;
        int p3 = -1;
        while (p1 <= middle || p2 <= end) {
            p3++;
            if (p1 <= middle && p2 > end) {
                aux[p3] = arr[p1];
                p1++;
                continue;
            }
            if (p1 > middle && p2 <= end) {
                aux[p3] = arr[p2];
                p2++;
                continue;
            }
            if (arr[p1] <= arr[p2]) {
                aux[p3] = arr[p1];
                p1++;
            } else {
                aux[p3] = arr[p2];
                p2++;
            }
        }
        //合并之后复制到原来的数组
        p1 = start;
        for (int i = 0; i < length + 1; i++) {
            arr[p1] = aux[i];
            p1++;
        }
    }
}
