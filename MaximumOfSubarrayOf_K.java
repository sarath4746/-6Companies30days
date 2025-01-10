// User function template for JAVA

class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        // Your code here
        ArrayList<Integer> maxWindows = new ArrayList<>();
        Deque<Integer> indices = new LinkedList<>();
        
        for (int i = 0; i < k; i++) {
            while (!indices.isEmpty() && arr[indices.peekLast()] <= arr[i]) {
                indices.pollLast();
            }
            indices.offerLast(i);
        }

        maxWindows.add(arr[indices.peekFirst()]);

        for (int i = k; i < arr.length; i++) {
            
            while (!indices.isEmpty() && indices.peekFirst() <= i - k) {
                indices.pollFirst();
            }
            
            while (!indices.isEmpty() && arr[indices.peekLast()] <= arr[i]) {
                indices.pollLast();
            }
            
            indices.offerLast(i);
            maxWindows.add(arr[indices.peekFirst()]);
        }
        
        return maxWindows;

    }
}