class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> seen = new HashSet<String>() ;

        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                char num = board[i][j] ;

                if (num != '.') {

                    String rowKey = "number " + num + " row " + i ;
                    String colKey = "number " + num + " col " + j ;
                    String boxKey = "number " + num + " box " + (i/3) + (j/3) ;


                    if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                        return false ;
                    }

                    seen.add(rowKey) ;
                    seen.add(colKey) ;
                    seen.add(boxKey) ;
                }

            }
        }

        return true ;
    }
}