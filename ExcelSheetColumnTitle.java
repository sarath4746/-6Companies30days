class Solution {
    public String convertToTitle(int columnNumber) {
        
        int col_no = columnNumber ;

        StringBuilder sb = new StringBuilder() ;

        while (col_no > 0) {
            col_no-- ;

            int num = col_no % 26 ;
            char ch = (char)(num+'A') ;
            sb.append(ch) ;
            col_no /= 26 ;
        }

        return sb.reverse().toString() ;
    }
}