class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int max = 0;
        HashSet<Character> hash = new HashSet<>();
        while (j < s.length()) {
            if (!hash.contains(s.charAt(j))) {
                hash.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
                j++;
            } 
            else {
                hash.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
