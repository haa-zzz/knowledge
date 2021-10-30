package 排序算法;

import java.util.ArrayList;
import java.util.LinkedList;

public class 基数排序 {
    /**
     * 基数排序
     *
     * 按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，
     * 先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
     * 基数排序基于分别排序，分别收集，所以是稳定的。
     *
     * @param array
     */
    public static void RadioSort(int[] array) {
        int n = array.length;
        if(n < 2){
            return;
        }
        int max = array[0];
        for(int i = 1; i < n; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        // 计算最大值是几位数
        int num = 1;
        while (max / 10 > 0) {
            num++;
            max = max / 10;
        }
        // 创建10个桶
        ArrayList< LinkedList<Integer> > bucketList = new ArrayList<>(10);
        //初始化桶
        for (int i = 0; i < 10; i++) {
            bucketList.add(new LinkedList<Integer>());
        }
        // 进行每一趟的排序，从个位数开始排
        for(int i = 1; i <= num; i++){
            for(int j = 0; j < n; j++){
                // 获取每个数最后第 i 位
                int radio = (array[j] / (int)Math.pow(10,i-1)) % 10;
                //放进对应的桶里
                bucketList.get(radio).add(array[j]);
            }
            //合并放回原数组
            int k = 0;
            for(int j = 0; j < 10; j++){
                for(Integer t : bucketList.get(j)){
                    array[k++] = t;
                }
                bucketList.get(j).clear();
            }
        }
    }
}
