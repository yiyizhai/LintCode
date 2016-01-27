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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
	//Divide and Conquer: left && right
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }else if(root.left == null && root.right == null){
            return true;
        }else if(root.left == null && root.right != null){
            if(root.right.left == null && root.right.right == null){
                return true;
            }else{
                return false;
            }
        }else if(root.left != null && root.right == null){
            if(root.left.left == null && root.left.right == null){
                return true;
            }else{
                return false;
            }
        }else{
            boolean left = isBalanced(root.left);
            boolean right = isBalanced(root.right);
            return (left && right);
        }
    }

}