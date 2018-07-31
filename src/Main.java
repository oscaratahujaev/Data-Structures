import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Solution mySol = new Solution();

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

        mySol.performOperations(operations);


        scanner.close();
    }
}

class Solution {

    private String mainSting;

    // Append str to the end of mainString
    public void append(String str) {
        this.mainSting = this.mainSting.concat(str);
    }

    // Delete the last k characters of mainString
    public void delete(int value) {
        this.mainSting = this.mainSting.substring(0, this.mainSting.length() - value - 1);
    }

    // Print the k-th character of mainString
    public void print(int value) {
        System.out.println(this.mainSting.charAt(value));
    }

    // Undo the last operation of append and delete
    public void undo(int value) {

    }

    public void performOperations(Vector<StackNode> operations) {

        for (int i = 0; i < operations.size(); i++) {

            StackNode node = operations.get(i);
            switch (node.type) {
                case 1:
                    this.append(node.value);
                    break;
                case 2:
                    this.delete(Integer.parseInt(node.value));
                    break;
                case 3:
                    this.print(Integer.parseInt(node.value));
                    break;
                case 4:
                    this.undo(Integer.parseInt(node.value));
                    break;
            }
        }
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

