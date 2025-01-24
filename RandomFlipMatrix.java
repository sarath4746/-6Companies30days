class Solution {

    private int rows, cols, tot;
    private HashMap<Integer, Integer> map;
    private Random rnd;

    public Solution(int m, int n) {
        this.rows = m;
        this.cols = n;
        this.tot = m * n;
        this.map = new HashMap<>();
        this.rnd = new Random();
    }

    public int[] flip() {
        int idx = rnd.nextInt(tot--);
        int act = map.getOrDefault(idx, idx);
        map.put(idx, map.getOrDefault(tot, tot));
        return new int[]{act / cols, act % cols};
    }

    public void reset() {
        map.clear();
        tot = rows * cols;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */