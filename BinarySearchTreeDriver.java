import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class BinarySearchTreeDriver<T extends Comparable<T>> {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bstInt = new BinarySearchTree<>();
        BinarySearchTree<Double> bstDouble = new BinarySearchTree<Double>();
        BinarySearchTree<String> bstString  = new BinarySearchTree<String>();
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        Scanner keyboard = new Scanner(System.in);
        String keyboardInput = keyboard.nextLine();
        try {
            File file = new File(args[0]);
            Scanner fileScan = new Scanner(file);
            if (keyboardInput.equals("i")) {
                while (fileScan.hasNextInt()) {
                    Integer info = Integer.parseInt(fileScan.next());
                    bstInt.insert(info);
                } // while - integer
            } else if (keyboardInput.equals("d")) {
                while (fileScan.hasNextDouble()) {
                    Double info = Double.parseDouble(fileScan.next());
                    bstDouble.insert(info);
                } // while - double
            } else if (keyboardInput.equals("s")) {
                while(fileScan.hasNext()) {
                    String info = fileScan.next();
                    bstString.insert(info);
                } // while - string
            } else {
                System.out.println("Invalid input.");
                fileScan.close();
                return;
            } // else
            fileScan.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("needs a file");
            keyboard.close();
            return;
        } // catch

        System.out.println("Commands:\n" +
                           "  (i) - Insert Item\n" +
                           "  (d) - Delete Item\n" +
                           "  (p) - Print Tree\n" +
                           "  (s) - Search Item\n" +
                           "  (l) - Count Leaf Nodes\n" +
                           "  (sp) - Find Single Parents\n" +
                           "  (c) - Find Cousins\n" +
                           "  (q) - Quit program");
        String keyboardIn = "";
        String inputVal;
        while (!keyboardIn.equals("q")) {
            System.out.println("Enter a command: ");
            keyboardIn = keyboard.nextLine();
            //FIX DUPLICATE VALUES & VALUES THAT DON'T EXIST!!!!!!!!!!!!!!
            if (keyboardIn.equals("i")) {
                System.out.println("Original list : ");
                bstInt.inOrder();
                System.out.println("\nEnter a number to insert: ");
                inputVal = keyboard.nextLine();
                bstInt.insert(Integer.parseInt(inputVal));
                bstInt.inOrder();
                System.out.println();
            } // insert
            else if (keyboardIn.equals("d")) {
                System.out.println("Original list : ");
                bstInt.inOrder();
                System.out.print("\nEnter a value to delete: ");
                inputVal = keyboard.nextLine();
                bstInt.delete(Integer.parseInt(inputVal));
                bstInt.inOrder();
                System.out.println();
            } // delete
            else if (keyboardIn.equals("p")) {
                System.out.print("In-order: ");
                bstInt.inOrder();
                System.out.println();
            } // print
            else if (keyboardIn.equals("s")) {
                System.out.print("Enter a value to search: ");
                inputVal = keyboard.nextLine();
                boolean isTrue = false;
                isTrue = bstInt.search(Integer.parseInt(inputVal));
                if(isTrue == true){
                    System.out.println("Item is found in the tree.");
                } // if
                else{
                    System.out.println("Item is not found in the tree.");
                } // else
            } // search
            else if (keyboardIn.equals("l")) {
                int leafs = bstInt.getNumLeafNodes();
                System.out.println("Leaf count: " + leafs);
            } // count leaf
            else if (keyboardIn.equals("sp")) {
                System.out.println("Single Parents: " + bstInt.getSingleParent());
            } // single parent
            else if (keyboardIn.equals("c")) {

            } // cousins
        } // while
    } // main
