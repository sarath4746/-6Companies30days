class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> startSet = new HashSet<>();
        for (String word : startWords) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            startSet.add(new String(chars));
        }
        
        int cnt = 0;
        for (String target : targetWords) {
            char[] targetChars = target.toCharArray();
            Arrays.sort(targetChars);
            String sortedTarget = new String(targetChars);
            
            for (int i = 0; i < sortedTarget.length(); i++) {
                String temp = sortedTarget.substring(0, i) + sortedTarget.substring(i + 1);
                if (startSet.contains(temp)) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}