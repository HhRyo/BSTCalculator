import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class BinarySearchTreeDriver<T extends Comparable<T>> {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bstInt = new BinarySearchTree<>();
        BinarySearchTree<Double> bstDouble = new BinarySearchTree<>();
        BinarySearchTree<String> bstString = new BinarySearchTree<>();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter list type (i - int, d - double, s - string): ");
        String keyboardInput = keyboard.nextLine();

        try {
            File file = new File(args[0]);
            Scanner fileScan = new Scanner(file);
            if (keyboardInput.equals("i")) {
                while (fileScan.hasNextInt()) {
                    Integer info = Integer.parseInt(fileScan.next());
                    bstInt.insert(info);
                }
            } else if (keyboardInput.equals("d")) {
                while (fileScan.hasNextDouble()) {
                    Double info = Double.parseDouble(fileScan.next());
                    bstDouble.insert(info);
                }
            } else if (keyboardInput.equals("s")) {
                while (fileScan.hasNext()) {
                    String info = fileScan.next();
                    bstString.insert(info);
                }
            } else {
                System.out.println("Invalid input.");
                fileScan.close();
                keyboard.close();
                return;
            }
            fileScan.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("needs a file");
            keyboard.close();
            return;
        }

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
        while (!keyboardIn.equals("q")) {
            System.out.println("Enter a command: ");
            keyboardIn = keyboard.nextLine();
            if (keyboardInput.equals("i")) {
                intCommands(bstInt, keyboard, keyboardIn);
            } else if (keyboardInput.equals("d")) {
                doubleCommands(bstDouble, keyboard, keyboardIn);
            } else if (keyboardInput.equals("s")) {
                stringCommands(bstString, keyboard, keyboardIn);
            }
        }
        keyboard.close();
    }

    public static void intCommands(BinarySearchTree<Integer> bstInt, Scanner keyboard, String keyboardIn) {
        String inputVal;
        if (keyboardIn.equals("i")) {
            System.out.println("Original list : ");
            bstInt.inOrder();
            System.out.println("\nEnter a number to insert: ");
            inputVal = keyboard.nextLine();
            if (!bstInt.search(Integer.parseInt(inputVal))) {
                bstInt.insert(Integer.parseInt(inputVal));
            } else {
                System.out.println("Item already exists in tree.");
            }
            bstInt.inOrder();
            System.out.println();
        } else if (keyboardIn.equals("d")) {
            System.out.println("Original list : ");
            bstInt.inOrder();
            System.out.print("\nEnter a value to delete: ");
            inputVal = keyboard.nextLine();
            if (bstInt.search(Integer.parseInt(inputVal))) {
                bstInt.delete(Integer.parseInt(inputVal));
            } else {
                System.out.println("Item does not exist in tree.");
            }
            bstInt.inOrder();
            System.out.println();
        } else if (keyboardIn.equals("p")) {
            System.out.print("In-order: ");
            bstInt.inOrder();
            System.out.println();
        } else if (keyboardIn.equals("s")) {
            System.out.print("Enter a value to search: ");
            inputVal = keyboard.nextLine();
            boolean isTrue = bstInt.search(Integer.parseInt(inputVal));
            if (isTrue) {
                System.out.println("Item is found in the tree.");
            } else {
                System.out.println("Item is not found in the tree.");
            }
        } else if (keyboardIn.equals("l")) {
            int leafs = bstInt.getNumLeafNodes();
            System.out.println("Leaf count: " + leafs);
        } else if (keyboardIn.equals("sp")) {
            System.out.println("Single Parents: " + bstInt.getSingleParent());
        } else if (keyboardIn.equals("c")) {
            System.out.print("Enter a value to search: ");
            inputVal = keyboard.nextLine();
           boolean isTrue = bstInt.search(Integer.parseInt(inputVal));
            if (isTrue) {
            
                System.out.println(inputVal + " cousins: ");
                bstInt.getCousins(Integer.parseInt(inputVal));
                System.out.println();
            } else {
                System.out.println("Item is not found in the tree.");
            }
        }
    }

    public static void doubleCommands(BinarySearchTree<Double> bstDouble, Scanner keyboard, String keyboardIn) {
        String inputVal;
        if (keyboardIn.equals("i")) {
            System.out.println("Original list : ");
            bstDouble.inOrder();
            System.out.println("\nEnter a number to insert: ");
            inputVal = keyboard.nextLine();
            if (!bstDouble.search(Double.parseDouble(inputVal))) {
                bstDouble.insert(Double.parseDouble(inputVal));
            } else {
                System.out.println("Item already exists in tree.");
            }
            bstDouble.inOrder();
            System.out.println();
        } else if (keyboardIn.equals("d")) {
            System.out.println("Original list : ");
            bstDouble.inOrder();
            System.out.print("\nEnter a value to delete: ");
            inputVal = keyboard.nextLine();
            if (bstDouble.search(Double.parseDouble(inputVal))) {
                bstDouble.delete(Double.parseDouble(inputVal));
            } else {
                System.out.println("Item does not exist in tree.");
            }
            bstDouble.inOrder();
            System.out.println();
        } else if (keyboardIn.equals("p")) {
            System.out.print("In-order: ");
            bstDouble.inOrder();
            System.out.println();
        } else if (keyboardIn.equals("s")) {
            System.out.print("Enter a value to search: ");
            inputVal = keyboard.nextLine();
            boolean isTrue = bstDouble.search(Double.parseDouble(inputVal));
            if (isTrue) {
                System.out.println("Item is found in the tree.");
            } else {
                System.out.println("Item is not found in the tree.");
            }
        } else if (keyboardIn.equals("l")) {
            int leafs = bstDouble.getNumLeafNodes();
            System.out.println("Leaf count: " + leafs);
        } else if (keyboardIn.equals("sp")) {
            System.out.println("Single Parents: " + bstDouble.getSingleParent());
        } else if (keyboardIn.equals("c")) {
            System.out.print("Enter a value to search: ");
            inputVal = keyboard.nextLine();
           boolean isTrue = bstDouble.search(Double.parseDouble(inputVal));
            if (isTrue) {
            
                System.out.println(inputVal + " cousins: ");
                bstDouble.getCousins(Double.parseDouble(inputVal));
                System.out.println();
            } else {
                System.out.println("Item is not found in the tree.");
            }
        }
    }

    public static void stringCommands(BinarySearchTree<String> bstString, Scanner keyboard, String keyboardIn) {
        String inputVal;
        if (keyboardIn.equals("i")) {
            System.out.println("Original list : ");
            bstString.inOrder();
            System.out.println("\nEnter a string to insert: ");
            inputVal = keyboard.nextLine();
            if (!bstString.search(inputVal)) {
                bstString.insert(inputVal);
            } else {
                System.out.println("Item already exists in tree.");
            }
            bstString.inOrder();
            System.out.println();
        } else if (keyboardIn.equals("d")) {
            System.out.println("Original list : ");
            bstString.inOrder();
            System.out.print("\nEnter a value to delete: ");
            inputVal = keyboard.nextLine();
            if (bstString.search(inputVal)) {
                bstString.delete(inputVal);
            } else {
                System.out.println("Item does not exist in tree.");
            }
            bstString.inOrder();
            System.out.println();
        } else if (keyboardIn.equals("p")) {
            System.out.print("In-order: ");
            bstString.inOrder();
            System.out.println();
        } else if (keyboardIn.equals("s")) {
            System.out.print("Enter a value to search: ");
            inputVal = keyboard.nextLine();
            boolean isTrue = bstString.search(inputVal);
            if (isTrue) {
                System.out.println("Item is found in the tree.");
            } else {
                System.out.println("Item is not found in the tree.");
            }
        } else if (keyboardIn.equals("l")) {
            int leafs = bstString.getNumLeafNodes();
            System.out.println("Leaf count: " + leafs);
        } else if (keyboardIn.equals("sp")) {
            System.out.println("Single Parents: " + bstString.getSingleParent());
        } else if (keyboardIn.equals("c")) {
           System.out.print("Enter a value to search: ");
            inputVal = keyboard.nextLine();
            boolean isTrue = bstString.search(inputVal);
            if (isTrue) {
            
                System.out.println(inputVal + " cousins: ");
                bstString.getCousins(inputVal);
                System.out.println();
            } else {
                System.out.println("Item is not found in the tree.");
            }
        }
    }
}
