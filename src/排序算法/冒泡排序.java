package 排序算法;

public class 冒泡排序 {
    /**
     * 冒泡排序
     * 重复走访要排序的数列，一次比较两个元素，若较小元素在后则交换，能看到越小的元素会经由交换慢慢浮到数列的顶端
     * <p>
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * 稳定性：稳定排序
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        if (n < 2) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
        }
    }

    /**
     * 冒泡排序优化
     * 假如从开始的第一对到结尾的最后一对，相邻的元素之间都没有发生交换的操作，这意味着右边的元素总是大于等于左边的元素，
     * 此时的数组已经是有序的了，我们无需再对剩余的元素重复比较下去了。
     */
    public static void bubbleSortPro(int[] array) {
        int n = array.length;
        if (n < 2) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            boolean boo = true;         //增加标志位来判断是否有交换数
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    boo = false;
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
            if (boo) {
                break;
            }
        }
    }

}
