class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> comb, int k, int n, int start) {
        if (comb.size() == k && n == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (n < i) break;
            comb.add(i);
            backtrack(res, comb, k, n - i, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}