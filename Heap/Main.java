public class Main {
	public static void main(String[] args) {
		int[] nums = {7,7,7,7,8,3};
		KthLargest kl = new KthLargest(4, nums);
		System.out.println(kl.add(2)); 
		System.out.println(kl.add(10)); 
		System.out.println(kl.add(9)); 
		System.out.println(kl.add(9))  ;
	}
}

class KthLargest {
    private int[] heap;
    private int k;
    private int size = 0;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new int[k];
        
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (size < k) {
            heap[size] = val;
            siftUp(size);
            size++;
        } else if (val > heap[0]) {
            heap[0] = val;
            siftDown(0);
        }
        
        return heap[0];
    }
    
    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] > heap[index]) {
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }
    
    private void siftDown(int index) {
        while (true) {
            int smallest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            
            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }
            
            if (smallest == index) {
                break;
            }
            
            swap(index, smallest);
            index = smallest;
        }
    }
    
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}