import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {
        int[] temp=new int[]{2,5,8,7,6,3,9,7};
        ArrayList hh=headSort(temp,4);
        System.out.println(hh.toString());
    }
    public static ArrayList<Integer> headSort(int[] array,int k) {
        ArrayList<Integer> res=new ArrayList<>();
        int sum=0;
        int n = array.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, n - 1);
        }
        for (int i = n - 1; i >= 1; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            if(sum!=k) {
                res.add(array[i]);
                sum++;
            }
            if(sum==k) return res;
            downAdjust(array, 0, i - 1);
        }
        return res;
    }

    public static void downAdjust(int[] arr, int parent, int n) {
        int temp = arr[parent];
        int child = 2 * parent + 1;
        while (child <= n) {
            if(child + 1 <= n && arr[child] < arr[child + 1])
                child++;
            if (arr[child] <= temp ) break;
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }
}
