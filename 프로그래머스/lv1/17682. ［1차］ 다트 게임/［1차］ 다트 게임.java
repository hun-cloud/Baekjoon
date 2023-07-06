import java.util.Stack;
import java.util.regex.Pattern;

class Solution {
    public int solution(String dartResult) {
            Pattern intPattern = Pattern.compile("[0-9]");
            Pattern squarePattern = Pattern.compile("[S|D|T]");
            Pattern startOrAchaPattern = Pattern.compile("[*|#]");

            String[] dartResultArr = dartResult.split("");
            Stack<Integer> stack = new Stack<>();
            stack.add(1);
            for(String s : dartResultArr) {
                if (intPattern.matcher(s).matches()) {
                    if (s.equals("0")) {
                        if (stack.peek() == 1) {
                            stack.pop();
                            stack.add(10);
                        } else {
                            stack.add(0);
                        }
                    } else {
                        stack.add(Integer.parseInt(s));
                    }
                }else if (squarePattern.matcher(s).matches()) {
                    switch (s) {
                        case "S" :
                            break;
                        case "D" :
                            stack.add((int)Math.pow(stack.pop(), 2));
                            break;
                        case "T" :
                            stack.add((int)Math.pow(stack.pop(), 3));
                            break;
                        default:
                            break;
                    }
                }else if (startOrAchaPattern.matcher(s).matches()) {
                    switch (s) {
                        case "*":
                            int currentValue = stack.pop();
                            int BeforeValue = stack.pop();
                            stack.add(BeforeValue * 2);
                            stack.add(currentValue * 2);
                            break;
                        case "#":
                            stack.add(stack.pop() * -1);
                            break;
                        default:
                            break;
                    }
                }

            }


            return stack.stream().skip(1).mapToInt(Integer::intValue).sum();
    }
}