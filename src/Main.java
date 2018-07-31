import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;


public class Main {

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
        Solution mySol = new Solution(operations);
        mySol.performOperations();

        scanner.close();
    }
}

class Solution {

    private String mainSting;
    private Vector<StackNode> operations;
    private Stack<StackNode> undoOperations;

    Solution(Vector<StackNode> operations) {
        this.operations = operations;
        this.undoOperations = new Stack<StackNode>();
    }

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
    public void undo(int value, int operationIndex) {
        StackNode node = this.operations.get(operationIndex);

        if (node.type == 1) {
            // undo operation of append of string
            this.delete(node.value.length());


        } else if (node.type == 2) {


            // undo operation of delete
            String deletedString = this.undoOperations.peek()
            this.delete(node.value.length());
        }

    }

    public void performOperations() {

        for (int i = 0; i < this.operations.size(); i++) {

            StackNode node = this.operations.get(i);

            switch (node.type) {
                case 1:
                    this.append(node.value);
                    undoOperations.push(i);
                    break;
                case 2:
                    this.delete(Integer.parseInt(node.value));
                    undoOperations.push(new StackNode(i, node.value));
                    break;
                case 3:
                    this.print(Integer.parseInt(node.value));
                    break;
                case 4:
                    int operationIndex = undoOperations.pop().type;
                    this.undo(Integer.parseInt(node.value), operationIndex);
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

