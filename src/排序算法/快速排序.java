package 排序算法;

import static 排序算法.直接插入排序.insertionSort;

public class 快速排序 {
    /**
     * 快速排序
     * <p>
     * 取一个记录作为枢轴，经过一趟排序将整段序列分为两个部分，使得数轴左侧都小于枢轴、右侧都大于枢轴；
     * 再对这两部分继续进行排序使整个序列达到有序
     * <p>
     * <p>
     * 1. 时间复杂度：O( nlogn ）
     * 2. 空间复杂度： O(logn)
     * 3. 稳定性：不稳定排序。因为关键字的比较和交换是跳跃进行的。
     *
     * @param array 待排序的数组
     * @param left  要排序的第一个元素的索引(包括)
     * @param right 最后一个要排序的元素的索引(不包括)
     */
    public static void quickSort(int[] array, int left, int right) {
        if (left < right - 1) {
            //获取中轴元素所处的索引
            int pivot = partition(array, left, right - 1);
            //进行分割
            quickSort(array, left, pivot);
            quickSort(array, pivot + 1, right);
        }
    }

    private static int partition(int[] array, int low, int high) {
        //选取中轴元素
        int pivotKey = array[low];     //首先选最左边的元素记为中轴元素
        while (low < high) {
            while (low < high && array[high] >= pivotKey)
                high--;
            swap(array, low, high);
            while (low < high && array[low] <= pivotKey)
                low++;
            swap(array, low, high);
        }
        return low;
    }

    private static void swap(int[] array, int a, int b) {
        if (a != b) {
            array[a] = array[a] ^ array[b];
            array[b] = array[a] ^ array[b];
            array[a] = array[a] ^ array[b];
        }
    }

    /**
     * 快速排序的优化
     * 1. 优化选取枢轴
     * 三数取中法——对待排序序列中low、mid、high三个位置上数据进行排序，取他们中间的那个数据作为枢轴，并用0下标元素存储枢轴。
     * 2. 优化不必要的交换
     * <p>
     * 3. 优化小数组时的排序方案
     * 对于很小和部分有序的数组，快排不如插排好。当待排序序列的长度分割到一定大小后，继续分割的效率比插入排序要差，
     * 此时可以使用插排而不是快排
     * <p>
     * 4. 优化递归过程
     * 采用尾递归法
     *
     * @param array 待排序的数组
     * @param left  要排序的第一个元素的索引(包括)
     * @param right 最后一个要排序的元素的索引(不包括)
     */
    public static final int MAX_LENGTH_INSERT_SORT = 7;    //数组长度阈值

    public static void quickSortPro(int[] array, int left, int right) {
        if ((right - left) > MAX_LENGTH_INSERT_SORT) {    //大于阈值采用快排

            while (left < right) {
                //获取中轴元素所处的索引
                int pivot = partitionPro(array, left, right - 1);
                //进行分割
                quickSort(array, left, pivot);
                left = pivot + 1;
                //递归一次后，low就失去左右，可以让 low = pivot+1，加上while循环相当于quickSort(array, pivot + 1, right);
            }
        } else {                                               //小于阈值采用插入排序
            insertionSort(array);
        }
    }

    private static int partitionPro(int[] array, int low, int high) {
        //优化1.三数取中法选取中轴元素
        int mid = low + (high - low) / 2;
        if (array[low] > array[high])
            swap(array, low, high);
        if (array[mid] > array[high])
            swap(array, mid, high);
        if (array[mid] > array[low])
            swap(array, low, mid);
        //优化2. 优化不必要的交换
        int pivotKey = array[low];     //首先选最左边的元素记为中轴元素
        while (low < high) {
            while (low < high && array[high] >= pivotKey)
                high--;
            array[low] = array[high];       //采用替换而不是交换的方式进行操作
            while (low < high && array[low] <= pivotKey)
                low++;
            array[high] = array[low];       //采用替换而不是交换的方式进行操作
        }
        array[low] = pivotKey;              //将枢轴数值替换回array[low]
        return low;                         //返回枢轴所在位置
    }

}
