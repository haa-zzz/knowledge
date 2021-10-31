package 排序算法;

import java.util.Arrays;
import java.util.Scanner;

import static 排序算法.冒泡排序.bubbleSort;
import static 排序算法.基数排序.RadioSort;
import static 排序算法.归并排序.MergeSort;
import static 排序算法.快速排序.quickSort;
import static 排序算法.快速排序.quickSortPro;


public class demo {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        //bubbleSort(arr);
        //quickSortPro(arr,0,n);
        RadioSort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "  ");
        }
    }


}
