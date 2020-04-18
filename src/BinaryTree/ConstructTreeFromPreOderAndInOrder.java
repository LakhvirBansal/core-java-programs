package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreOderAndInOrder {

	Node root; 
    static int preIndex = 0; 
  
    Node buildTreeWrap(int in[], int pre[], int inStrt, int inEnd)  { 
    	
    	Map<Integer, Integer> searchMap = new HashMap<Integer, Integer>();
    	for (int i = 0; i < in.length; i++) {
			searchMap.put(in[i], i);
		}
    	Node tNode = buildTree(in,pre,inStrt,inEnd,searchMap);
    	return tNode;
       
    } 
  
    /* Recursive function to construct binary of size len from 
    Inorder traversal in[] and Preorder traversal pre[]. 
    Initial values of inStrt and inEnd should be 0 and len -1.   
    The function doesn't do any error checking for cases where  
    inorder and preorder do not form a tree */
    Node buildTree(int in[], int pre[], int inStrt, int inEnd,Map<Integer, Integer> searchMap){
    	
    	 if (inStrt > inEnd) 
             return null; 
   
         /* Pick current node from Preorder traversal using preIndex 
            and increment preIndex */
         Node tNode = new Node(pre[preIndex++]); 
   
         /* If this node has no children then return */
         if (inStrt == inEnd) 
             return tNode; 
   
         /* Else find the index of this node in Inorder traversal */
         int inIndex = searchMap.get(tNode.data);
   
         /* Using index in Inorder traversal, construct left and 
            right subtress */
         tNode.left = buildTree(in, pre, inStrt, inIndex - 1, searchMap); 
         tNode.right = buildTree(in, pre, inIndex + 1, inEnd, searchMap); 
   
         return tNode; 
    }
 
    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
        printInorder(node.left); 
        System.out.print(node.data + " "); 
        printInorder(node.right); 
    } 
  
    // driver program to test above functions 
    public static void main(String args[]) 
    { 
    	ConstructTreeFromPreOderAndInOrder tree = new ConstructTreeFromPreOderAndInOrder(); 
        int in[] = {8,4,10,9,11,2,5,1,6,3,7};
        int pre[] = { 1,2,4,8,9,10,11,5,3,6,7 }; 
        int len = in.length; 
        Node root = tree.buildTreeWrap(in, pre, 0, len - 1); 
  
        // building the tree by printing inorder traversal 
        System.out.println("Inorder traversal of constructed tree is : "); 
        tree.printInorder(root); 
    }  
}
