package Java虚拟机;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(fun(n,m,k,nums));
    }

    private static int fun(int n,int m,int k,int[] nums) {
        int res = 0;
        int[][] dp = new int[n][2];
        dp[0][0] = m - nums[0];
        dp[0][1] = m;
        res = 1;
        for(int i = 1;i < n;i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]) - nums[i];
            if(i <= k){
                int num = 0;
                for(int j = 0;j < i;j++){
                    num += nums[j];
                }
                dp[i][1] = m - num;
            }else{
                int num = 0;
                for(int j = 1;j <= k;j++){
                    num += nums[i - j];
                }
                dp[i][1] = dp[i - k - 1][1] - num;
            }
            if(dp[i][0] > 0 || dp[i][1] > 0){
                res = Math.max(i + 1,res);
            }
        }
        return res;
    }
}
