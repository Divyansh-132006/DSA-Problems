class Solution {
    int n;
    int fxn(int [] nums,int i, int j, int [][]dp){
        if(i > j) return 0;
        if(dp[i][j]!= -1) return dp[i][j]; 
        int max = Integer.MIN_VALUE;
        for(int k = i; k<=j;k++){
            int cost = fxn(nums,i, k-1, dp)+fxn(nums,k+1, j, dp) + nums[i-1]*nums[k]*nums[j+1];
            max = Math.max(max, cost);
        }
        return dp[i][j]=max;
    }
    public int maxCoins(int[] nums) {
         n = nums.length;
        int dp[][] = new int[n+2][n+2];
      int[] result = new int[nums.length + 2];
       result[0] = 1; 
       result[result.length - 1] = 1; 
       System.arraycopy(nums, 0, result, 1, nums.length);
        for(int i =0;i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }
        return fxn(result, 1, n, dp);
    }
}