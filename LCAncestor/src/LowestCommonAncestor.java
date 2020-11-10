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
	
	public boolean foundA;
	public boolean foundB;
	public boolean AandBSubtree;
	
	public class BinaryTree{
		BinaryTreeNode root; //****Might set this to null
		
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
	
	//Might be better to include DAGTreeNode class in the below class
	public class DAGTree{
		DAGTreeNode root = null; //////
		
		public void addNode(ArrayList<DAGTreeNode> parentsOfNode, int key) {
			DAGTreeNode node = new DAGTreeNode(key);
			if(root == null) {
				root = node;
			}
			if(	parentsOfNode != null) { // If null does not necessarily mean its the root of the tree/graph (I think)
				for(DAGTreeNode parent : parentsOfNode) {
					if(parent != null) { //Might not need this check, or maybe if it is null could create the parent node
						parent.successors.add(node);
					}
				}
			}
		}
		
		public ArrayList<DAGTreeNode> getSuccessors(DAGTreeNode node){
			if(node != null) {
				return node.successors;
			}
			return null;
		}
		
		//Might be better to return the key and take in the keys as parameters rather than nodes.
		//Will have to use a supplemental recursive function
		//Note: a or b can be the LCA of the pair 
		public DAGTreeNode DAGLCA(DAGTree myTree, DAGTreeNode a, DAGTreeNode b) {
			DAGTreeNode headMyTree = myTree.root;
			foundA = false;
			foundB = false;
			AandBSubtree = false;
			//If any parameters are null, null is returned
			if( myTree == null || a == null || b == null) {
				return null;
			}
			//If any of the nodes are the head/root, returns the root
			if( headMyTree.data == a.data || headMyTree.data == a.data) {
				return headMyTree;
			}
			//If the nodes are the same, returns a
			if( a.data == b.data) {
				return a;
			}
			return inSubtree(headMyTree, a, b);
		}
		
		//If a LCA cannot be found null is returned
		public DAGTreeNode inSubtree(DAGTreeNode node, DAGTreeNode a, DAGTreeNode b) {
			for(int i = 0; i < node.successors.size(); i++) {
				DAGTreeNode subtree = inSubtree(node.successors.get(i), a, b);
				
				if( foundA && foundB) {
					if( !AandBSubtree) {
						AandBSubtree = true;
						return node;
					}
					else {
						return subtree;
					}
				}
			}
			/*
			if(( foundA && (foundB || node.data == b.data)) || ( foundB && node.data == a.data)) {
				return node;
			}
			*/
			if( node.data == a.data) {
				foundA = true;
				return node;
			}
			
			if( node.data == b.data) {
				foundB = true;
				return node;
			}
			return null;
		}
		
		
		
	}
}


