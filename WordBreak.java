public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        int maxLen = 0;
        for(String str : dict){
            if(maxLen < str.length()){
                maxLen = str.length();
            }
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= i && j <= maxLen ; j++){
                if(dp[i-j] && dict.contains(s.substring(i-j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}