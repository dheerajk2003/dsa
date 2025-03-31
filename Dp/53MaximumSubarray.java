class Solution {
    public int maxSubArray(int[] nums) {
        int res=nums[0], sum=nums[0];
        for(int i=1; i<nums.length; i++){
            sum = Math.max(nums[i] + sum , nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
}


//in this we will set first element as res and sum, set sum = max from current item or sum + current item , if sum is greater than res set res = sum