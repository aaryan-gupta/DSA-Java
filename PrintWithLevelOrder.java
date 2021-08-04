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

class PrintWithLevelOrder {
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
    static void printLevelWise(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (true) {
            int count = q.size();
            if (count == 0)
                break;
            while (count > 0) {
                Node node = q.peek();
                if (count != 1)
                    System.out.print(node.data + " ");
                else
                    System.out.print(node.data);
                q.remove();
                if (node.leftChild != null)
                    q.add(node.leftChild);
                if (node.rightChild != null)
                    q.add(node.rightChild);
                count--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int a[] = new int[50];
        int n, i;
        Scanner s = new Scanner(System.in);
        n = Integer.parseInt(s.nextLine().trim());
        for (i = 0; i < n; i++)
            a[i] = Integer.parseInt(s.nextLine().trim());
        Node root = null;
        if (n != 0)
            root = buildTree(a, n);
        printLevelWise(root);
        s.close();
    }
}