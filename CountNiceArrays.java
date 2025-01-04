class Solution {
    
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {

        int oddCount = 0, totalSubarrays = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            oddCount += nums[right] & 1;

            while (oddCount > k) {
                oddCount -= nums[left++] & 1;
            }

            totalSubarrays += (right - left + 1);
        }

        return totalSubarrays;
    }
}