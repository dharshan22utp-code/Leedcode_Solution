import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push the corresponding closing bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket, check if stack is empty or top doesn't match
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        
        // If stack is empty, all opening brackets were closed correctly
        return stack.isEmpty();
    }
}
