class Solution {
    public boolean canJump(int[] nums) {
        int g = nums.length-1;
        for(int i= nums.length-1; i>=0; i--){
            if(i+nums[i] >= g)
                g = i;
        }
        return g==0;
    }
}

//We first check that can we get to current element from last element(i + nums[i]) , if yes make last element goal