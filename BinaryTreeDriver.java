import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class BinaryTreeDriver {

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        System.out.println("Commands:\n" +
                           "  (i) - Insert Item\n" +
                           "  (d) - Delete Item\n" +
                           "  (p) - Print Tree\n" +
                           "  (s) - Search Item\n" +
                           "  (l) - Count Leaf Nodes\n" +
                           "  (sp) - Find Single Parents\n" +
                           "  (c) - Find Cousins\n" +
                           "  (q) - Quit program");
    } // main
} // BinarySearchTreeDriver
