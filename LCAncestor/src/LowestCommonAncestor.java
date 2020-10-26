//Test Branching 22222
//LCA = Lowest Common Ancestor. Presume not allowed to use BST, but would be quicker if was allowed to use that data structure.
class TreeNode{
	int data;
	TreeNode left, right;
	
	TreeNode(int data){
		this.data = data;
		this.left = this.right = null;
	}
}

public class LowestCommonAncestor {

	TreeNode root;
	
	//Say if b is higher up, and on the same side of the tree, than a, b will be LCA
	public TreeNode LCA( TreeNode root, TreeNode a, TreeNode b) {
		if( root == null) {
			return null;
		}
		if( root == a || root ==b) {   
			return root; 
		}
		
		TreeNode left = LCA(root.left, a, b);
		TreeNode right = LCA(root.right, a, b);
		
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowestCommonAncestor myTree = new LowestCommonAncestor(); //myTee constructed & shown below in comments
		myTree.root = new TreeNode(1);                         //1
		myTree.root.left = new TreeNode(2);                  //2   3
        myTree.root.right = new TreeNode(3);               //4  5  6 7
        myTree.root.left.left = new TreeNode(4);    
        myTree.root.left.right = new TreeNode(5); 
        myTree.root.right.left = new TreeNode(6); 
        myTree.root.right.right = new TreeNode(7); 
        
        System.out.println("LCA(4, 5): " + myTree.LCA(myTree.root, myTree.root.left.left,myTree.root.left.right).data); 
        System.out.println("LCA(4, 6): " + myTree.LCA(myTree.root, myTree.root.left.left,myTree.root.right.left).data); 
        System.out.println("LCA(3, 4): " + myTree.LCA(myTree.root, myTree.root.right, myTree.root.left.left).data); 
        System.out.println("LCA(2, 4): " + myTree.LCA(myTree.root, myTree.root.left, myTree.root.left.left).data); 
        System.out.println("LCA(1, 4): " +  myTree.LCA(myTree.root, myTree.root, myTree.root.left.left).data);
	}

}
