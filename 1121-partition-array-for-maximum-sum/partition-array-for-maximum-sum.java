class Solution {
    int fxn(int i, int j, int k, int arr[], int[][] dp) {
        if (i>j) return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = 0;
        int maxsum = 0;
        for (int p=i; p<=j && p<i+k; p++) {
            maxsum = Math.max(maxsum, arr[p]);
            int l =p-i+1;
            int cost =fxn(p + 1, j, k, arr, dp)+(maxsum*l);
            ans = Math.max(ans, cost);
        }
        return dp[i][j] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fxn(0, n - 1, k, arr, dp);
    }
}
