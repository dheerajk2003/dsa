class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0, temp;
        while(nums[i] != -1){
            temp = nums[i];
            nums[i] = -1;
            i = temp;
        }
        return i;
    }
}

// we can do this by iserting -1 at the index corresponding to the value of the array

// another faster method is to create a bollean array and insert true if the value is present

// class Solution {
//     public int findDuplicate(int[] nums) {
//         boolean []n = new boolean[nums.length +1] ;
//         for(int i:nums)
//         {
//             if(n[i] == true)
//                 return i;
//             n[i]=true;
//         }
//         return -1;
//     }
// }