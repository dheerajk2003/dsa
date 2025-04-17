class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=len1-1; i>=0;i--){
            for(int j=len2-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = 1 + dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }
        return dp[0][0];
    }
}

// in this we create a dp array of 1 + dimension , then we compare the row and col item,
// if they match we put 1 + dp[i+1][j+1] else we put the max of dp[i][j+1] and dp[i+1][j]