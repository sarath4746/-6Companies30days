class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        int len = envelopes.length ;

        if (len == 0) return 0 ;

        Arrays.sort(envelopes, (a , b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1] ;
            }

            return a[0] - b[0] ;
        }) ;


        int dp[] = new int[len] ;

        Arrays.fill(dp,1) ;
        int size = 0;

        int mx = 1 ;

        for (int envelope[] : envelopes) {
            int height = envelope[1] ;

            int left = 0 , right = size ;

            while (left < right) {
                int mid = left + (right - left) / 2 ;

                if (dp[mid] < height) left = mid + 1 ;
                else right = mid ;
            }

            dp[left] = height ;

            if (left == size) size++ ;
        }

        return size ;
    }
}