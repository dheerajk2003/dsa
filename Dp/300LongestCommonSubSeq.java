class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i=1; i<len; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max=0;
        for(int num : dp)
            max = Math.max(max, num);
        return max;
    }
}

// this question is done by matching the j to i if its less than put max dp[i] , dp[j+1]