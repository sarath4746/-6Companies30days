class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x_closest = Math.max(x1,Math.min(x2,xCenter)) ; 
        int y_closest = Math.max(y1,Math.min(y2,yCenter)) ;

        int distance = ((xCenter - x_closest)*(xCenter - x_closest) )+ ((yCenter - y_closest)*(yCenter - y_closest)) ;

        return distance <= radius*radius ;
    } 

}