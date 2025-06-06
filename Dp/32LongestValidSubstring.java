class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int maxLength = 0;
        int[] dp = new int[len];

        for(int i=1; i<len; i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                }
                else if(i-dp[i-1]-1 >= 0 && s.charAt(i - dp[i-1] - 1) == '('){
                    dp[i] = dp[i-1] + (i-dp[i-1] >= 2 ? dp[i - dp[i-1] - 2] : 0) + 2;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }
}

// when a ) is encountered, put 2 in dp[i] after checking if there is ) previously if yes add dp[i-x-1]