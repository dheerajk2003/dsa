class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            if(minHeap.peek() == null || nums[i] >= minHeap.peek() || minHeap.size() < k){
                minHeap.offer(nums[i]);
            }
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}

// this is done by creating a min heap and adding an element if its greater than the top (smalleset heap itm) , and if the size of heap exceeds k poll.