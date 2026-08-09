// class Solution {
//     public int threeSumClosest(int[] nums, int target) {
        
//     }
// }


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the array so we can use the two-pointer approach
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with the first possible sum
        
        // Step 2: Fix one number and use two pointers for the other two
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // If we found an exact match, return it immediately
                if (currentSum == target) {
                    return currentSum;
                }
                
                // Update closestSum if the current sum is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // Move pointers based on how the current sum compares to the target
                if (currentSum < target) {
                    left++; // We need a larger sum
                } else {
                    right--; // We need a smaller sum
                }
            }
        }
        
        return closestSum;
    }
}