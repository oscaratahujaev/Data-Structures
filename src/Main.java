import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;


public class Main {

    // Append str to the end of mainString
    private static void append(String str) {

    }

    // Delete the last k characters of mainString
    private static void delete(int value) {

    }

    // Print the k-th character of mainString
    private void print(int value) {
        System.out.println(this.mainSting.charAt(value));
    }

    // Undo the last operation of append and delete
    private static void undo(int value) {

    }

    private static void performOperations(Vector<StackNode> operations) {

        for (int i = 0; i < operations.size(); i++) {

            StackNode node = operations.get(i);
            switch (node.type) {
                case 1:
                    append(node.value);
                    break;
                case 2:
                    delete(Integer.parseInt(node.value));
                    break;
                case 3:
                    print(Integer.parseInt(node.value));
                    break;
                case 4:
                    undo(Integer.parseInt(node.value));
                    break;
            }
        }
    }

    private String mainSting;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Vector<StackNode> operations = new Vector<StackNode>();
        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();
            String value = "";
            if (type != 4) {
                value = scanner.next();
            }
            scanner.nextLine();

            operations.add(new StackNode(type, value));
        }

        performOperations(operations);


        scanner.close();
    }
}

class StackNode {
    public int type;
    public String value;

    StackNode(int type, String value) {
        this.type = type;
        this.value = value;
    }
}