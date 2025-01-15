class Solution {
    public boolean isValidSerialization(String preorder) {

        String[] nodes = preorder.split(",");
        int availableSlots = 1;
    
        for (String node : nodes) {
            availableSlots-- ;
            
            if (availableSlots < 0) return false ;
            
            if (!node.equals("#")) availableSlots += 2;
        }
        
        return availableSlots == 0;
    }
}