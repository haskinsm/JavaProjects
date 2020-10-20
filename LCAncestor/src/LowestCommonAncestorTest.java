import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {

	@Test
	void testTree() {
		LowestCommonAncestor myTree = new LowestCommonAncestor(); //myTee constructed & shown below in comments
		myTree.root = new TreeNode(1);                         //1
		myTree.root.left = new TreeNode(2);                  //2   3
        myTree.root.right = new TreeNode(3);               //4  5  6 7
        myTree.root.left.left = new TreeNode(4);    
        myTree.root.left.right = new TreeNode(5); 
        myTree.root.right.left = new TreeNode(6); 
        myTree.root.right.right = new TreeNode(7); 
        
        assertEquals(5, myTree.root.left.right.data);
	}

	@Test
	void testLCA() {
		LowestCommonAncestor myTree = new LowestCommonAncestor(); //myTee constructed & shown below in comments
		myTree.root = new TreeNode(1);                         //1
		myTree.root.left = new TreeNode(2);                  //2   3
        myTree.root.right = new TreeNode(3);               //4  5  6 7
        myTree.root.left.left = new TreeNode(4);    
        myTree.root.left.right = new TreeNode(5); 
        myTree.root.right.left = new TreeNode(6); 
        myTree.root.right.right = new TreeNode(7); 
        
        assertEquals(2, myTree.LCA(myTree.root, myTree.root.left.left,myTree.root.left.right).data);
        assertEquals(1 , myTree.LCA(myTree.root, myTree.root.left.left,myTree.root.right.left).data);
        assertEquals(1 , myTree.LCA(myTree.root, myTree.root.right, myTree.root.left.left).data);
        assertEquals(2 , myTree.LCA(myTree.root, myTree.root.left, myTree.root.left.left).data);
        assertEquals(1 , myTree.LCA(myTree.root, myTree.root, myTree.root.left.left).data);
	}
	
	@Test
	void testEmptyTree() {
		LowestCommonAncestor myTree = new LowestCommonAncestor();
		assertEquals(null, myTree.root);
		assertEquals(null, myTree.LCA(myTree.root, null, null)); 
		//Not possible to do myTree.root.right as will cause Null Pointer exception
	}
	
	@Test
	void testNodeNotInTreeCall() { //Will cause errors if its 'parent' node does not exist too
		LowestCommonAncestor myTree = new LowestCommonAncestor();
		myTree.root = new TreeNode(1);  
		assertEquals(null, myTree.root.right);
		assertEquals(null, myTree.root.left);		
	}
	
	@Test
	void testNotIntNodeData() { //Won't work for double, but seems to work for chars for some reason
		LowestCommonAncestor myTree = new LowestCommonAncestor();
		myTree.root = new TreeNode('c');  
		assertEquals('c', myTree.root.data);
	}
}
