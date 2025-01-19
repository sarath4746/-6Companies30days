class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {

        List<Integer> res = new ArrayList<>();
        
        List<Integer> aPositions = new ArrayList<>();
        for (int i = 0; i <= s.length() - a.length(); i++) {
            if (s.substring(i, i + a.length()).equals(a)) {
                aPositions.add(i);
            }
        }
        
        List<Integer> bPositions = new ArrayList<>();
        for (int i = 0; i <= s.length() - b.length(); i++) {
            if (s.substring(i, i + b.length()).equals(b)) {
                bPositions.add(i);
            }
        }
        
        for (int i : aPositions) {
            for (int j : bPositions) {
                if (Math.abs(i - j) <= k) {
                    res.add(i);
                    break;
                }
            }
        }
        
        return res;
    }
}