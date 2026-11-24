class Solution {
    private long fxngcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int maxLength(int[] nums) {
        int n = nums.length;
        int answer = 0;
        int i = 0;
        while (i<n) {
            long prod = 1;
            long gcd = 0;
            long lcm = 1;
            int j = i;
            while (j < n) {
                prod *= nums[j];
                gcd = fxngcd(gcd, nums[j]);
                lcm = (lcm / fxngcd(lcm, nums[j])) * nums[j];
                if (prod==gcd*lcm) {
                    answer= Math.max(answer, j - i + 1);
                }
                j++;
            }
            i++;
        }
        return answer;
    }
}
