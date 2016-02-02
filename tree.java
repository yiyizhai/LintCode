public boolean isSuperBalanced(TreeNode root){
	if(root == null){
		return true;
	}
    int maxDepth = getMaxDepth(root);
    int minDepth = getMinDepth(root);

    return (maxDepth - minDepth) <= 1; 
}

public int getMinDepth(TreeNode root){
	if(root == null){
		return 0;
	}
	int depthleft = 0;
	int depthright = 0; 

	depthleft = getDepth(root.left) + 1;	
	depthright = getDepth(root.right) + 1;

	return Math.min(depthleft, depthright);	
}

public int getMaxDepth(TreeNode root){
	if(root == null){
		return 0;
	}
	int depthleft = 0;
	int depthright = 0; 

	depthleft = getDepth(root.left) + 1;	
	depthright = getDepth(root.right) + 1;

	return Math.max(depthleft, depthright);
}