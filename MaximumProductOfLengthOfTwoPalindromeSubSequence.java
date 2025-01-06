class Solution {
    public int maxProduct(String s) {
        
        int len = s.length() ;

        int dp[] = new int[1<<len] ;
        int res = 0 ;
        int mask = (1 << len) - 1 ;

        for (int m = 1 ; m <= mask ; m++) {
            dp[m] = palCheck(s , m) ;
        }

        for (int m1 = mask ; m1 > 0 ; m1--) {
            if (dp[m1] * (len - dp[m1]) > res) {
                for (int m2 = mask ^ m1 ; m2 > 0 ; m2 = (m2 - 1) & (mask ^ m1)) {
                    res = Math.max(res , dp[m1]*dp[m2]) ;
                }
            }
        }

        return res ;
    }

    static int palCheck(String s , int mask) {
        int l = 0 ;
        int r = s.length() - 1 ;
        int len = 0 ;

        while (l <= r) {
            if ( (mask & ( 1 << l)) == 0 ) l++ ;
            else if ( (mask & (1 << r)) == 0 ) r-- ;
            else if ( s.charAt(l) != s.charAt(r)) return 0 ;
            else len += 1 + (l++ != r-- ? 1 : 0) ;
        }

        return len ;
    }
}