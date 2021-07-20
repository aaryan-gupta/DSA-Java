import java.util.Scanner;

/* class Node {
	int data;
	Node next;
	Node(){}
	Node(int d) {
		data=d;
	}
} */
class Result {
	static Node revAltKNodes(Node head, int K) {
		// Write your code here
		return revAltKNodesUtil(head, K, true);
	}

	static Node revAltKNodesUtil(Node head, int k, boolean b) {
		if (head == null)
			return null;
		int count = 1;
		Node prev = null, next = null, current = head;
		while (current != null & count <= k) {
			next = current.next;
			if (b == true)
				current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		if (b == true) {
			head.next = revAltKNodesUtil(current, k, !b);
			return prev;
		}
		prev.next = revAltKNodesUtil(current, k, !b);
		return head;
	}
}

class Node {
	int data;
	Node next;

	Node() {
	}

	Node(int d) {
		data = d;
	}
}

class ReverseAlternateKNodes {
	static Node insertEnd(Node head, int data) {
		Node newLink = new Node(data);
		Node last = head;
		newLink.next = null; // link new node to NULL as it is last node
		if (head == null) // if list is empty add in beginning.
		{
			head = newLink;
			return head;
		}
		while (last.next != null) // Find the last node
			last = last.next;
		last.next = newLink; // Add the node after the last node of list
		return head;
	}

	static void forwardPrint(Node head) {
		Node current = head; // start at beginning of list
		while (current != null) // until end of list,
		{
			System.out.print(current.data + " "); // print data
			current = current.next; // move to next link
		}
	}

	public static void main(String[] args) {
		int t, n, m;
		Scanner s = new Scanner(System.in);
		t = Integer.parseInt(s.nextLine().trim());
		while (t > 0) {
			Node head = null, t1;
			int k;
			n = s.nextInt();
			while (n > 0) {
				m = s.nextInt();
				head = insertEnd(head, m);
				n--;
			}
			k = s.nextInt();
			t1 = Result.revAltKNodes(head, k);
			forwardPrint(t1);
			System.out.println();
			t--;
		}
		s.close();
	}
}