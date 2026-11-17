class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n= g.length;
        int m =s.length;
        int gr = 0;
        int sl =0;
        while(sl<m && gr<n){
            if(g[gr] <= s[sl]){
                gr= gr+1;
            }
            sl = sl+1;
        }
        return gr;
    }
}