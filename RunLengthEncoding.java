class Solution {
    public static String encode(String s) {
        // code here
        StringBuilder result = new StringBuilder();
        int count = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        
        result.append(s.charAt(s.length() - 1)).append(count);
        
        return result.toString();
    }
}
    