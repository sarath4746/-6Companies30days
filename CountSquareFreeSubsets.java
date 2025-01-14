class Solution {

    public int squareFreeSubsets(int[] nums) {


        int MOD = 1_000_000_007;
        int[] primeMasks = new int[31];
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        
        for (int i = 1; i <= 30; i++) {
            int mask = 0;
            int x = i;
            boolean isSquareFree = true;
            
            for (int j = 0; j < primes.length; j++) {
                int prime = primes[j];
                int count = 0;
                
                while (x % prime == 0) {
                    x /= prime;
                    count++;
                }
                
                if (count > 1) {
                    isSquareFree = false;
                    break;
                }
                
                if (count == 1) {
                    mask |= (1 << j);
                }
            }
            
            primeMasks[i] = isSquareFree ? mask : -1; 
        }

        int[] dp = new int[1 << primes.length];
        dp[0] = 1; 

        for (int num : nums) {
            int mask = primeMasks[num];
            if (mask == -1) continue; 

            for (int state = (1 << primes.length) - 1; state >= 0; state--) {
                if ((state & mask) == 0) { 
                    dp[state | mask] = (dp[state | mask] + dp[state]) % MOD;
                }
            }
        }

        int result = 0;
        for (int count : dp) {
            result = (result + count) % MOD;
        }

        return (result - 1 + MOD) % MOD; 
    }
}