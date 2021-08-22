import java.util.Scanner;

/*
 * class Node { int data; // data used as key value Node leftChild; Node
 * rightChild; public Node() { data=0; } public Node(int d) { data=d; } } Above
 * class is declared for use.
 */
class Result {
	static int areSameTree(Node a, Node b) {
		if (a == null && b == null)
			return 1;
		if (a != null && b != null) {
			if (a.data == b.data) {
				if (areSameTree(a.leftChild, b.leftChild) == 1 && areSameTree(a.rightChild, b.rightChild) == 1)
					return 1;
			}
		}
		return 0;
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

class GivenTwoTreesAreIdenticalOrNot {
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
		int a[] = new int[20];
		int b[] = new int[20];
		int n, m, i;
		Scanner s = new Scanner(System.in);
		n = Integer.parseInt(s.nextLine());
		for (i = 0; i < n; i++)
			a[i] = s.nextInt();
		m = s.nextInt();
		for (i = 0; i < m; i++)
			b[i] = s.nextInt();
		Node root = null;
		if (n != 0)
			root = buildTree(a, n);
		Node root2 = null;
		if (m != 0)
			root2 = buildTree(b, m);
		System.out.println(Result.areSameTree(root, root2));
		s.close();
	}
}