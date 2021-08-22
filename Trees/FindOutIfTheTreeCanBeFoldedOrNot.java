import java.util.Scanner;

/*
 * class Node { int data; // data used as key value Node leftChild; Node
 * rightChild; public Node() { data=0; } public Node(int d) { data=d; } } Above
 * class is declared for use.
 */
class Result {
	static int isFoldable(Node root) {
		if (root == null)
			return 1;
		if (isFoldableUtil(root.leftChild, root.rightChild))
			return 1;
		return 0;
	}

	static boolean isFoldableUtil(Node n1, Node n2) {
		if (n1 == null && n2 == null)
			return true;
		if (n1 == null || n2 == null)
			return false;
		return (isFoldableUtil(n1.leftChild, n2.rightChild) && isFoldableUtil(n1.rightChild, n2.leftChild));
	}
}

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

class FindOutIfTheTreeCanBeFoldedOrNot {
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

	public static void main(String[] args) {
		int a[] = new int[10];
		int n, i;
		Scanner s = new Scanner(System.in);
		n = Integer.parseInt(s.nextLine());
		for (i = 0; i < n; i++)
			a[i] = s.nextInt();
		Node root = null;
		if (n != 0)
			root = buildTree(a, n);
		System.out.println(Result.isFoldable(root));
		s.close();
	}
}