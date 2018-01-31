public class Solution {
    /*
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        // write your code here
        int[] map = new int[256];
        map['0'] = '0';
        map['1'] = '1';
        map['6'] = '9';
        map['8'] = '8';
        map['9'] = '6';
        int len = num.length();
        for(int i = 0; i < len; i++){
            int j = len - 1 - i;
            if(map[num.charAt(i)] != num.charAt(j)){
                return false;
            }
        }
        return true;
    }
}