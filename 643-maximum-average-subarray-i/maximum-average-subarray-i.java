class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0, j = 0;
        double res = Double.NEGATIVE_INFINITY;
        int s = 0;
        int n = nums.length;
        while (j < n) {
            s += nums[j];
            if (j-i+1<k) {
                j++;
            } 
            else if (j-i+1==k) {
                double avg = (double) s/k;
                res = Math.max(res, avg);
                s -= nums[i];
                i++;
                j++;
            }
        }
        return res;
    }
}
