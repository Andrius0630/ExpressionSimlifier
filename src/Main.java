/*
 * andrius.kolenda@mif.stud.vu.lt
 * Windows: javac -d out src/*.java; java -cp out Main
 * Linux: javac -d out src/*.java && java -cp out Main
 * 
*/

public class Main{
    public static void main(String[] args) {
        try {
            //String exp = "8+9 * 15-(-7/3 +7 * 8)/2+ 3 * 7";

            ExpressionSimplifier expSimlifier = new ExpressionSimplifier();
            
            expSimlifier.simplifyExpression();

            
            //System.out.println(expSimlifier.getAnswer());
        
        
        
        
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}