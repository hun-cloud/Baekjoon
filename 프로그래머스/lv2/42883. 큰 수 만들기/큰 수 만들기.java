import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public String solution(String number, int k) {

            Stack<Character> stack = new Stack<>();
            char[] chars = number.toCharArray();

            for (char c : chars) {
                if (stack.isEmpty() || k == 0) {
                    stack.push(c);
                } else {
                    if (stack.peek() >= c) {
                        stack.push(c);
                    } else {
                        while (true) {
                            if (stack.isEmpty()) {
                                stack.push(c);
                                break;
                            } else {
                                if (stack.peek() >= c) {
                                    stack.push(c);
                                    break;
                                }
                                if (k == 0) {
                                    break;
                                }
                                stack.pop();
                                k--;
                                if (k == 0) {
                                    stack.push(c);
                                    break;
                                }
                            }
                        }
                    }
                }

            }
            for (int i = 0; i < k; i++) {
                stack.pop();
            }
            return stack.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}