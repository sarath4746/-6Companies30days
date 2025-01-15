class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm = new HashMap<>() ;

        for (char c : s.toCharArray()) {
            hm.put(c , hm.getOrDefault(c,0)+1) ;
        }

        List<Map.Entry<Character,Integer>> lst = new ArrayList<>(hm.entrySet()) ;
        lst.sort( (a,b) -> b.getValue() - a.getValue()) ;

        StringBuilder sb = new StringBuilder() ;

        for (Map.Entry<Character,Integer> entry : lst) {
            int cnt = entry.getValue() ;
            while ( cnt--> 0 ) {
                sb.append(entry.getKey()) ;
            }
        }

        return sb.toString() ;
    }
}