package StringPrograms;

class MirrorNode 
{
    int data;
    MirrorNode left, right;
 
    public MirrorNode(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class MirrorImage {
//	MirrorNode a, b;
    
    /* Given two trees, return true if they are
       mirror of each other */
    boolean areMirror(MirrorNode a, MirrorNode b) 
    {
        /* Base case : Both empty */
        if (a == null && b == null)
            return true;
 
        // If only one is empty
        if (a == null || b == null) 
            return false;
 
        /* Both non-empty, compare them recursively
           Note that in recursive calls, we pass left
           of one tree and right of other tree */
        return a.data == b.data
                && areMirror(a.left, b.right)
                && areMirror(a.right, b.left);
    }
 
    // Driver code to test above methods
    public static void main(String[] args) 
    {
    	MirrorImage tree = new MirrorImage();
        MirrorNode a = new MirrorNode(1);
        MirrorNode b = new MirrorNode(1);
        a.left = new MirrorNode(2);
        a.right = new MirrorNode(3);
        a.left.left = new MirrorNode(4);
        a.left.right = new MirrorNode(5);
 
        b.left = new MirrorNode(3);
        b.right = new MirrorNode(2);
        b.right.left = new MirrorNode(5);
        b.right.right = new MirrorNode(4);
 
        if (tree.areMirror(a, b) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
 
    }
}
