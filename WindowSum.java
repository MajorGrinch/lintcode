import java.util.Arrays;

class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        int win_size = nums.length - k + 1;
        int[] ans = new int[win_size];
        for(int i = 0; i < k; i++){
            ans[0] += nums[i];
        }
        for(int i = k; i < nums.length; i++){
            ans[i-k+1] = ans[i-k] + nums[i] - nums[i-k];
        }
        return ans;
    }
    public int[] winSum2(int[] nums, int k){
        int win_size = nums.length - k + 1;
        int[] ans = new int[win_size];
        int[] sum = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        for(int i = 0; i < ans.length; i++){
            ans[i] = sum[i+k] - sum[i];
        }
        return ans;
    }
}

public class WindowSum{
    public static void main(String[] args) {
        int[] input = {1,2,7,7,2};
        int[] output = new Solution().winSum2(input, 3);
        System.out.println(Arrays.toString(output));
    }
}