/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer>map=new HashMap<>();
      int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    
      for(int i=0;i<inorder.length;i++){
        map.put(inorder[i],i);
      } 
      return solve(preorder,0,inorder.length-1);
    }
    public TreeNode solve(int[] preorder,int left,int right){
        if(left>right){
            return null;
        }
        int rootVal=preorder[preIndex++];

        TreeNode root=new TreeNode(rootVal);
        int mid=map.get(rootVal);
        root.left=solve(preorder,left,mid-1);
        root.right=solve(preorder,mid+1,right);

        return root;
    }
}