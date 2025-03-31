class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        int len = nums.length;
        for(int i=len-2; i>=0; i--){
            if(nums[i] >= len-i-1)
                dp[i] = 1;
            else if(nums[i] <= 0)
                dp[i] = 33000;
            else{
                int min = dp[i+1];
                for(int j=i+1; j<=nums[i]+i && j<len-1; j++){
                    if(min>dp[j])
                        min = dp[j];
                }
                dp[i] = min+1;
            }
        }
        return dp[0];
    }
}

// we will start from the second last element and check that can we get to last element from current element , if yes set dp[i] = 1, else add the value of dp where we can get + 1