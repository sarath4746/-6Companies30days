class Solution {
    public int maximumProduct(int[] nums, int k) {

        int Mod = 1000000007 ;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>() ;

        for (int e : nums) {
            pq.offer(e) ;
        }

        while ( k > 0 ) {
            int smallest = pq.poll() ;

            smallest++ ;
            pq.offer(smallest) ;

            k-- ;
        }

        long product = 1 ;

        while (!pq.isEmpty()) {
            product = (product * pq.poll()) % Mod ;
        }

        return (int)product ;
    }
}