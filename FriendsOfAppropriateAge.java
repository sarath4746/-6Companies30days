class Solution {
    public int numFriendRequests(int[] ages) {
        int[] freq = new int[121];
        int[] prefix = new int[121];
            
        for (int age : ages) {
            freq[age]++;
        }
        
        for (int i = 1; i <= 120; i++) {
            prefix[i] = prefix[i - 1] + freq[i];
        }
        
        int requests = 0;
        
        for (int x = 15; x <= 120; x++) {
            if (freq[x] == 0) continue;
            
            int minAge = (x / 2) + 7 + 1;
            int maxAge = x;
            
            if (minAge > maxAge) continue;
            
            int countInRange = prefix[maxAge] - prefix[minAge - 1];
            
            requests += freq[x] * (countInRange - 1);
        }
        
        return requests;
    }
}