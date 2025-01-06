class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        HashMap<List<Integer> , Integer> dp = new HashMap<>() ;

        return helper(price , special , needs , dp) ;
    }

    public int helper (List<Integer> price , List<List<Integer>> special , List<Integer> needs , Map<List<Integer>,Integer> dp) {

        if (dp.containsKey(needs)) return dp.get(needs) ;

        int cst = 0 ;

        for (int i = 0 ;i < needs.size() ; i++) {
            cst += needs.get(i)*price.get(i) ;
        }

        for (List<Integer> sp : special) {
            List<Integer> cpy = new ArrayList<>() ;
            boolean flag = true ;
            for (int i = 0; i < sp.size() - 1 ; i++) {
                if ( needs.get(i) - sp.get(i) >= 0) {
                    cpy.add(needs.get(i) - sp.get(i)) ;
                } else {
                    flag = false ;
                    break ;
                }
            }

            if (!flag)
                continue ;
                cst = Math.min( cst , sp.get(sp.size() - 1) + helper(price , special , cpy , dp))  ;
        }
        dp.put(needs , cst) ;
        return cst ;
    }
}