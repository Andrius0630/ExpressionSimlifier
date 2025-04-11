public class Main{
    public static void main(String[] args) {
        try {
            //String exp = "8+9 * 15-(-7/3 +7 * 8)/2+ 3 * 7";
            String exp = "2*2";
            ExpressionSimplifier expSimlifier = new ExpressionSimplifier(exp);
        
            expSimlifier.simplifyExpression();

            System.out.println(expSimlifier.getExp());
            System.out.println(expSimlifier.getAnswer());
        
        
        
        
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}