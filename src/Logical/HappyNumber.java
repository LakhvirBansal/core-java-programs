package Logical;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {

	public static void main(String[] args) {

		HappyNumber obj = new HappyNumber();
		boolean happyNumber =  obj.happyNumber(19);
		System.out.println("happy number :"+happyNumber);
	}
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	private boolean happyNumber(int i) {
		
		if(map.containsKey(i)) {
			return false;
		} else {
			map.put(i,0);
			int totalNumber = 0;
			while(i > 0) {
				totalNumber = (int) (totalNumber + Math.pow((i%10), 2));
				i = i/10;
			}
			if(totalNumber == 1) {
				return true;
			} else {
				return happyNumber(totalNumber);
			}
		}
	}

	
}
