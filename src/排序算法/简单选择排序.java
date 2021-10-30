package 排序算法;

import java.util.Arrays;



public class 简单选择排序 {

    /**
     * 简单选择排序
     *
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     *  - 时间复杂度： O（N^2）
     *  - 空间复杂度： O(1)
     *  - 稳定性：不稳定排序
     * @param array  待排序的数组
     */
    public static void selectionSort(int[] array) {
        int n = array.length;
        if(n < 2){
            return;
        }
        for(int i = 0; i < n-1; i++){
            int minIndex = i;           //记录最小的下表位置
            for(int j = i+1; j < n; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if(array[i] != array[minIndex]){        //如果他俩相等，异或运算后两者都变为0
                array[i]  = array[i] ^ array[minIndex];     //交换两个数
                array[minIndex] = array[i] ^ array[minIndex];
                array[i] = array[i] ^ array[minIndex];
            }
        }
    }

    /**
     * 简单选择排序的优化
     * 在每一次查找最小值的时候，也可以找到一个最大值，然后将两者分别放在它们应该出现的位置，减少遍历次数
     *
     * @param array
     */
    public static void selectionSortPro(int[] array) {
        int n = array.length;
        if(n < 2){
            return;
        }
        int left = 0;
        int right = n-1;

        while(left < right){
            int minIndex = left;
            int maxIndex = right;

            for(int i = left; i <= right; i++){
                if(array[minIndex] >  array[i]){
                    minIndex = i;
                }
                if(array[maxIndex] < array[i]){
                    maxIndex = i;
                }
            }

            if(minIndex != left){
                array[left]  = array[left] ^ array[minIndex];     //交换两个数
                array[minIndex] = array[left] ^ array[minIndex];
                array[left] = array[left] ^ array[minIndex];
            }

            if(left == maxIndex)            //如果left索引位置为最大值，由于left和minIndex交换了，所以 maxIndex = minIndex;
                maxIndex = minIndex;        //还有一种情况，minIndex索引位置为最大值，说明最小值和最大值的索引相同，
                                            // 即只剩最后一个元素了，此时可以不做处理
            if(maxIndex != right){
                array[right]  = array[right] ^ array[maxIndex];     //交换两个数
                array[maxIndex] = array[right] ^ array[maxIndex];
                array[right] = array[right] ^ array[maxIndex];
            }
            left++;
            right--;

        }

    }



}
