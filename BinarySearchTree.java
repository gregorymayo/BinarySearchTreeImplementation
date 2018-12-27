import java.util.Scanner; 
import java.util.*;

public class BinarySearchTree {
	
	public class Node{
		//Form line 7 to line 18, I am declaring the variable that we are going to use
		private int data;
		Node left;
		Node right;	
		Node parent;
		public Node(int data){
			this.data = data;
			this.parent = parent;
			left = null;
			right = null;
		}
	}
	
	Node root;
	Node valueTree;
	
	public BinarySearchTree(){
		root = null;
	}
	
	//This is the function for insert a value to the binary search tree
	public Node insert(Node tree, int value){
		//Changing the value into a node called valueTree
		valueTree = new Node(value);
		Node y = null;
		Node x = root;
		
		while(x!=null)
		{
			y = x;
			if(valueTree.data<x.data)
				x = x.left;
			else
				x = x.right;
		}
		valueTree.parent = y;
		
		if (y == null)
			root = valueTree;
		else if(valueTree.data <= y.data)
			y.left = valueTree;
		else
			y.right = valueTree;
		return y;
		
	}
	
	//Function to get a node based on the inorder BST
	public void inOrder(Node root) {
		if(root !=  null) {
			inOrder(root.left);
			System.out.printf("%d ",root.data);
			inOrder(root.right);
		}
	}
	
	//To search a specific value in the BST
	public int search(Node root, int value)
	{
		if(root == null || root.data == value)
			return value;
		
		if (value < root.data)
			return search(root.left,value);
		
		return	search(root.right,value);
		
	}
	
	//To get the minimum number in the BST
	public Node minimum(Node root)
	{
		while(root.left != null)
			root = root.left;
		return root;
	}
	
	//The function transplant that we are going to use for the delete function
	protected void transplant(Node root, Node inputO, Node inputT)
	{	
		if(inputO.parent == null)
			root = inputT;
		else if (inputO == inputO.parent.left)
			inputO.parent.left = inputT;
		else 
			inputO.parent.right = inputT;
		
		if(inputT!=null)
			inputT.parent = inputO.parent;
	}
	
	//The function to delete a specific value in the BST
	public void delete(Node root, int value)
	{
		
		Node valueTree = new Node(value);
		
		if(valueTree.left == null)
			transplant(root,valueTree,valueTree.right);
		else if(valueTree.right == null)
			transplant(root,valueTree,valueTree.left);
		else {
			Node y = minimum(valueTree.right);
			
		if(y.parent != valueTree)
			{
				transplant(root, y,y.right);
				y.right = valueTree.right;
				y.right.parent = y;
			}
			transplant(root,valueTree,y);
			y.left = valueTree.left;
			y.left.parent = y;
			
		}
		
		
		
		/*
		Node y = new Node(0);
		if(valueTree.left==null || valueTree.right ==null)
		{
			y = valueTree;
		}
		else
			y = successor(valueTree);
		
		if(y.left!=null)
			root = y.left;
		else
			root = y.right;
		
		if(root!=null)
			root.parent = y.parent;
		if(y.parent == null)
			root = root;
		else if(y == y.parent.left)
			y.parent.left = root;
		else
			y.parent.right = root;
		
		if(y!=valueTree)
			valueTree.data = y.data;
		
		return y;
		
		*/
		//inOrder(root);
		//return root;
		
	}
	
	public Node successor(Node root)
	{
		if(root.right != null)
			return minimum(root.right);
		Node y = root.parent;
		while(y!=null && root == y.right)
		{
			root = y;
			y = y.parent;
		}
		return y;
		
	}
}
