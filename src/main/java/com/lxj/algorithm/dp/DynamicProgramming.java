package com.lxj.algorithm.dp;

public class DynamicProgramming {
    //最大值递归
    public static int maxValue(int [] arr, int i){
        if(i == 0 ){
            return arr[0];
        }
        else if (i == 1){
            return Math.max(arr[0] ,arr[1]);
        }else {
            int a = maxValue(arr, i-2) + arr[i];
            int b = maxValue(arr, i - 1);
            return Math.max(a,b);
        }
    }
    //最大值dp
    public static int maxValue(int [] arr){
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length ; i++) {
            int a = opt[i-2] + arr[i];
            int b = opt[i-1];
            opt[i] = Math.max(a,b);
        }
        return opt[arr.length - 1];
    }

    //递归
    public static boolean recursionSubSet(int [] arr, int i, int sum){
        if (sum == 0){
            return true;
        }else if(i == 0){
            return arr[0] == sum;
        }else if( arr[i] > sum){
            // arr[i] = 12 12 >9 不选
            return recursionSubSet(arr, i-1,sum);
        }else{
            //选
            boolean a = recursionSubSet(arr, i -1, sum - arr[i]);
            //不选
            boolean b = recursionSubSet(arr, i -1, sum);
            //a或者b有一种成功就return true
            return a || b;
        }
    }

    //dp
    public static boolean dpSubset(int [] arr, int sum){
        boolean[][] subset = new boolean[arr.length][sum + 1];
        for (int i = 0; i < sum; i++) {
            subset[0][i] = false;
            if (i == 3){
                subset[0][i] = true;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            subset[i][0] = true;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int s = 1; s < sum+1; s++) {
                if (arr[i] > sum){
                    subset[i][s] = subset[i-1][s];
                }else {
                    boolean a = subset[i - 1][s - arr[i]];
                    boolean b = subset[i - 1][s];
                    subset[i][s] = a || b;
                }
            }
        }
        return subset[arr.length][sum];
    }

    public static void main(String[] args) {
        int [] arr ={1,2,4,1,7,8,3};
        System.out.println(maxValue(arr));
        int [] arr1 ={3, 34, 4, 12, 5, 2};
        System.out.println(recursionSubSet(arr1, arr1.length-1,9));
        dpSubset(arr, 9);
    }
}
