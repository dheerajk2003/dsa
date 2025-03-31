class Solution{
    public static void main(String[] args) {
        int nums[] = {1,1,1,1};
        System.out.println(jump(nums));
    }
    static int jump(int[] nums) {
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
                    System.out.println(nums[i]+i);
                    if(min>dp[j])
                        min = dp[j];
                }
                dp[i] = min+1;
            }
        }
        for(int k=0; k<dp.length; k++){
            System.out.print(dp[k]+" ");
        }
        return dp[0];
    }
}
