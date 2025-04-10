public class ExpressionSimplifier {
    String exp;
    double answer;

    public double getAnswer() {
        return answer;
    }

    public ExpressionSimplifier() {
        init();
    }
    
    public ExpressionSimplifier(String exp) {
        init();
        setExp(exp);
    }

    private void init() {
        this.exp = "";
        this.answer = 0;
    }
    
    private static String removeSpaces(String exp) {
        return exp.replaceAll("\\s+", "");
    }

    public final String getExp() {
        return exp;
    }

    public final void setExp(String exp) {
        this.exp = exp;
    }

    public void simpilfyExpression() throws Exception{
        if (exp.isBlank()) 
            throw new Exception("No expression specified!"); 
        exp = removeSpaces(exp);

        for (int i = 0; i < exp.length(); i++) {
            char currChar = exp.charAt(i);

            if (Character.isDigit(currChar)) {
                StringBuilder numberBuilder = new StringBuilder();
                numberBuilder.append(currChar);

                while (i + 1 < exp.length() && Character.isDigit(exp.charAt(i + 1))) {
                    numberBuilder.append(exp.charAt(++i));
                }

                int number = Integer.parseInt(numberBuilder.toString());
                answer += number;
            // } else {
            //     switch (currChar) {
            //         case '+' -> {
                        
            //         }
            //         case '-' -> {
                        
            //         }
            //         case '*' -> {
                        
            //         }
            //         case '/' -> {
                        
            //         }
    
                    
    
            //     }
            // }
        }
    }
}
