public class Solution {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        // write your code here
        int[] map = new int[256];
        char[] src = s.toCharArray();
        char[] dst = t.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(map[src[i]] == 0){
                map[src[i]] = dst[i];
            }else{
                if(map[src[i]] != dst[i]){
                    return false;
                }
            }
        }
        
        int[] map2 = new int[256];
        for(int i = 0; i < t.length(); i++){
            if(map2[dst[i]] == 0){
                map2[dst[i]] = src[i];
            }else{
                if(map2[dst[i]] != src[i]){
                    return false;
                }
            }
        }
        return true;
    }
}