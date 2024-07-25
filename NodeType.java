public class NodeType<T extends Comparable<T>> {
public T info;
public NodeType<T> left;
public NodeType<T> right;
} // NodeType
public class BinarySearchTree<T extends Comparable<T>> {
    private NodeType<T> root;

    public BinarySearchTree() {
        this.root = null;
    } // binarySearchTree

    public void insert(T key) {

    } // insert

    public void deleteNode(T item) {

    } // deleteNode

    public void delete(T key) {

    } // delete

    public boolean search(T item) {
        throw new UnsupportedOperationException("not yet implemented");
    } // search

    public void inOrder() {

    } // inOrder

    public void getSingleParent() {

    } // getSingleParent

    public int getNumLeafNodes() {
        throw new UnsupportedOperationException("not yet implemented");
    } // getNumLeafNodes

    public T getCousins(NodeType<T> node) {
        //putting T as return type bc I assume we're returning the info of the cousin
        throw new UnsupportedOperationException("not yet implemented");
    } // getCousins

} // BinarySearchTree
