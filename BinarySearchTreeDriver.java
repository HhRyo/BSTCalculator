import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class BinarySearchTreeDriver {

    public static void main(String[] args) {
        // code for reading file - copied from linkedlist but need to update to accomodate to BST Driver
         try {
            //initializing command
            String command = "";
            //getting txt file input
            String txt = args[0];
            File file = new File(txt);
            Scanner scan = new Scanner(file);
             //have a nodeType object ready;
            if (scan.hasNextInt()) {
                BinarySearchTree<Integer> list = new BinarySearchTree<Integer>();
                while (scan.hasNext()) {
                Nodetype node = new NodeType(scan.nextInt());
                list.insert(node);
            }
            } 
            else if (scan.hasNextDouble()){
                BinarySearchTree<Double> list = new BinarySearchTree<Double>();
                while (scan.hasNext()) {
                NodeType node = new NodeType(scan.nextInt());
                list.insert(node);
            }    
            }
            else {
                BinarySearchTree<String> list = new BinarySearchTree<String>();
                while (scan.hasNext()) {
                NodeType node = new NodeType(scan.nextInt());
                list.insert(node);
            }
            }
         }
             catch (FileNotFoundException fnf) {
            System.err.println("File not Found");
        }

        
        Scanner scan = new Scanner(System.in);

        //figure out what input type
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        String userType = scan.next();

        if(!userType.equals("i") || !userType.equals("d") || !userType.equals("s")){
            System.out.println("Invalid input.");
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

        Scanner listScan = new Scanner(System.in);
        String userInput = null;
        String inputVal = null;
        while(!userInput.equals("q")){
            userInput = listScan.next();

            // Insert
            if(userInput.equals("i")){
                System.out.print("Enter a value to insert: ");
                inputVal = listScan.next();
                if(userType.equals("i")){
                    list.insert(Integer.parseInt(inputVal));
                }
                else if(userType.equals("d")){
                    list.insert(Double.parseDouble(inputVal));
                }
                else if(userType.equals("s")){
                    list.insert(inputVal);
            }
            }

            //delete
            else if(userInput.equals("d")){
                System.out.print("Enter a value to delete: ");
                inputVal = listScan.next();
                if(userType.equals("i")){
                    list.delete(Integer.parseInt(inputVal));
                }
                else if(userType.equals("d")){
                    list.delete(Double.parseDouble(inputVal));
                }
                else if(userType.equals("s")){
                    list.delete(inputVal);
            }
            }

            else if(userInput.equals("p")){
                System.out.print("In-order: ");
                list.inOrder();
                System.out.println();
            }

            else if(userInput.equals("s")){
                 System.out.print("Enter a value to search: ");
                inputVal = listScan.next();
                boolean isTrue = false;
                if(userType.equals("i")){
                    isTrue = list.search(Integer.parseInt(inputVal));
                }
                else if(userType.equals("d")){
                    isTrue = list.search(Double.parseDouble(inputVal));
                }
                else if(userType.equals("s")){
                    isTrue = list.search(inputVal);
            }
                if(isTrue == true){
                    System.out.println("Item is found in the tree."); 
                        }
                else{
                    System.out.println("Item is not found in the tree.");
                }
            }

            else if(userInput.equals("l")){
                int leafs = list.getNumLeafNodes();
                System.out.println("Leaf count: " + leafs);
            }

            else if(userInput.equals("sp")){
                int singleParents = list.getSingleParent();
                System.out.println("Single Parents: " + singleParents);
            }

            else if(userInput.equals("c")){
                System.out.print("Enter value to find cousins: ");
                inputVal = listScan.next();
                if(userType.equals("i")){
                    list.getCousins(Integer.parseInt(inputVal));
                }
                else if(userType.equals("d")){
                    list.getCousins(Double.parseDouble(inputVal));
                }
                else if(userType.equals("s")){
                    list.getCousins(inputVal);
            }

        }

        }
    } // main
} // BinarySearchTreeDriver
