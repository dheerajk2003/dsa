class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            dp[i] += dp[i-1];
            if(i<n)
                dp[i+1] += dp[i-1];
        }
        return dp[n];
    }
}

// add the value of previous element to current and next element