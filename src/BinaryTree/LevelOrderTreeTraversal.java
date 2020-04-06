package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class LevelOrderTreeTraversal {

	Node root;
	
	public LevelOrderTreeTraversal()
    {
        root = null;
    }
 
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
    
    int height(Node root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
    
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
    
    
	 public static void main(String args[]) {
		 LevelOrderTreeTraversal tree = new LevelOrderTreeTraversal();
	       tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	        
	       System.out.println("Level order traversal of binary tree is ");
	       //tree.printLevelOrder();
	       tree.printLevelOrderUsingQueue();
	       
	    }

	private void printLevelOrderUsingQueue() {
		if(root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			
			System.out.print(temp.data+" ");
			
			if(temp.left != null) {
				queue.add(temp.left);
			}
			
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
		
		
		
	}

}
