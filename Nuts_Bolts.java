// User function Template for Java

class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        
        int ascii_[] = new int[256] ;
        
        for (int i = 0 ; i < n ; i++) {
            ascii_[ (int)nuts[i] ]++ ;
        }
        
        
        int ind = 0 ;
        for (int i = 0 ; i < 256 ; i++) {
            
            if ( ascii_[i] > 0) {
                nuts[ind] = (char)i;
                bolts[ind++] = (char)i ;
            }
        }
        
    }
}