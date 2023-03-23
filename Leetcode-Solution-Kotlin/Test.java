import java.util.Stack;

class Test {
    static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if ((c == ')' || c == '}') && st.isEmpty()) return "false";
            else if ((c == ')' && st.peek() != '(') || (c == '}' && st.peek() != '{')) return "false";
            else if ((c == ')' && st.peek() == '(') || (c == '}' && st.peek() == '{')) {
                st.pop();
            } else if (c == '{' || c == '(') {
                st.add(c);
            }
        }
        String ans = (st.isEmpty()) ? "true" : "false";
        return ans;
    }

}

//