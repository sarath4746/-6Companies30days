class Solution {
    public int longestString(int x, int y, int z) {
        
        int a_cnt = 2*x + z ;
        int b_cnt = 2*y + z ;

        if ( a_cnt < b_cnt) return 2*a_cnt + 2 ;
        else if (b_cnt < a_cnt) return 2*b_cnt + 2 ;
        else return 2*a_cnt ;
    }
}