class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length ;

        int nums_indices[][] = new int[n][2] ;

        for (int i = 0 ; i < n ; i++) {
            nums_indices[i][0] = i ;
            nums_indices[i][1] = nums[i] ;
        }

        Arrays.sort(nums_indices , (a,b) -> b[1] - a[1]) ;

        int top_k[][] = Arrays.copyOf(nums_indices, k) ;

        Arrays.sort(top_k , (a, b) -> a[0] - b[0]);

        int res[] = new int[k] ;

        for (int i = 0; i < k ; i++) {
            res[i] = top_k[i][1] ;
        }

        return res ;
        
    }
}