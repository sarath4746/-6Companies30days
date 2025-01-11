class Solution {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        
        Node current = head ;
        
        while (current != null) {
            
            for (int i = 1 ; (i < m && current != null ) ; i++ ) {
                current = current.next ;
            }
            
            
            
            if (current == null) return ;
            
            Node temp = current.next ;
            
            for (int i = 1 ; (i <= n && temp != null ) ; i++ ) {
                temp = temp.next ;
            }
            
            current.next = temp ;
            
            current = temp ;
        }
    }
}