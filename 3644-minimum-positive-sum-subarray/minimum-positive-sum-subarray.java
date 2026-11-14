class Solution {
    int[][] dp;
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        dp = new int[n][r + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = l; j <= r; j++) {
                if (i + j <= n) {
                    int sum = fxn(nums, i, j);
                    if (sum > 0) {
                        ans = Math.min(ans, sum);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int fxn(List<Integer> nums, int i, int j) {
        if (j == 0) {
            return 0;
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        return dp[i][j] = nums.get(i) + fxn(nums, i + 1, j-1);
    }
}
