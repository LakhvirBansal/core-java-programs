package StringPrograms;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

class QueueImplement {

	Stack<Integer> s ;
    Stack<Integer> tmp ;
 
    /* Constructor */
    public QueueImplement()
    {
        s = new Stack<Integer>();
        tmp = new Stack<Integer>();
    }
    /*  Function to insert an element to the queue */
    public void insert(int data)
    {
        /* if no element is present in stack s then
         * push the new element to stack s */         
        if (s.size() == 0)
            s.push(data);
        else
        {   
            /* if elements are present in stack s then
             * pop all the elements from stack s and
             * push them to stack tmp  */        
            int l = s.size();
            for (int i = 0; i < l; i++)
                tmp.push(s.pop());                   
            /* push the new element to stack s */             
            s.push(data);            
            /* pop all elements from stack tmp and
             * push them to stack s */             
            for (int i = 0; i < l; i++)
                s.push(tmp.pop());                   
        }
    }    
    /*  Function to remove front element from the queue */
    public int remove()
    {
        if (s.size() == 0)
            throw new NoSuchElementException("Underflow Exception");            
        return s.pop();
    }    
    /*  Function to check the front element of the queue */
    public int peek()
    {
        if (s.size() == 0)
            throw new NoSuchElementException("Underflow Exception");            
        return s.peek();
    }        
    /*  Function to check if queue is empty */
    public boolean isEmpty()
    {
        return s.size() == 0 ;
    }    
    /*  Function to get the size of the queue */
    public int getSize()
    {
        return s.size();
    }    
    /*  Function to display the status of the queue */
    public void display()
    {
        System.out.print("\nQueue = ");
        int l = getSize();
        if (l == 0)
            System.out.print("Empty\n");
        else
        {
            /* Iterator wont return for stack in order */            
            for (int i = l - 1; i >= 0; i--)
                System.out.print(s.get(i)+" ");                
            System.out.println();
        }
    }
}
 
/*  Class QueueImplementUsingTwoStacks */
public class QueueImplementUsingTwoStacks
{    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);    
        /* Creating object of class queueUsingStack */
        QueueImplement qus = new QueueImplement();            
        /* Perform Queue Operations */            
        System.out.println("Queue Using Two Stacks Test\n"); 
        char ch;         
        do
        {
            System.out.println("\nQueue Operations");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. size");            
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                qus.insert( scan.nextInt() );                 
                break;                         
            case 2 : 
                try
                {
                    System.out.println("Removed Element = "+ qus.remove() );
                }
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }    
                break;                         
            case 3 : 
                try
                {
                    System.out.println("Peek Element = "+ qus.peek() );
                }
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;                          
            case 4 : 
                System.out.println("Empty status = "+ qus.isEmpty() );
                break;                
            case 5 : 
                System.out.println("Size = "+ qus.getSize() );
                break;                          
            default : 
                System.out.println("Wrong Entry \n ");
                break;    
            }                
            /* Display Queue */        
            qus.display();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
 
        } while (ch == 'Y'|| ch == 'y');                                                            
    } 
}
