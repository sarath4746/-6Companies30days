class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long commonDivisor = lcm(divisor1, divisor2);
        long low = 1, high = (long) 1e18, result = 0;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            long availableForArr1 = mid - mid / divisor1;
            long availableForArr2 = mid - mid / divisor2;
            long availableForBoth = mid - mid / commonDivisor;
            
            if (availableForArr1 >= uniqueCnt1 && availableForArr2 >= uniqueCnt2 && availableForBoth >= uniqueCnt1 + uniqueCnt2) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return (int) result;
    }
    
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}