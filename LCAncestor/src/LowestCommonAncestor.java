import java.util.ArrayList;

//Test Branching
//LCA = Lowest Common Ancestor. Presume not allowed to use BST, but would be quicker if was allowed to use that data structure.
class DAGTreeNode{
	int data;
	ArrayList<DAGTreeNode> successors;

	DAGTreeNode(int data){
		this.data = data;
		successors = new ArrayList<DAGTreeNode>();
	}
}

class BinaryTreeNode{
	int data;
	BinaryTreeNode right, left;
	
	BinaryTreeNode(int data){
		this.data = data;
		this.right = this.left = null;
	}
}

public class LowestCommonAncestor {
	public class BinaryTree{
		BinaryTreeNode root;
		
		//Say if b is higher up, and on the same side of the tree, than a, b will be LCA
		public BinaryTreeNode LCA( BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
			if( root == null) {
				return null;
			}
			if( root == a || root ==b) {   
				return root; 
			}
			
			BinaryTreeNode left = LCA(root.left, a, b);
			BinaryTreeNode right = LCA(root.right, a, b);
			
			
			//If left && right are not null, this 'root' is LCA for a and b
			if( left!=null && right!=null) {
				return root;
			}
			if(left == null) {
				return right;
			}
			else {
				return left;
			}
		}
	}
	
	public class DAGTree{
		DAGTreeNode root;
	}
}


