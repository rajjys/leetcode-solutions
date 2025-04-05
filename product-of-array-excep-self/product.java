lass Solution {
    
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] answers = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;
        ///Evaluate the prefixes
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        ///Evaluate the suffixes
        for(int i = n - 2; i >= 0; i--)
            suffix[i] = suffix[ i + 1] * nums[i + 1];
        ///compute answers
        for(int i = 0; i < n; i++)
            answers[i] = prefix[i] * suffix[i];

        return answers;
    }
}