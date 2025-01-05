class Solution {
    public int incremovableSubarrayCount(int[] nums) {

        int res = 0 ;

        int len = nums.length ;

        for (int i = 0 ; i < len ; i++) {

            for (int j = i ; j < len ; j++) {

                boolean flag = true ;
                int last_element = 0 ;

                for (int k = 0 ; k < len ; k++) {

                    if (k >= i && k <= j) {
                        continue ;
                    }
                    flag = flag && (last_element < nums[k]) ;
                    
                    last_element = nums[k] ;
                }

                if (flag) res++ ;
            }
        }
        return res ;
    }
}