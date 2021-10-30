package 排序算法.Kotlin

import java.util.*

/**
 * 冒泡排序：重复走访要排序的数列，一次比较两个元素，若较小元素在后则交换，能看到越小的元素会经由交换慢慢浮到数列的顶端
 *
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 稳定性：稳定排序
 */
fun bubbleSort(arrays: Array<Int>){
    val n = arrays.size
    if(n < 2){
        return
    }
    for(i in 0 until n-1){
        var flag = 0
        for(j in 0 until n-i-1){
            if(arrays[j] > arrays[j+1]){
                flag++
                val temp = arrays[j]
                arrays[j] = arrays[j+1]
                arrays[j+1] = temp
            }
        }
        if(flag == 0){
            break
        }
    }
}