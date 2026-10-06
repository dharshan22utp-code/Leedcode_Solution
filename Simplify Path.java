class Solution {
    public String simplifyPath(String path) {
        java.util.Deque<String> stack = new java.util.ArrayDeque<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.equals(".") && !part.isEmpty()) {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.insert(0, "/" + dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}
