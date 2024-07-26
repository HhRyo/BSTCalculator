public class BinarySearchTree<T extends Comparable<T>> {
    private NodeType<T> root;

    public BinarySearchTree() {
        this.root = null;
        this.left = null;
        this.right = null;
    } // binarySearchTree

    public void insert(T key) {

    } // insert

    public void delete(T key) {

    } // delete

    
    //work on this shit first. done af.
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
    }

    //second urk. we got this hold on the cockroach will leave soon I swear. Just pray queen.
    public void inOrder() {
        while(root.info != null){
            inOrder(root.left);
            System.out.print(root.info + " ");
            inOrder(root.right);
        }
    } // inOrder

    //THE FUCKING COCKROACH DISAPPEARED AH HELLLL NAW WE ARE GOING UPSTAIRS AND FINISHING THIS ON THE SOFA
    public void getSingleParent() {
        int counter = 0; //push this out because it'll make it confusing
        while (root != null){
            if(root.isSingleParent()){
                System.out.print(root.info + "  ");
                counter++;
            }
            getSingleParent(root.left);
            getSingleParent(root.right);
            if(counter == 0){
                System.out.print("None.");
                return null;
        }
            else{
                return counter;
            }
    } // getSingleParent

   // need to make an another function for getSingleParent because it won't work on its own

    // this sofa feels comfortable for once.
    public int getNumLeafNodes() {
        int leafCount = 0;  //another one to push out
        while (root != null){
            if(root.isLeafNode()){
                leafCount++;
            }
            getSingleParent(root.left);
            getSingleParent(root.right);
    } // getNumLeafNodes

    //another one that cannot work on its own

    public T getCousins(NodeType<T> node) {
        //putting T as return type bc I assume we're returning the info of the cousin //yeah def
    } // getCousins

} // BinarySearchTree
