import java.util.LinkedList;
public class BinarySearchTree<T extends Comparable<T>> {
    private NodeType<T> root;

    public BinarySearchTree() {
        this.root = null;
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
        }
        return node;
    } // insertAuxiliary


    public void delete(T key) {
        root = deleteAuxiliary(root, key);
    } // delete

    public NodeType<T> deleteAuxiliary(NodeType<T> root, T key) {
        NodeType<T> curr = root;
        if (curr == null) {
            return curr;
        }
        if (curr.info.compareTo(key) > 0) {
            curr.left = deleteAuxiliary(curr.left, key);
        } else if (curr.info.compareTo(key) < 0) {
            curr.right = deleteAuxiliary(curr.right, key);
        } else {
            if (curr.left == null && curr.right == null) {
                curr = null;
            } else if (curr.right == null) {
                curr = curr.left;
                return curr;
            } else if (curr.left == null) {
                curr = curr.right;
                return curr;
            } else {
                NodeType<T> temp = findMinRight(curr.right);
                curr.info = temp.info;
                curr.right = deleteAuxiliary(curr.right, temp.info);
            }
        }
        return curr;
    } // deleteAuxiliary

    public NodeType<T> findMinRight(NodeType<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    } // findMinRight


    public boolean search(T item) {
        return searchRecursive(root, item);
    } // search

    private boolean searchRecursive(NodeType<T> root, T item){
        if (root == null) {
            return false;
        } else if (root.info.compareTo(item) == 0) {
            return true;
        } else if (root.info.compareTo(item) < 0) {
            return searchRecursive(root.right, item);
        }
        return searchRecursive(root.left, item);
    } // searchRecursive


    public void inOrder() {
        printInOrder(root);
    } // inOrder

    public void printInOrder(NodeType<T> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.info + " ");
            printInOrder(node.right);
        }
    } // printInOrder


    public void getSingleParent() {
        LinkedList<T> sp = new LinkedList<T>(singleParentRecursive(root));

        for (int i = 0; i < sp.size(); i++) {
            System.out.print(sp.get(i) + " ");
        }

        if (sp.isEmpty()) {
            System.out.print(" None");
        }
    } // getSingleParent

    private LinkedList<T> singleParentRecursive(NodeType<T> root) {
        LinkedList<T> temp = new LinkedList<>();
        if (root != null) {
            if (root.left == null && root.right != null) {
                temp.add(root.info);
            } else if (root.left != null && root.right == null) {
                temp.add(root.info);
            }
            temp.addAll(singleParentRecursive(root.left));
            temp.addAll(singleParentRecursive(root.right));
        }
        return temp;
    } // singleParentRecursive

    public int getNumLeafNodes() {
        return leafRecursive(root);
    }

    public int leafRecursive(NodeType<T> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafRecursive(root.left) + leafRecursive(root.right);
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
