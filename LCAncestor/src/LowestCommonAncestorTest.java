import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {

	@Test
	void testTree() {
		LowestCommonAncestor myLCAClass = new LowestCommonAncestor();
		LowestCommonAncestor.BinaryTree myTree = myLCAClass.new BinaryTree();//myTee constructed & shown below in comments
		myTree.root = new BinaryTreeNode(1);                         //1
		myTree.root.left = new BinaryTreeNode(2);                  //2   3
        myTree.root.right = new BinaryTreeNode(3);               //4  5  6 7
        myTree.root.left.left = new BinaryTreeNode(4);    
        myTree.root.left.right = new BinaryTreeNode(5); 
        myTree.root.right.left = new BinaryTreeNode(6); 
        myTree.root.right.right = new BinaryTreeNode(7); 
        
        assertEquals(5, myTree.root.left.right.data);
	}

	@Test
	void testLCA() {
		LowestCommonAncestor myLCAClass = new LowestCommonAncestor();
		LowestCommonAncestor.BinaryTree myTree = myLCAClass.new BinaryTree();//myTee constructed & shown below in comments
		myTree.root = new BinaryTreeNode(1);                         //1
		myTree.root.left = new BinaryTreeNode(2);                  //2   3
        myTree.root.right = new BinaryTreeNode(3);               //4  5  6 7
        myTree.root.left.left = new BinaryTreeNode(4);    
        myTree.root.left.right = new BinaryTreeNode(5); 
        myTree.root.right.left = new BinaryTreeNode(6); 
        myTree.root.right.right = new BinaryTreeNode(7); 
        
        assertEquals(2, myTree.LCA(myTree.root, myTree.root.left.left,myTree.root.left.right).data);
        assertEquals(1 , myTree.LCA(myTree.root, myTree.root.left.left,myTree.root.right.left).data);
        assertEquals(1 , myTree.LCA(myTree.root, myTree.root.right, myTree.root.left.left).data);
        assertEquals(2 , myTree.LCA(myTree.root, myTree.root.left, myTree.root.left.left).data);
        assertEquals(1 , myTree.LCA(myTree.root, myTree.root, myTree.root.left.left).data);
	}
	
	@Test
	void testEmptyTree() {
		LowestCommonAncestor myLCAClass = new LowestCommonAncestor();
		LowestCommonAncestor.BinaryTree myTree = myLCAClass.new BinaryTree();
		
		assertEquals(null, myTree.root);
		assertEquals(null, myTree.LCA(myTree.root, null, null)); 
		//Not possible to do myTree.root.right as will cause Null Pointer exception
	}
	
	@Test
	void testNodeNotInTreeCall() { //Will cause errors if its 'parent' node does not exist too
		LowestCommonAncestor myLCAClass = new LowestCommonAncestor();
		LowestCommonAncestor.BinaryTree myTree = myLCAClass.new BinaryTree();
		
		myTree.root = new BinaryTreeNode(1);  
		assertEquals(null, myTree.root.right);
		assertEquals(null, myTree.root.left);		
	}
	
	@Test
	void testNotIntNodeData() { //Won't work for double, but seems to work for chars for some reason
		LowestCommonAncestor myLCAClass = new LowestCommonAncestor();
		LowestCommonAncestor.BinaryTree myTree = myLCAClass.new BinaryTree();
		myTree.root = new BinaryTreeNode('c');  
		assertEquals('c', myTree.root.data);
	}
	
	@Test
	void testDAG() {
		LowestCommonAncestor myLCAClass = new LowestCommonAncestor();
		LowestCommonAncestor.DAGTree myTree = myLCAClass.new DAGTree(); //myTee constructed & shown below in comments
		
		myTree.root = new DAGTreeNode(1);                         
		myTree.root.successors.add(new DAGTreeNode(2));
		myTree.root.successors.get(0).successors.add(new DAGTreeNode(3));
        
        assertEquals(1, myTree.root.data);
        assertEquals(false, myTree.root.successors.isEmpty());
        assertEquals(2, myTree.root.successors.get(0).data);
        assertEquals(3, myTree.root.successors.get(0).successors.get(0).data);
	}

}
