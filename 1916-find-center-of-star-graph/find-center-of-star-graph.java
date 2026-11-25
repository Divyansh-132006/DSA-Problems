class Solution {
    public int findCenter(int[][] edges) {

        if (edges.length == 0) {
            return 0;
        }

        Set set = new HashSet();
        set.add(edges[0][0]);
        set.add(edges[0][1]);

        for(int i=1; i<edges.length; i++) {
            for(int j=0; j<edges[i].length; j++) {
                if (set.contains(edges[i][j])) {
                    return edges[i][j];
                } 
            }
        }
        return edges[0][0];
    }

    void print(Object s) {
        System.out.println(s);
    }
}