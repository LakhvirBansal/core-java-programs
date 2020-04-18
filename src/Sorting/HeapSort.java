package Sorting;
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
public class HeapSort {

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7}; 
        int n = arr.length; 
  
        HeapSort ob = new HeapSort(); 
        ob.sort(arr); 
  
        System.out.println("Sorted array is"); 
        printArray(arr); 
	}

	private static void printArray(int[] arr) {
		int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
		
	}

	private void sort(int[] arr) {
		 int n = arr.length; 
		  
	        /*
	         * convert the array into a heap (we need to ensure that array is a heap) 
	         * if elements are not according to heap we need to do heapify
	         * 
	         */
		 
	        for (int i = n / 2 - 1; i >= 0; i--) 
	            heapify(arr, n, i); 
	  
	        // One by one extract an element from heap 
	        for (int i=n-1; i>0; i--) 
	        { 
	            // Move current root to end 
	            int temp = arr[0]; 
	            arr[0] = arr[i]; 
	            arr[i] = temp; 
	  
	            // call max heapify on the reduced heap 
	            heapify(arr, i, 0);  // 0 because the last element is now the first element
	        } 
		
	}
	
	 void heapify(int arr[], int n, int i) 
	    { 
	        int largest = i; // Initialize largest as root 
	        int l = 2*i + 1; // left = 2*i + 1 
	        int r = 2*i + 2; // right = 2*i + 2 
	  
	        // If left child is larger than root 
	        if (l < n && arr[l] > arr[largest]) 
	            largest = l; 
	  
	        // If right child is larger than largest so far 
	        if (r < n && arr[r] > arr[largest]) 
	            largest = r; 
	  
	        // If largest is not root 
	        if (largest != i) 
	        { 
	            int swap = arr[i]; 
	            arr[i] = arr[largest]; 
	            arr[largest] = swap; 
	  
	            // Recursively heapify the affected sub-tree 
	            heapify(arr, n, largest); 
	        } 
	    } 
}
