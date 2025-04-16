/**
 * andrius.kolenda@mif.stud.vu.lt
 * Purpose: Main logic
 * 2025-04-16
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionSimplifier {

    private final static String BAD_EXPRESSION = "Bad expression!";

    public String simplifyExpression(String expression) throws Exception {
        String postfix = null;
        String result = null;
        try {
            postfix = convertToPostfix(expression);
            result = evaluatePostfix(postfix);
        } finally {
            postfix = null;
        }
        return result;
    }

    private static String convertToPostfix(String expression) {
        Stack<Character> operators = new Stack<>();
        List<String> output = new ArrayList<>();
        StringBuilder numberBuffer = new StringBuilder();

        if (expression.isBlank()) return null;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isLetter(ch)) return BAD_EXPRESSION;
            if (Character.isWhitespace(ch)) continue;

            if (ch == '-' && (i == 0 || expression.charAt(i - 1) == '(' || isOperator(expression.charAt(i - 1)))) {
                numberBuffer.append(ch);
                continue;
            }

            if (Character.isDigit(ch) || ch == '.') {
                numberBuffer.append(ch);
                continue;
            }

            if (numberBuffer.length() > 0) {
                output.add(numberBuffer.toString());
                numberBuffer.setLength(0);
            }

            if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.add(String.valueOf(operators.pop()));
                }
                if (!operators.isEmpty() && operators.peek() == '(') {
                    operators.pop();
                }
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && isOperator(operators.peek())
                        && precedence(operators.peek()) >= precedence(ch)) {
                    output.add(String.valueOf(operators.pop()));
                }
                operators.push(ch);
            }
        }

        if (numberBuffer.length() > 0) {
            output.add(numberBuffer.toString());
        }

        while (!operators.isEmpty()) {
            output.add(String.valueOf(operators.pop()));
        }
        numberBuffer.setLength(0);
        operators.clear();

        return String.join(" ", output);
    }

    private static String evaluatePostfix(String postfix) {
        if (postfix == null) return " ";
        if (postfix.contains(BAD_EXPRESSION)) return BAD_EXPRESSION;

        Stack<String> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        try {
            for (String token : tokens) {
                if (isNumeric(token)) {
                    stack.push(token);
                } else {
                    double b = Double.parseDouble(stack.pop());
                    double a = Double.parseDouble(stack.pop());
                    double result = switch (token) {
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "*" -> a * b;
                        case "/" -> a / b;
                        default -> throw new IllegalArgumentException("Unknown operator: " + token);
                    };
                    stack.push(Double.toString(result));
                }
            }
            return stack.pop();
        } finally {
            stack.clear();
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) return false;
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }
}
