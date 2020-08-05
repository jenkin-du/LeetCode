package CommonAgrithm;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/07/29
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class Heapsort {

    public static void main(String[] args) {

        int[] arr = {14, 12, 15, 13, 11, 16, 9};
        //堆排序
        headSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }

    }

    public static void headSort(int[] arr) {
        //先构建堆
        buildMaxHeap(arr);

        //交换并调整
        int len = arr.length;
        for (int i = arr.length - 1; i >= 1; i--) {
            swap(arr, 0, i);
            len--;
            adjustHeap(arr, 0, len);
        }
    }

    //构建最大堆
    public static void buildMaxHeap(int[] arr) {

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }

    //调整
    private static void adjustHeap(int[] arr, int i, int length) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largestIndex = i;

        if (left < length && arr[left] > arr[largestIndex]) {
            largestIndex = left;
        }
        if (right < length && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }

        if (largestIndex != i) {
            swap(arr, i, largestIndex);
            adjustHeap(arr, largestIndex, length);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
