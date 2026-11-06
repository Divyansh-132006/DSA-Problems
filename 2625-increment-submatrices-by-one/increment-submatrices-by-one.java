class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] prefix = new int[n][n];
        int m = queries.length;
        for (int k = 0; k < m; k++) {
            int l1 = queries[k][0];
            int r1 = queries[k][1];
            int l2 = queries[k][2];
            int r2 = queries[k][3];
            prefix[l1][r1]++;
            if (l2+1 < n && r2 + 1 < n)
                prefix[l2 + 1][r2 + 1]++;
            if (l2+1<n)
                prefix[l2 + 1][r1]--;

            if (r2+1<n)
                prefix[l1][r2 + 1]--;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i - 1 >= 0)
                    prefix[i][j] += prefix[i - 1][j];
                if (j >= 1)
                    prefix[i][j] += prefix[i][j - 1];
                if (i - 1 >= 0 && j - 1 >= 0)
                    prefix[i][j] -= prefix[i - 1][j - 1];
            }
        }
        return prefix;
    }
}