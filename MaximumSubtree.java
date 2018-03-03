public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    TreeNode ans;
    int max_sum;
    public TreeNode findSubtree(TreeNode root) {
        ans = null;
        max_sum = Integer.MIN_VALUE;
        sumTree(root);
        return ans;
    }
    int sumTree(TreeNode curr){
        if(curr == null){
            return 0;
        }
        int leftSum = sumTree(curr.left);
        int rightSum = sumTree(curr.right);
        int sumCurr = curr.val + leftSum + rightSum;
        if(max_sum < sumCurr){
            max_sum = sumCurr;
            ans = curr;
        }
        return sumCurr;
    }
}