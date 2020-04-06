package StringPrograms;

class BoolArray 
{
    boolean [] b = new boolean[3];
    int count = 0;

    void set(boolean [] x, int i) 
    {
        x[i] = true;
        ++count;
    }

    static boolean b1, b2;
    public static void main(String [] args) 
    {
    	int i = 0, j = 5; 
    	tp: for (;;) 
    	    {
    	        i++;  
    	        for (;;) 
    	        {
    	            if(i > --j) 
    	            {
    	                break tp; 
    	            } 
    	        } 
    	    }
    	System.out.println("i =" + i + ", j = " + j);
   }

    void test() 
    {
        if ( b[0] && b[1] | b[2] )
            count++;
        if ( b[1] && b[(++count - 2)] )
            count += 7;
        System.out.println("count = " + count);
    }
}
