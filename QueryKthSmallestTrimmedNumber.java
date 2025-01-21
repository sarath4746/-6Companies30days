class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
      int n = nums.length;
        int m = nums[0].length();
        int q = queries.length;
        
        int[] result = new int[q];
        
        for (int i = 0; i < q; i++) {
            int k = queries[i][0];
            int trimLength = queries[i][1];
            
            List<Pair<String, Integer>> trimmedList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String trimmed = nums[j].substring(m - trimLength); 
                trimmedList.add(new Pair<>(trimmed, j)); 
            }
            
            Collections.sort(trimmedList, (a, b) -> {

                int cmp = a.getKey().compareTo(b.getKey());
                if (cmp != 0) {
                    return cmp;
                }
                return Integer.compare(a.getValue(), b.getValue());
            });
            
            result[i] = trimmedList.get(k - 1).getValue();
        }
        
        return result;
    }
    
    public static class Pair<K, V> {
        private K key;
        private V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
    }
}