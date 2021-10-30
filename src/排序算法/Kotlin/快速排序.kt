package 排序算法.Kotlin

import 排序算法.直接插入排序


/**
 * 快速排序
 * <p>
 * 取一个记录作为枢轴，经过一趟排序将整段序列分为两个部分，使得数轴左侧都小于枢轴、右侧都大于枢轴；
 * 再对这两部分继续进行排序使整个序列达到有序
 *
 *
 *  1. 时间复杂度：O( nlogn ）
 *  2. 空间复杂度： O(logn)
 *  3. 稳定性：不稳定排序。因为关键字的比较和交换是跳跃进行的。
 *
 * @param array 待排序的数组
 * @param left  要排序的第一个元素的索引(包括)
 * @param right 最后一个要排序的元素的索引(不包括)
 */
fun quickSort(array : Array<Int>, left : Int, right : Int){
    if(left < right-1){     //当 left == right-1时，只有一个元素，默认排好序了
        //先排一个，获取中轴元素所在的索引
        val pivot = partition(array,left,right-1)
        //递归的排左右两边
        quickSort(array , left , pivot)
        quickSort(array ,pivot + 1 , right)
    }
}
fun partition(array: Array<Int>, low : Int, high: Int): Int{
    //选取最左边作为中轴元素
    val pivotKey = array[low]
    var low = low
    var high = high
    while(low < high ){
        while(low < high && pivotKey <= array[high] )   high--
        swap(array,low,high)
        while(low < high && pivotKey >= array[low] )    low++
        swap(array,low,high)
    }
    return low
}
/*
    优化：
    1.优化选取轴 - 三数取中法
    2.优化不必要的交换。交换可以用替换代替
    3.优化小数组的排序，对于很小和部分有序的数组，快排不然插排好
    4.优化递归过程：采用尾递归优化递归过
 */
val MAX_LENGTH_INSERT_SORT: Int = 7 //数组长度阈值

fun quickSortPro(array: Array<Int>, left: Int, right: Int) {

    var left = left

    if (right - left > MAX_LENGTH_INSERT_SORT) {    //大于阈值采用快排
        while (left < right) {
            //获取中轴元素所处的索引
            val pivot = partitionPro(array, left, right - 1)
            //进行分割
            quickSortPro(array, left, pivot)
            left = pivot + 1
            //递归一次后，low就失去左右，可以让 low = pivot+1，加上while循环相当于quickSort(array, pivot + 1, right);
        }
    } else {                                               //小于阈值采用插入排序
       // 直接插入排序.insertionSort(array)
    }
}

private fun partitionPro(array: Array<Int>, low: Int, high: Int): Int {
    var low = low
    var high = high
    val mid = low + (high - low) / 2

    if (array[low] > array[high]) swap(array, low, high)
    if (array[mid] > array[high]) swap(array, mid, high)
    if (array[mid] > array[low]) swap(array, low, mid)

    val pivotKey = array[low] //首先选最左边的元素记为中轴元素

    while (low < high) {
        while (low < high && array[high] >= pivotKey) high--
        array[low] = array[high] //采用替换而不是交换的方式进行操作
        while (low < high && array[low] <= pivotKey) low++
        array[high] = array[low] //采用替换而不是交换的方式进行操作
    }
    array[low] = pivotKey //将枢轴数值替换回array[low]
    return low //返回枢轴所在位置
}


fun swap(array: Array<Int>, low: Int, high: Int) {
    val temp = array[low];
    array[low] = array[high];
    array[high] = temp;
}

