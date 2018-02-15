public class Solution {
    /**
     * @param n: Given a decimal number that is passed in as a string
     * @return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        if(n.length() == 0){
            return "ERROR";
        }
        int dot_idx = n.lastIndexOf(".");
        String int_dec = n.substring(0, dot_idx);
        String frac_dec = n.substring(dot_idx, n.length());
        int int_n = Integer.parseInt(int_dec);
        String frac_bin = fraction2Bin(frac_dec);
        if(frac_bin.equals("ERROR")){
            return frac_bin;
        }else if(frac_bin.equals(".")){
            return int2Bin(int_n);
        }
        return int2Bin(int_n) + frac_bin;
        
    }
    
    String int2Bin(int n){
        StringBuilder sb = new StringBuilder();
        if(n == 0){
            return "0";
        }
        while(n > 0){
            int remainder = n % 2;
            sb.append(remainder);
            n /= 2;
        }
        return sb.reverse().toString();
    }
    
    String fraction2Bin(String frac){
        double n = Double.parseDouble(frac);
        StringBuilder sb = new StringBuilder(".");
        int i = 0;
        while(i < 33 && n != 0){
            n *= 2;
            if(n >= 1){
                sb.append("1");
                n -= 1;
            }else{
                sb.append("0");
            }
            i++;
        }
        if(i == 33){
            return "ERROR";
        }else{
            return sb.toString();
        }
    }
}