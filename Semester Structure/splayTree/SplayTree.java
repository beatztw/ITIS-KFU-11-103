package splayTree;

class Node {
    int data; // holds the key
    Node parent; // pointer to the parent
    Node left; // pointer to left child
    Node right; // pointer to right child

    public Node(int data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}

public class SplayTree {
    private Node root;

    public SplayTree() {
        root = null;
    }

    private void printHelper(Node currPtr, String indent, boolean last) {
        // print the tree structure on the screen
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            System.out.println(currPtr.data);

            printHelper(currPtr.left, indent, false);
            printHelper(currPtr.right, indent, true);
        }
    }

    private Node searchTreeHelper(Node node, int key) {
        if (node == null || key == node.data) {
            return node;
        }

        if (key < node.data) {
            return searchTreeHelper(node.left, key);
        }
        return searchTreeHelper(node.right, key);
    }

    private void deleteNodeHelper(Node node, int key) {
        Node x = null;
        Node t = null;
        Node s = null;
        while (node != null){
            if (node.data == key) {
                x = node;
            }

            if (node.data <= key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (x == null) {
            System.out.println("Couldn't find key in the tree");
            return;
        }
        // split operation
        splay(x);
        if (x.right != null) {
            t = x.right;
            t.parent = null;
        } else {
            t = null;
        }
        s = x;
        s.right = null;
        x = null;
        // join operation
        if (s.left != null){ // remove x
            s.left.parent = null;
        }
        root = merge(s.left, t);
        s = null;
    }

    // rotate left at node x
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // rotate right at node x
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Splaying operation. It moves x to the root of the tree
    private void splay(Node x) {
        while (x.parent != null) {
            if (x.parent.parent == null) {
                if (x == x.parent.left) {
                    // zig rotation
                    rightRotate(x.parent);
                } else {
                    // zag rotation
                    leftRotate(x.parent);
                }
            } else if (x == x.parent.left && x.parent == x.parent.parent.left) {
                // zig-zig rotation
                rightRotate(x.parent.parent);
                rightRotate(x.parent);
            } else if (x == x.parent.right && x.parent == x.parent.parent.right) {
                // zag-zag rotation
                leftRotate(x.parent.parent);
                leftRotate(x.parent);
            } else if (x == x.parent.right && x.parent == x.parent.parent.left) {
                // zig-zag rotation
                leftRotate(x.parent);
                rightRotate(x.parent);
            } else {
                // zag-zig rotation
                rightRotate(x.parent);
                leftRotate(x.parent);
            }
        }
    }

    // joins two trees s and t
    private Node merge(Node s, Node t){
        if (s == null) {
            return t;
        }

        if (t == null) {
            return s;
        }
        Node x = maximum(s);
        splay(x);
        x.right = t;
        t.parent = x;
        return x;
    }

    // search the tree for the key k
    // and return the corresponding node
    public Node searchTree(int k) {
        Node x = searchTreeHelper(root, k);
        if (x != null) {
            splay(x);
        }
        return x;
    }

    // find the node with the minimum key
    public Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // find the node with the maximum key
    public Node maximum(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // find the successor of a given node
    public Node successor(Node x) {
        // if the right subtree is not null,
        // the successor is the leftmost node in the
        // right subtree
        if (x.right != null) {
            return minimum(x.right);
        }

        // else it is the lowest ancestor of x whose
        // left child is also an ancestor of x.
        Node y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    // find the predecessor of a given node
    public Node predecessor(Node x) {
        // if the left subtree is not null,
        // the predecessor is the rightmost node in the
        // left subtree
        if (x.left != null) {
            return maximum(x.left);
        }

        Node y = x.parent;
        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    // insert the key to the tree in its appropriate position
    public void insert(int key) {
        Node node = new Node(key);
        Node y = null;
        Node x = this.root;

        while (x != null) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        // y является родителем x
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }
        // splay node
        splay(node);
    }

    // delete the node from the tree
    void deleteNode(int data) {
        deleteNodeHelper(this.root, data);
    }

    // print the tree structure on the screen
    public void prettyPrint() {
        printHelper(this.root, "", true);
    }
}
