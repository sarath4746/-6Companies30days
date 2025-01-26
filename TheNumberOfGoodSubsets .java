class Solution {
    static int MOD = (int) 1e9 + 7;
    static int[] primeMask = new int[31];
    
    static {
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int i = 2; i <= 30; ++i) {
            if (i % 4 == 0 || i % 9 == 0 || i == 25) continue;
            int mask = 0;
            for (int j = 0; j < 10; ++j) {
                if (i % primes[j] == 0) mask |= 1 << j;
            }
            primeMask[i] = mask;
        }
    }
    
    public int numberOfGoodSubsets(int[] nums) {
        int n = nums.length, onesCount = 0;
        int[] dp = new int[1024], count = new int[31];
        
        dp[0] = 1;
        for (int num : nums) {
            if (num == 1) {
                onesCount++;
            } else if (primeMask[num] != 0) {
                count[num]++;
            }
        }
        
        for (int i = 0; i < 31; ++i) {
            if (count[i] == 0) continue;
            for (int mask = 0; mask < 1024; ++mask) {
                if ((mask & primeMask[i]) != 0) continue;
                dp[mask | primeMask[i]] = (int) ((dp[mask | primeMask[i]] + (long) dp[mask] * count[i]) % MOD);
            }
        }
        
        long result = 0;
        for (int val : dp) {
            result = (result + val) % MOD;
        }
        
        result--;
        
        if (result < 0) {
            result += MOD;
        }
        
        if (onesCount > 0) {
            result = result * modPow(onesCount) % MOD;
        }
        
        return (int) result;
    }
    
    private long modPow(int n) {
        long result = 1, base = 2;
        while (n > 0) {
            if ((n & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            n >>= 1;
        }
        return result;
    }
}