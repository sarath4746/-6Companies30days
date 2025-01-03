import java.util.Arrays;
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums) ; 
        // All values on the left of the median will be less than or equal to the median and right of the median will be greater than or equal to the median.

        int mid = nums.length / 2 ;
        // Finding the median element, which is at the middle of the sorted array
        // If the length of the array is odd, it is the exact middle; if even, it is the lower middle

        int moves = 0 ;

        for (int i = 0 ; i < nums.length ; i++) {
            moves += Math.abs(nums[i] - nums[mid]) ;
        }
        return moves ;
    }
}