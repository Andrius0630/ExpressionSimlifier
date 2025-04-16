/**
 * andrius.kolenda@mif.stud.vu.lt
 * Purpose: Initialisation
 * 2025-04-16
 * 
 */

import java.util.LinkedList;
import java.util.List;

public class Main {
    final static String DEFAULT_OUTPUT_FILE = "out.txt";

    public static void main(String[] args) {
        List<String> expressions = null;
        List<String> solvedExpressions = null;
        ExpressionSimplifier expSimplifier = null;

        try {
            String filename = InputOutput.getFilename(args, DEFAULT_OUTPUT_FILE);
            expressions = InputOutput.readFile(filename);
            solvedExpressions = new LinkedList<>();
            expSimplifier = new ExpressionSimplifier();

            for (String exp : expressions) {
                String solvedExp = expSimplifier.simplifyExpression(exp);
                solvedExpressions.add(solvedExp);
                System.out.println(solvedExp);
            }

            InputOutput.writeToFile(DEFAULT_OUTPUT_FILE, solvedExpressions);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            expressions = null;
            solvedExpressions = null;
            expSimplifier = null;

            System.gc();
        }
    }
}