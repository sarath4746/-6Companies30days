class Solution {

    private static long pow(long num,long p){

		if(p == 0)
			return 1l;

		long Mod = 1_000_000_007 ;
		long temp = pow(num, p/2);
		temp = ( (temp % Mod) * (temp % Mod ) )% Mod ;
		if(p % 2 != 0){
			return temp * (num % Mod) ;
		}

        return temp ;
	}

    public static int minNonZeroProduct(int p) {
        long Mod = 1_000_000_007 ;
		long max = (long)(Math.pow(2,p)) - 1;
		long power = pow(max -1 , (max -1)/2);
		power = ((power % Mod) * ( max % Mod)) % Mod;
		return (int)power;
    }
        
}