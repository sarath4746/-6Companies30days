class Solution {

    public static int combination(int n , int r) {

        if (r < 0 || r > n) return 0 ;
        
        long res = 1 ;

        for (int i = 0 ; i < r ; i++) {
            res = res * (n - i)/(i+1) ;
        }

        return (int)res ;
    }
    public int waysToReachStair(int k) {
        int ways = 0 ;

        for (int jump = 0 ; jump < 31 ; jump++) {
            ways += combination(jump+1 , (1<<jump)-k) ;
        }

        return ways ;
    }
}