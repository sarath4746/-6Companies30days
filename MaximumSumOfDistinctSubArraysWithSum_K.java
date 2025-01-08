class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long maxSum = 0;
        Map<Integer, Integer> lastIndex = new HashMap<>();
        long windowSum = 0;
        
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            
            int prev = lastIndex.getOrDefault(nums[right], -1);
            
            while (left <= prev || right - left + 1 > k) {
                windowSum -= nums[left];
                left++;
            }
            
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
            
            lastIndex.put(nums[right], right);
        }
        
        return maxSum;
    }
}