package heap;

import java.util.ArrayList;
import java.util.List;

/*
 * A heap have the following properties:
 * 1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible).
 * 	 This property of Binary Heap makes them suitable to be stored in an array.
 * 2)  A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap.
 * 	 The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to MinHeap.
 * 
 * in a heap there are following properties:
 * 	Arr[0] is the parent node
 *	Arr[(i-1)/2]	Returns the parent node
	Arr[(2*i)+1]	Returns the left child node
	Arr[(2*i)+2]	Returns the right child node
	
	implementaion : we store the element in the list, because Heap is a complete binary tree, so elements are inserted in increasing order and 
	then we shift the elements to create the heap.
 */
public class Heap {

	private List<Integer> items;
	
	public Heap() {
		items = new ArrayList<Integer>();
	}
	
	private void shiftUp() {

		int k = items.size() -1;
		
		while(k > 0) {
			Integer item = items.get(k); // current value
			int p = (k-1)/2; // root element index
			Integer parent = items.get(p); // parent value
			
			if(item > parent) { // if kth value is greater than parent value we need to swap the data.
				items.set(k, parent);
				items.set(p, item);
				k= p; // after swapping the element now kth position is the the parentelement position and check its parent value
			} else { 
				break;
			}
			
		}
	}
	
	public void insert(Integer item) {
		items.add(item);
		shiftUp();
	}
	
	private void shiftDown() {
		int k = 0;
		int l = 2*k + 1;
		while(l < items.size()){
			int max = l, r = l+1;
			if(r < items.size()) {
				if(items.get(r).compareTo(items.get(l)) > 0) {
					max++;
				}
			}
			
			if(items.get(k).compareTo(items.get(max)) < 0) {
				
				Integer temp = items.get(k);
				items.set(k, items.get(max));
				items.set(max, temp);
				k = max;
				l = 2*k + 1;
			} else {
				break;
			}
		}
	}
	
	public int delete() {
		if(items.size() == 0) {
			return 0;
		}
		if(items.size() == 1) {
			return items.remove(0);
		}
		
		Integer hold = items.get(0); // rem
		items.set(0, items.remove(items.size() - 1));
		shiftDown();
		return hold;
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(6);
		heap.insert(8);
		heap.insert(9);
		heap.insert(9);
		heap.insert(10);
		heap.insert(15);
		
		System.out.println(heap.items);
		
		
		  while(!heap.items.isEmpty()) { 
			  int max = heap.delete();
			  System.out.println(max+" "+heap.items);
		  }
		 
	}
}
