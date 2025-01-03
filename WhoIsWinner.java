class Solution {
    public int findTheWinner(int n, int k) {
        
        int result = 0 ;

        for (int player = 2 ; player <= n ; player++) {
            result = (result + k) % player ;
        }

        return result + 1 ;
    }
}