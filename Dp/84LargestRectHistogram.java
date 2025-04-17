class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        // stack.push(-1);
        int i;
        for(i=0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int h = heights[stack.pop()];
                int w = i-1- (!stack.isEmpty() ? stack.peek() : -1);
                max = Math.max(max, (h*w));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int h = heights[stack.pop()];
            int w = i-1- (!stack.isEmpty() ? stack.peek() : -1);
            max = Math.max(max, (h*w));
        }
        return max;
    }
}


// push items untill a item which is smaller then the top element of stack is found
// is so repeatedly pop item from stack and put it in height var , then substract 1 and peek of stack, 
// peek represents the width of rectangle if h*w is higher then put it in max.