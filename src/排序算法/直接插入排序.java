package 排序算法;

public class 直接插入排序 {

    /**
     * 直接插入排序
     * <p>
     * 是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用 in-place 排序，因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间
     * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     * 步骤1: 从第一个元素开始，该元素可以认为已经被排序；
     * 步骤2: 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 步骤3: 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 步骤4: 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 步骤5: 将新元素插入到该位置后；
     * 步骤6: 重复步骤2~5。
     * <p>
     * 时间复杂度O(N^2)
     * 空间复杂度O(1)
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int cur;     //存储当前要排序的元素
        for (int i = 0; i < array.length - 1; i++) {
            cur = array[i + 1];    //第一个数默认已经排好，直接从第二个数开始
            int pre = i;
            while (pre >= 0 && cur < array[pre]) {
                array[pre + 1] = array[pre];         //把大于当前数的元素后移
                pre--;
            }
            array[pre + 1] = cur;         //把这个数插入
        }
    }

    /**
     * 直接插入排序的优化
     * <p>
     * 优化一：折半插入排序（Binary Insertion Sort）是对插入排序算法的一种改进，所谓排序算法过程，
     * 就是不断的依次将元素插入前面已排好序的序列中，在寻找插入点时采用了折半查找。
     * <p>
     * 排序思想：有一组数据待排序，排序区间为Array[0]~Array[n-1]。将数据分为有序数据和无序数据，
     * 第一次排序时默认Array[0]为有序数据，Array[1]~Array[n-1]为无序数据。有序数据分区的第一个元素位置为low，
     * 最后一个元素的位置为high。
     * <p>
     * 遍历无序区间的所有元素，每次取无序区间的第一个元素Array[i+1]，因为0~i是有序排列的，
     * 所以用中点m将其平分为两部分，然后将待排序数据同中间位置为m的数据进行比较，若待排序数据较大，
     * 则low~m-1分区的数据都比待排序数据小，反之，若待排序数据较小，则m+1~high分区的数据都比 待排序数据大，
     * 此时将low或high重新定义为新的合适分区的边界，对新的小分区重复上面操作。
     * 直到low和high 的前后顺序改变，此时high+1所处位置为待排序数据的合适位置。
     *
     * @param array
     */
    public static void insertionSortPro(int[] array) {
        if (array.length < 2) {
            return;
        }

        int cur;            //存储当前要排序的元素
        int low, high;       //二分查找


        for (int i = 0; i < array.length - 1; i++) {

            cur = array[i + 1];
            low = 0;
            high = i;
            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (array[mid] > cur) {
                    high = mid - 1;
                } else {              //说明中间的数 <= cur
                    low = mid + 1;
                }
            }                               //二分查找完后，low索引对应插入位置，high索引对应插入位置-1
            for (int j = i; j >= low; j--) {
                array[j + 1] = array[j];
            }
            array[low] = cur;

        }
    }


}
