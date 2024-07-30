public class BinarySearchTree<T extends Comparable<T>> {
    private NodeType<T> root;

    public BinarySearchTree() {
        this.root = null;
        this.root.left = null;
        this.root.right = null;
    } // binarySearchTree

    public void insert(T key) {
        root = insertAuxiliary(root, key);
    } // insert

    private NodeType<T> insertAuxiliary(NodeType<T> node, T key) {
        if (node == null) {
            node = new NodeType<>(key);
            return node;
        } // if
        if (key.compareTo(node.info) < 0) {
            node.left = insertAuxiliary(node.left, key);
        } else if (key.compareTo(node.info) > 0) {
            node.right = insertAuxiliary(node.right, key);
        } // else if
        return node;
    } // insertAuxiliary


    public void delete(T key) {

    } // delete

    
    public boolean search(T item) {
        return searchRecursive(root, item);
    } // search

    private boolean searchRecursive(NodeType<T> root, T item){
        int positionTracker = 0;
        while(root != null){
            positionTracker = item.compareTo(root.info);
            while(positionTracker != 0){
                if(positionTracker > 0){
                    searchRecursive(root.right, item);
                }
                else if (positionTracker < 0){
                    searchRecursive(root.left, item);
                }
            }
            if (positionTracker == 0){
                return true;
            }
        }
    } // searchRecursive

    public void inOrder() {
        printInOrder(root);
    } // inOrder

    public void printInOrder(NodeType<T> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.info);
            printInOrder(node.right);
        } // if
    } // printInOrder


    public void getSingleParent() {
        int counter = null;
        if (singleParentRecursive(root, counter) == null){
            System.out.println("None");
        }
    } // getSingleParent

    private void singleParentRecursive(NodeType<T> root, int counter){
         while (root != null){
            if(root.isSingleParent()){
                System.out.print(root.info + "  ");
                counter++;
            } // if
            singleParentRecursive(root.left, counter);
            singleParentRecursive(root.right, counter);
            if(counter == 0){
                System.out.print("None.");
            } // if    
         } // while
    } // singleParentRecursive

    public int getNumLeafNodes() {
        int leafCount = 0;  //another one to push out
        leafRecursive(root, leafCount);
    } // getNumLeafNodes

    private void leafRecursive(NodeType<T> root, int leafCount){
         while (root != null){
            if(root.isLeafNode()){
                leafCount++;
            }
            leafRecursive(root.left, leafCount);
            leafRecursive(root.right, leafCount); 
        }
    } // leafRecursive


    public T getCousins(NodeType<T> node) {
        //putting T as return type bc I assume we're returning the info of the cousin //yeah def
    } // getCousins

} // BinarySearchTree
