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
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();
        int i=0, j=0;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> hash = new HashMap<>();
        for(int x=0; x<k; x++){
            hash.put(p.charAt(x), hash.getOrDefault(p.charAt(x), 0)+1);
        }
        int count = k;
        while(j<n){
            if(!hash.containsKey(s.charAt(j))){
                hash.clear();
                for(int x=0; x<k; x++){
                    hash.put(p.charAt(x), hash.getOrDefault(p.charAt(x), 0)+1);
                }
                count = k;
                i = j+1;
                j++;
                continue;
            }
            if(hash.get(s.charAt(j)) > 0){
                count--;
            }
            hash.put(s.charAt(j), hash.get(s.charAt(j))-1);
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                if(count == 0){
                    res.add(i);
                }
                if(hash.get(s.charAt(i)) >= 0){
                    count++;
                }
                hash.put(s.charAt(i), hash.get(s.charAt(i))+1);
                i++;
                j++;
            }
        }

        return res;
    }
}