import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File in = new File(filePath);
        try (Scanner scan = new Scanner(in)) { // read file if exists
//            PrintWriter out = new PrintWriter("output.txt"); // debug
            while (scan.hasNext()) { // read file line by line

                String line = scan.nextLine();
                line = line.replaceAll(" ", ""); // remove all spaces
                if (line.length() == 0) // skip empty lines
                    continue;

                String[] operations;
                String out_line;

                if (line.contains("+")) { // add two values
                    operations = line.split("\\+");
                    LinkedList op1 = LinkedList.ParseFromString(operations[0]);
                    LinkedList op2 = LinkedList.ParseFromString(operations[1]);
                    out_line = operations[0] + " + " + operations[1] + " = " + Main.add(op1, op2);
                    System.out.println(out_line);
//                    out.println(out_line); // debug
                }
                else if (line.contains("*")) { // multiply two values
                    operations = line.split("\\*");
                    LinkedList op1 = LinkedList.ParseFromString(operations[0]);
                    LinkedList op2 = LinkedList.ParseFromString(operations[1]);
                    out_line = operations[0] + " * " + operations[1] + " = " + Main.multi(op1, op2);
                    System.out.println(out_line);
//                    out.println(out_line); // debug
                }
                else if (line.contains("^")) { // exponentiate(?!?) two values
                    operations = line.split("\\^");
                    LinkedList op1 = LinkedList.ParseFromString(operations[0]);
                    int op2 = Integer.parseInt(operations[1]);
                    out_line = operations[0] + " ^ " + operations[1] + " = " + Main.expo(op1, op2);
                    System.out.println(out_line);
//                    out.println(out_line); // debug
                }
            }
//        out.close(); // debug
        }
        catch (FileNotFoundException e) { // file not found
            System.out.println("File not found: " + in.getPath());
            throw new IllegalArgumentException("File not found: " + in.getPath());
        }
    }
}
