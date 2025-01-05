import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        if (s.length() <10) return new ArrayList<>() ;
        HashMap<String, Integer> hm = new HashMap<>();
        HashSet<String> res = new HashSet<>();

        for (int i = 0 ; i <= s.length() - 10 ; i++) {
            String substr = s.substring(i , i+10) ;

            if (hm.containsKey(substr)) res.add(substr) ;
            else hm.put(substr,1) ;
        }

        return new ArrayList<>(res) ;
    }
}
