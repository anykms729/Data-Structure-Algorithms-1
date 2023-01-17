// 1) Tree Data Structure: Non-linear Data Structure
// 2) Root or Parent (No incoming Edge) → Branch (Incoming & outgoing edge) → Leaf (No outgoing edge)
// 3) Sub tree: Smaller Tree held within a Larger Tree
// 4) Size: # of nodes
// 5) Depth: # of edges below the root node
// 6) Height: # of edges above furthest leaf node
// 7) Binary search Tree: Has more than 2 child nodes and
// 8) Binary Tree vs Binary Search Tree: A Binary Tree is a non-linear data structure in which a node can have 0, 1 or 2 nodes. Individually, each node consists of a left pointer, right pointer and data element. A Binary Search Tree is an organized binary tree with a structured organization of nodes.
// 9) Benefit: Easy to locate a node when they're in the order
// 10) Time complexity: Best case O(log n) in case the tree is well-balanced & Worst case O(n)
// 11) Space complexity: Best case O(n)
public class Binary_Search_Tree {

    Node_Tree root;

    public void insert(Node_Tree node) {
        // To use recursion, "insertHelper()" method is used, rather than merely using "insert()" method
        root = insertHelper(root, node);
    }

    private Node_Tree insertHelper(Node_Tree root, Node_Tree node) {
        int data = node.data;

        // If there's no node, firstly-entered object of "node" class becomes root node
        if (root == null) {
            root = node;
            return root;
        }

        // If data of node is smaller than root node, it becomes root node of left-side Subtree
        else if (data < root.data) {
            // Recursion occurs to compose Subtree
            root.left = insertHelper(root.left, node);
        } else root.right = insertHelper(root.right, node);
        return root;
    }

    public void display() {
        // To use recursion, displayHelper() method is defined and called
        displayHelper(root);
    }

    private void displayHelper(Node_Tree root) {
        if (root != null) {
            // Very first value is the least value, followed by root note
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node_Tree root, int data) {
        if (root == null) {
            return false;
        }

        // That means "data" is found that user is looking for
        else if (root.data == data) {
            return true;
        }
        // If value the user's looking for is smaller than root value, recursion occurs by passing parameter into "searchHelper()" method
        else if (root.data > data) {
            return searchHelper(root.left, data);
        } else return searchHelper(root.right, data);
    }

    public void remove(int data) {
        // If data entered is found, it is passed as parameter of "removeHelper()" method along with root value, unless (if data entered is not found as one of node data), it will return "not found" state
        if (search(data)) {
            removeHelper(root, data);
        } else System.out.println("Data " + data + " is not found!");
    }

    public Node_Tree removeHelper(Node_Tree root, int data) {
        if (root == null) {
            return root;
        } else if (data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else {
            // It means that if the data that user's trying to remove is not found in branch, it's leaf node (=no deed to shift any node)
            // If the node that user's trying to remove has child node, it might be more complicated, unless not complicated
            if (root.left == null && root.right == null) {
                root = null;
            }

            // Find a successor to replace this node
            else if (root.right != null) {
                // When user delete the node, that creates a gap and if there's child, the child will be lost so link a child to that spot
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            // In case it has left child, find a predecessor to replace this node
            else {
                root.data = predecessor(root);
                root.right = removeHelper(root.left, root.data);
            }

        }
        return root;
    }

    // Find the least value below the right child of this root node
    private int successor(Node_Tree root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // Find the greatest value below the left child of this root node
    private int predecessor(Node_Tree root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // Procedures to visit all nodes of a tree with example of Binary Tree (Not binary search tree)
    // In-Order
    // Post-Order
    // Pre-Order

    // left → root → right
    public void traverseTree_In_Order(Node_Tree root) {
        traverseTree_Post_Order(root.left);
        System.out.println(root.data);
        traverseTree_Post_Order(root.right);
    }

    // left → right → root
    public void traverseTree_Post_Order(Node_Tree root) {
        traverseTree_Post_Order(root.left);
        traverseTree_Post_Order(root.right);
        System.out.println(root.data);
    }

    // root → left → right
    public void traverseTree_Pre_Order(Node_Tree root) {
        System.out.println(root.data);
        traverseTree_Post_Order(root.left);
        traverseTree_Post_Order(root.right);

    }
}

