//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        StringBuilder res = new StringBuilder();
        Stack<Integer> stk = new java.util.Stack<>();

        int num = 1;

        for (char c : S.toCharArray()) {
            stk.push(num++);

            if (c == 'I') {
                while (!stk.isEmpty()) {
                    res.append(stk.pop());
                }
            }
        }

        stk.push(num);

        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }

        return res.toString();
    }
}
