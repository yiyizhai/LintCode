/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class ResultType {
    boolean is_bst;
    int maxValue, minValue;
    
    ResultType(boolean is_bst, int maxValue, int minValue) {
        this.is_bst = is_bst;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        ResultType r = validateHelper(root);
        return r.is_bst;
    }
    
    private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);
        
        if (!left.is_bst || !right.is_bst) {
            // if is_bst is false then minValue and maxValue are useless
            return new ResultType(false, 0, 0);
        }
        
        if (root.left != null && left.maxValue >= root.val || 
              root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }
        
        return new ResultType(true,
                              Math.max(root.val, right.maxValue),
                              Math.min(root.val, left.minValue));
    }
}
/*public class Solution {
  
    class ResultType{
        TreeNode node;
        int maxVal;
        int minVal;
        ResultType(TreeNode n, int max, int min){
            node = n;
            maxVal = max;
            minVal = min;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // write your code here
       
        ResultType rt = new ResultType(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        return maxmin(rt);
    }
    
    private boolean maxmin(ResultType rt){
        boolean flag = true;
        if(rt.node == null){
            return true;
        }
        if(rt.node.left == null && rt.node.right == null){
            rt.maxVal = rt.node.val;
            rt.minVal = rt.node.val;
            return true;
        }
        ResultType left = new ResultType(rt.node.left, Integer.MIN_VALUE, Integer.MAX_VALUE);
        ResultType right = new ResultType(rt.node.right, Integer.MIN_VALUE, Integer.MAX_VALUE);
        flag = flag && maxmin(left) && maxmin(right);
        rt.maxVal = Math.max(rt.node.val, Math.max(right.maxVal,left.maxVal));
        rt.minVal = Math.min(rt.node.val, Math.min(right.minVal,left.minVal));
        
        if(rt.node.val <= left.minVal || rt.node.val >= right.maxVal){
            flag = false;
        }
        return flag;
        
    }
    
}*/