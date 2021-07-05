public class oneJuly{
   class TreeNode{
       int val;
       TreeNode left;
       TreeNode right;
   }
    //124

    public class getMaxSum{
        int maxSum=-(int)1e9;
        boolean isPartOfPath=false;
    }
    public int maxPathSum(TreeNode root) {
        getMaxSum obj= maxPathSum_1(root);
        
        return obj.maxSum;
    }

    public getMaxSum  maxPathSum_1(TreeNode root){
        if(root==null) return new getMaxSum();

        getMaxSum myAns
        myAns.maxSum=root.val;
        getMaxSum left=maxPathSum_1(root.left);
        getMaxSum right = maxPathSum_1(root.right);
        if(left.maxSum+root.val<root.val&&right.maxSum+root.val<root.val){
            myAns.maxSum=root.val;
            myAns.isPartOfPath=true;
        }
        else if(left.maxSum+root.val)

        
        return myAns;
    }
}