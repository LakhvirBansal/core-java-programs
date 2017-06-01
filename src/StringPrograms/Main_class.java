package StringPrograms;

class MyClass implements alpha, Beta {
	  void display() {
	    System.out.println("This is not default");
	  }
	  
	 /* @Override
	 public void reset(){
		  //in order to call alpha's reset
		  alpha.super.reset1();
		    //if you want to call beta's reset 
		   Beta.super.reset();
	  }*/
	}

public class Main_class {
	public static void main(String args[]) {
	    MyClass ob = new MyClass();
	    ob.reset();
	    ob.display();
	    ob.reset1();
	  }  
}
