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
        /*BoolArray ba = new BoolArray();
        ba.set(ba.b, 0);
        ba.set(ba.b, 2);
        ba.test();*/
        
        /*int x = 0;
        if ( !b1 )  Line 7 
        {
            if ( !b2 )  Line 9 
            {
                b1 = true;
                x++;
                if ( 5 > 6 ) 
                {
                    x++;
                }
                if ( !b1 ) 
                    x = x + 10;
                else if ( b2 = true )  Line 19 
                    x = x + 100;
                else if ( b1 | b2 )  Line 21 
                    x = x + 1000;
            }
        }
        System.out.println(x);*/
    	
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
    	        } }
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
