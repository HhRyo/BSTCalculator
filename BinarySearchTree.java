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
        if (root == null) {
            return false;
        }
            if(root.info.compareTo(item) > 0){
                searchRecursive(root.right, item);
            } // if
            else if (root.info.compareTo(item) < 0){
                searchRecursive(root.left, item);
            } // else if
            return true;
    } // searchRecursive


    public void inOrder() {
        printInOrder(root);
    } // inOrder

    public void printInOrder(NodeType<T> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.info + " ");
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

// get Cousins methods 
    public void getCousins(NodeType<T> node) {
    if (root == null || node == null) {
        System.out.println("No cousins found.");
        return;
    }

    int level = findHeight(root, node.info, 1);

    if (level <= 2) {
        System.out.println("No cousins exist for this node.");
        return;
    }

    printCousins(root, node, level);
}

private int findHeight(NodeType<T> currentNode, T key, int level) {
    if (currentNode == null) {
        return 0;
    }
    if (currentNode.info.compareTo(key) == 0) {
        return level;
    }

    int downLevel = findHeight(currentNode.left, key, level + 1);
    if (downLevel != 0) {
        return downLevel;
    }

    return findHeight(currentNode.right, key, level + 1);
}

private void printCousins(NodeType<T> currentNode, NodeType<T> node, int height) {
    if (currentNode == null || height < 2) {
        return;
    }

    if (height == 2) {
        if ((currentNode.left == node) || (currentNode.right == node)) {
            return;
        }
        if (currentNode.left != null) {
            System.out.print(currentNode.left.info + " ");
        }
        if (currentNode.right != null) {
            System.out.print(currentNode.right.info + " ");
        }
    } else {
        printCousins(currentNode.left, node, height - 1);
        printCousins(currentNode.right, node, height - 1);
    }
}

} // BinarySearchTree
