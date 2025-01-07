class Solution {

    private int rects[][] ;
    private Random random ;
    private TreeMap<Integer,Integer> tm ;
    private int sum ;

    public Solution(int[][] rects) {
        this.rects = rects ;
        random = new Random() ;
        tm = new TreeMap() ;
        sum = 0 ;

        for (int i = 0 ; i < rects.length ; i++) {
            int rect[] = rects[i] ;
            sum += (rect[2] - rect[0] + 1) * ( rect[3] - rect[1] + 1) ;
            tm.put(sum , i) ;
        }
    }
    
    public int[] pick() {
        
        int num = tm.ceilingKey(random.nextInt(sum) + 1) ;

        int co_ordinates[] = rects[tm.get(num)] ;

        int x = co_ordinates[0] + random.nextInt(co_ordinates[2] - co_ordinates[0] + 1) ;
        int y = co_ordinates[1] + random.nextInt(co_ordinates[3] - co_ordinates[1] + 1) ;

        return new int[] {x , y} ;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */