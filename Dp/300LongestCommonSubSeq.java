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

// in this we calculate how many smaller numbers does a number have before it, for this we use nested loop, and we use this precomputation to calculate longest increasing substring
