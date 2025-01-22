class DataStream {
    private int target;
    private int length;
    private int consecutiveCount;
    private int totalCount;

    public DataStream(int target, int length) {
        this.target = target;
        this.length = length;
        this.consecutiveCount = 0;
        this.totalCount = 0;
    }

    public boolean consec(int num) {
        if (num == target) {
            consecutiveCount++;
        } else {
            consecutiveCount = 0;
        }
        
        totalCount++;
        T
        return consecutiveCount >= length;
    }
}
