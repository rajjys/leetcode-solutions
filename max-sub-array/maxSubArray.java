class Solution {
    public int maxSubArray(int[] nums) {
        int current_sum  = nums[0]; ///track the current sum, init to the first element
        int global_sum = nums[0]; ///track the global big sum
        for(int i = 1; i < nums.length; i++){
            int current_value = nums[i]; 
            if(current_value >= 0){
                    if(current_sum >= 0) ///if value is positive and sum, add up
                        current_sum = current_sum + current_value;
                    else current_sum = current_value; ///If sum negative, value becomes the sum
            }
            else {
                    if((current_sum + current_value) >= 0)
                        ///If value negative but their addition is still psitive, add them
                         current_sum = current_sum +  current_value;
                    else current_sum = current_value;///else, leave them, start anew
            }
            global_sum = global_sum < current_sum ? current_sum : global_sum;///Evaluate each time
        }
        return global_sum;
    }
}