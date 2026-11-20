// class Solution {
//     boolean fxn(HashMap<Character, Integer> hash, String p){
//         HashMap<Character, Integer> map = new HashMap<>();
//         for(int i = 0; i < p.length(); i++){
//             map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
//         }
//         return hash.equals(map);
//     }
//     public List<Integer> findAnagrams(String s, String p) {
//         int n = s.length();
//         int k = p.length();
//         int i=0, j=0;
//         ArrayList<Integer> res = new ArrayList<>();
//         HashMap<Character, Integer> hash = new HashMap<>();
//         while(j<n){
//             hash.put(s.charAt(j), hash.getOrDefault(s.charAt(j), 0) + 1);
//             if(j-i+1<k) j++;
//             else if(j-i+1==k){
//                 if(fxn(hash, p)){
//                     res.add(i);
//                 }
//                 hash.put(s.charAt(i), hash.get(s.charAt(i)) - 1);
//                 if(hash.get(s.charAt(i)) == 0){
//                     hash.remove(s.charAt(i));
//                 }
//                 i++;
//                 j++;
//             }
//         }
//         return res;
//     }
// }

class Solution {

    public boolean fxn(HashMap<Character, Integer> hash) {
        for (int val : hash.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();
        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int z = 0; z <k; z++) {
            hash.put(p.charAt(z), hash.getOrDefault(p.charAt(z), 0) + 1);
        }
        while (j < n) {
            if (!hash.containsKey(s.charAt(j))) {
                hash.clear();
                for (int z = 0; z < k; z++) {
                    hash.put(p.charAt(z), hash.getOrDefault(p.charAt(z), 0) + 1);
                }
                i = j+1;
                j++;
                continue;
            }
            hash.put(s.charAt(j), hash.get(s.charAt(j)) - 1);
            if (j-i+1<k) j++;
            else if (j-i+1==k) {
                if (fxn(hash)) {
                    res.add(i);
                }
                hash.put(s.charAt(i), hash.get(s.charAt(i)) + 1);
                i++;
                j++;
            }
        }
        return res;
    }
}


