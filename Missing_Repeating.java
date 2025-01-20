class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        long sum = 0, sumOfSquares = 0;
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSumOfSquares = (long) n * (n + 1) * (2 * n + 1) / 6;
        
        for (int num : arr) {
            sum += num;
            sumOfSquares += (long) num * num;
        }
        
        long diff = expectedSum - sum;
        long squareDiff = expectedSumOfSquares - sumOfSquares;
        
        long sumAB = squareDiff / diff;
        
        int a = (int) ((diff + sumAB) / 2);
        int b = (int) (sumAB - a);
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(b);
        result.add(a);
        return result;
    }
}
