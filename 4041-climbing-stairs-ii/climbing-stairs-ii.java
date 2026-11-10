class Solution {
    int fxn(int i, int n, int[] costs, int[] dp){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int onestep = Integer.MAX_VALUE;
        int twostep = Integer.MAX_VALUE;
        int threestep = Integer.MAX_VALUE;
        if(i+1 <= n){
            onestep = fxn(i+1, n, costs, dp) + costs[i] + 1*1;
        }
        if(i+2 <= n){
            twostep = fxn(i+2, n, costs, dp) + costs[i+1] + 2*2;
        }
        if(i+3 <= n){
            threestep = fxn(i+3, n, costs, dp) + costs[i+2] + 3*3;
        }
        return dp[i] = Math.min(onestep, Math.min(twostep, threestep));
    }
    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return fxn(0, n, costs, dp);
    }
}
