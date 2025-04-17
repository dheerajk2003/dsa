class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r][c];
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<c; i++){
            if(matrix[0][i] == '1')
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        }
        for(int i=1; i<r; i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j] == '1')
                    dp[i][j] = 1 + dp[i-1][j];
                else
                    dp[i][j] = 0;
            }
        }
        for(int i=0; i<r; i++){
            int j;
            for(j=0; j<c; j++){
                while(!stack.isEmpty() && dp[i][j] < dp[i][stack.peek()]){
                    int h = dp[i][stack.pop()];
                    int w = j-1-(!stack.isEmpty() ? stack.peek() : -1);
                    max = Math.max(w*h , max);
                }
                stack.push(j);
            }
            while(!stack.isEmpty()){
                    int h = dp[i][stack.pop()];
                    int w = j-1-(!stack.isEmpty() ? stack.peek() : -1);
                    max = Math.max(w*h , max);
                }
        }
        return max;
    }
}


// first create histogram by adding above row if there is 1 in that column, then solve it using 
// the histogram like 84 