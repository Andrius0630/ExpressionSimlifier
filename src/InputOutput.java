/**
 * andrius.kolenda@mif.stud.vu.lt
 * Purpose: Input and Output operations
 * 2025-04-16
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.naming.InvalidNameException;

public class InputOutput {

    public static List<String> readFile(String filename) throws Exception {
        List<String> expressions = new ArrayList<>();
        Scanner reader = null;

        try {
            File file = new File(filename);
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                expressions.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File \"%s\" not found!\n", filename);
            System.exit(1);
        } finally {
            if (reader != null) reader.close();
        }

        return expressions;
    }

    public static void writeToFile(String filename, List<String> lines) throws Exception {
        FileWriter writer = null;

        try {
            writer = new FileWriter(filename);
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        } finally {
            if (writer != null) writer.close();
        }
    }

    public static String getFilename(String[] args, String defaultOutput) throws Exception {
        if (args.length == 0) {
            System.out.println("Hello! This is Expression Simplifier.");
            System.out.printf("Expressions should be read from file and answers should be written to the \"%s\" file.\n", defaultOutput);
            System.out.print("Please specify path to file containing expressions: ");
    
            // try-with-resources ensures scanner is closed automatically
            try (Scanner scanner = new Scanner(System.in)) {
                String input = scanner.nextLine().trim();
                if (input.isBlank()) throw new InvalidNameException("Filename is empty!");
                return input;
            } catch (InvalidNameException ine) {
                throw ine;
            } catch (Exception e) {
                throw new Exception("An error occurred!");
            }
        } else {
            return args[0];
        }
    }
    
}
