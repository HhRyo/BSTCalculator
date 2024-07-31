import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class BinarySearchTreeDriver {

    public static void main(String[] args) {
        // code for reading file - copied from linkedlist but need to update to accomodate to BST Driver
        try {
            String txt = args[0];
            File file = new File(txt);
            Scanner scan = new Scanner(file);
            Scanner input = new Scanner(System.in);
            System.out.println("Enter list type (i - int, d - double, s - string): ");
            String userType = input.next();
            /*            if(!userType.equals("i") || !userType.equals("d") || !userType.equals("s")){
                System.out.println("Invalid input.");
                return;
                } // if */

            System.out.println("Commands:\n" +
                               "  (i) - Insert Item\n" +
                               "  (d) - Delete Item\n" +
                               "  (p) - Print Tree\n" +
                               "  (s) - Search Item\n" +
                               "  (l) - Count Leaf Nodes\n" +
                               "  (sp) - Find Single Parents\n" +
                               "  (c) - Find Cousins\n" +
                               "  (q) - Quit program");

            if (scan.hasNextInt()) {
                BinarySearchTree<Integer> list = new BinarySearchTree<Integer>();
                while (scan.hasNext()) {
                    list.insert(scan.nextInt());
                } // while
                commandInt(list);
            } // if
            else if (scan.hasNextDouble()){
                BinarySearchTree<Double> list = new BinarySearchTree<Double>();
                while (scan.hasNext()) {
                    list.insert(scan.nextDouble());
                } // while
                commandDouble(list);
            } // else
            else {
                BinarySearchTree<String> list = new BinarySearchTree<String>();
                while (scan.hasNext()) {
                    list.insert(scan.next());
                } // while
                commandString(list);
            } // else
        } // try
        catch (FileNotFoundException fnf) {
            System.err.println("File not Found");
        } // catch
    } // main

    public static void commandInt(BinarySearchTree<Integer> list) {
        Scanner listScan = new Scanner(System.in);
        String userInput = "";
        String inputVal = "";
        while(!userInput.equals("q")){
            System.out.println("Enter a command: ");
            userInput = listScan.next();
            // Insert
            if(userInput.equals("i")){
                System.out.println("Enter a value to insert: ");
                isTrue = list.search(Integer.parseInt(inputVal));
                if(list.search(inputVal) == true){
                    System.out.println("The item already exists in the tree.");
                }
                else{
                     list.insert(Integer.parseInt(inputVal));
                }
                System.out.print("In-order: ");
                list.inOrder();
                System.out.println();
            } // if - insert
            else if(userInput.equals("d")){
                System.out.print("Enter a value to delete: ");
                inputVal = listScan.next();
                list.delete(Integer.parseInt(inputVal));
            } // else if - delete
            else if(userInput.equals("p")){
                System.out.print("In-order: ");
                list.inOrder();
                System.out.println();
            } // else if
            else if(userInput.equals("s")){
                System.out.print("Enter a value to search: ");
                inputVal = listScan.next();
                boolean isTrue = false;
                isTrue = list.search(Integer.parseInt(inputVal));
                if(isTrue == true){
                    System.out.println("Item is found in the tree.");
                } // if
                else{
                    System.out.println("Item is not found in the tree.");
                } // else
            } // else if

            else if(userInput.equals("l")){
                int leafs = list.getNumLeafNodes();
                System.out.println("Leaf count: " + leafs);
            } // else if

            else if(userInput.equals("sp")){
                System.out.println("Single Parents: " );
                list.getSingleParent();
            } // else if

            else if(userInput.equals("c")){
                System.out.print("Enter value to find cousins: ");
                inputVal = listScan.next();
                NodeType<Integer> node = new NodeType<>(Integer.parseInt(inputVal));
                list.getCousins(node);
            } // else if
        } // while
    } // commandInt

    public static void commandDouble(BinarySearchTree<Double> list) {
        Scanner listScan = new Scanner(System.in);
        String userInput = "";
        String inputVal = "";
        while(!userInput.equals("q")){
            System.out.println("Enter a command: ");
            userInput = listScan.next();
            // Insert
            if(userInput.equals("i")){
                System.out.print("In-order: ");
                list.inOrder();
                System.out.println();
                System.out.println("Enter a value to insert: ");
                inputVal = listScan.next();
                list.insert(Double.parseDouble(inputVal));
                System.out.print("In-order: ");
                list.inOrder();
                System.out.println();
            } // if - insert
            else if(userInput.equals("d")){
                System.out.print("Enter a value to delete: ");
                inputVal = listScan.next();
                list.delete(Double.parseDouble(inputVal));
            } // else if - delete
            else if(userInput.equals("p")){
                System.out.print("In-order: ");
                list.inOrder();
                System.out.println();
            } // else if
            else if(userInput.equals("s")){
                System.out.print("Enter a value to search: ");
                inputVal = listScan.next();
                boolean isTrue = false;
                isTrue = list.search(Double.parseDouble(inputVal));
                if(isTrue == true){
                    System.out.println("Item is present in the tree.");
                } // if
                else{
                    System.out.println("Item is not present in the tree.");
                } // else
            } // else if

            else if(userInput.equals("l")){
                int leafs = list.getNumLeafNodes();
                System.out.println("Leaf count: " + leafs);
            } // else if

            else if(userInput.equals("sp")){
                //                int singleParents = list.getSingleParent();
                System.out.println("Single Parents: " );
                list.getSingleParent();
            } // else if

            else if(userInput.equals("c")){
                System.out.print("Enter value to find cousins: ");
                inputVal = listScan.next();
                NodeType<Double> node = new NodeType<Double>(Double.parseDouble(inputVal));
                list.getCousins(node);
            } // else if
        } // while
    } // commandDouble

    public static void commandString(BinarySearchTree<String> list) {
        Scanner listScan = new Scanner(System.in);
        String userInput = "";
        String inputVal = "";
        while(!userInput.equals("q")){
            System.out.println("Enter a command: ");
            userInput = listScan.next();
            // Insert
            if(userInput.equals("i")){
                System.out.print("In-order: ");
                list.inOrder();
                System.out.println();
                System.out.println("Enter a value to insert: ");
                inputVal = listScan.next();
                boolean isTrue = list.search(inputVal);
                if(isTrue == true){
                    System.out.println("The item already exists in the tree.");
                }
                else{
                    list.insert(inputVal);
                }
                System.out.print("In-order: ");
                list.inOrder();
                System.out.println();
            } // if - insert
            else if(userInput.equals("d")){
                System.out.print("Enter a value to delete: ");
                inputVal = listScan.next();
                list.delete(inputVal);
            } // else if - delete
            else if(userInput.equals("p")){
                System.out.print("In-order: ");
                list.inOrder();
                System.out.println();
            } // else if
            else if(userInput.equals("s")){
                System.out.print("Enter a value to search: ");
                inputVal = listScan.next();
                boolean isTrue = false;
                isTrue = list.search(inputVal);
                if(isTrue == true){
                    System.out.println("Item is found in the tree.");
                } // if
                else{
                    System.out.println("Item is not found in the tree.");
                } // else
            } // else if

            else if(userInput.equals("l")){
                int leafs = list.getNumLeafNodes();
                System.out.println("Leaf count: " + leafs);
            } // else if

            else if(userInput.equals("sp")){
                System.out.println("Single Parents: " );
                list.getSingleParent();
            } // else if

            else if(userInput.equals("c")){
                System.out.print("Enter value to find cousins: ");
                inputVal = listScan.next();
                NodeType<String> node = new NodeType<>(inputVal);
                list.getCousins(node);
            } // if
        } // while
    } // commandString
} // BinarySearchTreeDriver
