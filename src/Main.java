/*
 * andrius.kolenda@mif.stud.vu.lt
 * Windows: javac -d out src/*.java; java -cp out Main
 * Linux: javac -d out src/*.java && java -cp out Main
 * 
*/

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String filename = "expressions.txt";
        try {

            if (args.length == 0) {
                System.out.println("Hello! This is Expression Simplifier.");
                System.out.printf("Please specify path to file containing expressions: ");
                final Scanner scanner = new Scanner(System.in);
                filename = scanner.next();
                scanner.close();
            }

            List<String> expressions = ExpressionSimplifier.readFile(filename);
            System.out.println(Arrays.toString(expressions.toArray()));

            //String exp = "8+9 * 15-(-7/3 +7 * 8)/2+ 3 * 7";

            ExpressionSimplifier expSimlifier = new ExpressionSimplifier();
            
            expSimlifier.simplifyExpression();

            
            //System.out.println(expSimlifier.getAnswer());
        
        
        
        
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}