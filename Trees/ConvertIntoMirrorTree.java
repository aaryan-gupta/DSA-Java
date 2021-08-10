import java.util.*;

class Node {
    int data; // data used as key value
    Node leftChild;
    Node rightChild;

    public Node() {
        data = 0;
    }

    public Node(int d) {
        data = d;
    }
}

class ConvertIntoMirrorTree {
    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.leftChild);
            System.out.print(root.data + " ");
            inOrder(root.rightChild);
        }
    }

    static Node insertLevelOrder(int arr[], Node root, int i, int n) {
        if (i < n) {
            Node temp = new Node(arr[i]);
            root = temp;
            root.leftChild = insertLevelOrder(arr, root.leftChild, 2 * i + 1, n);
            root.rightChild = insertLevelOrder(arr, root.rightChild, 2 * i + 2, n);
        }
        return root;
    }

    static Node buildTree(int t[], int n) {
        Node node = null;
        node = insertLevelOrder(t, node, 0, n);
        return node;
    }

    /*
     * class Node { int data; // data used as key value Node leftChild; Node
     * rightChild; public Node() { data=0; } public Node(int d) { data=d; } } Above
     * class is declared for use.
     */
    static Node findMirror(Node root) {
        if (root == null)
            return null;
        Node left = findMirror(root.leftChild);
        Node right = findMirror(root.rightChild);
        root.leftChild = right;
        root.rightChild = left;
        return root;
    }

    public static void main(String[] args) {
        int a[] = new int[10];
        int n, i;
        Scanner s = new Scanner(System.in);
        n = Integer.parseInt(s.nextLine());
        for (i = 0; i < n; i++)
            a[i] = Integer.parseInt(s.nextLine());
        Node root = null;
        if (n != 0)
            root = buildTree(a, n);
        root = findMirror(root);
        inOrder(root);
        s.close();
    }
}