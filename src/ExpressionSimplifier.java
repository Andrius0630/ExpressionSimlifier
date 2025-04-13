import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ExpressionSimplifier {
    double answer;

    public double getAnswer() {
        return answer;
    }

    public ExpressionSimplifier() {
        init();
    }

    private void init() {
        this.answer = 0;
    }
    
    // private static String removeSpaces(String exp) {
    //     return exp.replaceAll("\\s+", "");
    // }



    /*
        Priority values:
            '+-' - 0
            '*\/' - 1
            '(+-)' - 2
            '(*\/)' - 3
    */
    public void simplifyExpression() throws Exception {
        String exp = "3+1*2";
        String postFixExp = convertToPostfix(exp);

        System.out.println(postFixExp);


        // if (Character.isDigit(exp.charAt(i))) {
        //     numbersInExpression.add(new Number(exp.charAt(i), priority));
        //     System.out.println("Added");
        // }
    }

    private static String convertToPostfix(String expression) {
        Stack<Character> operators = new Stack<>();
        List<String> output = new ArrayList<>();

        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);

        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isWhitespace(ch)) continue;

            if (Character.isDigit(ch)) {
                numberBuffer.append(ch);
                // Check if the next character ends the number
                if (i == expression.length() - 1 || !Character.isDigit(expression.charAt(i + 1))) {
                    output.add(numberBuffer.toString());
                    numberBuffer.setLength(0);
                }
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.add(String.valueOf(operators.pop()));
                }
                operators.pop(); // pop '('
            } else if (precedence.containsKey(ch)) {
                while (!operators.isEmpty() &&
                       operators.peek() != '(' &&
                       precedence.get(operators.peek()) >= precedence.get(ch)) {
                    output.add(String.valueOf(operators.pop()));
                }
                operators.push(ch);
            }
        }

        // Flush remaining operators
        while (!operators.isEmpty()) {
            output.add(String.valueOf(operators.pop()));
        }
        
        return String.join(" ", output);
    }

    // if (Character.isDigit(currChar)) {
    //     StringBuilder numberBuilder = new StringBuilder();
    //     numberBuilder.append(currChar);
        

    //     while (i + 1 < exp.length() && Character.isDigit(exp.charAt(i + 1))) {
    //         i++;
    //         currChar = exp.charAt(i);
    //         numberBuilder.append(currChar);
    //     }
    //     prevNumber = number;
    //     number = Integer.parseInt(numberBuilder.toString());
    //     System.out.println(number);
    //     continue;
    // }
}
