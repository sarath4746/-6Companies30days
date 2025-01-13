class Solution {
    public int findPairs(int[] nums, int k) {
        
        HashMap<Integer,Integer> hm = new HashMap<>() ;
        int cnt = 0 ;

        for (int num : nums) {
            hm.put(num , hm.getOrDefault(num,0)+1) ;
        }


        for (int num : hm.keySet()) {
            if (k == 0) {
                if (hm.get(num) > 1) cnt++ ;
            } else {
                if (hm.containsKey(num+k)) {
                    cnt++ ;
                }
            }
        }

        return cnt ;
    }
}