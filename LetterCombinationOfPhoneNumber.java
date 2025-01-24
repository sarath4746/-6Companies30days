class Solution {
    private static final String[] MAP = {
        "",    
        "",    
        "abc", 
        "def", 
        "ghi", 
        "jkl", 
        "mno", 
        "pqrs",
        "tuv", 
        "wxyz" 
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        backtrack(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder curr, String digits, int idx) {
        if (idx == digits.length()) {
            res.add(curr.toString());
            return;
        }

        String letters = MAP[digits.charAt(idx) - '0'];
        for (char ch : letters.toCharArray()) {
            curr.append(ch);
            backtrack(res, curr, digits, idx + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}