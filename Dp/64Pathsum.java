class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];
        dp[0][0] = grid[0][0];

        for(int i=1; i<r; i++)
            dp[i][0] = grid[i][0] + dp[i-1][0];
        for(int i=1; i<c; i++)
            dp[0][i] = grid[0][i] + dp[0][i-1];

        for(int i=1; i<r; i++)
            for(int j=1; j<c; j++)
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);

        return dp[r-1][c-1];
    }
}

// start from bottom put the minimum from right and bottom