package 排序算法;

public class 归并排序 {

    /**
     *归并排序
     *
     *
     * 将一个大的无序数组有序，我们可以把大的数组分成两个，然后对这两个数组分别进行排序，
     * 之后在把这两个数组合并成一个有序的数组。由于两个小的数组都是有序的，所以在合并的时候是很快的。
     *
     *  - 时间复杂度：O(nlog(n)）
     *  - 空间复杂度： O(n)
     *  - 稳定性：稳定排序。
     *
     * @param array     待排序的数组
     * @param left      要排序的第一个元素的索引(包括)
     * @param right     最后一个要排序的元素的索引(不包括)
     */
    public static void MergeSort(int[] array,int left,int right) {
        //如果 left==right-1,表示数组只有一个元素，则不用递归排序
        if( left < (right-1) ){
            //分割数组
            int mid = left + (right-left+1)/2;
            //对左半部分进行排序
            MergeSort(array,left,mid);
            //对右半部分进行排序
            MergeSort(array,mid,right);
            //进行合并
            merge(array,left,mid,right);
        }
    }
    private static void merge(int[] array, int left, int mid, int right) {
        //先用一个临时数组把他们合并汇总起来
        int[] a = new int[right - left];
        int i = left;
        int j = mid ;
        int k = 0;
        while (i < mid && j < right) {

            if (array[i] < array[j]) {
                a[k++] = array[i++];
            } else {
                a[k++] = array[j++];
            }

        }
        while(i < mid) a[k++] = array[i++];
        while(j < right) a[k++] = array[j++];
        // 把临时数组复制到原数组
        for (i = 0; i < k; i++) {
            array[left++] = a[i];
        }
    }
}
