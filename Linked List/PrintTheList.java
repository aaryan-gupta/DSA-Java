import java.util.Scanner;

// Other imports go here
// Do NOT change the class name
class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
	}
}

class PrintTheList {
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

	/*
	 * class Node { int data; Node next; }
	 */
	static void forwardPrint(Node head) {
		while (head != null) {
			System.out.print(head.data + "-");
			head = head.next;
		}
	}

	static void backwardPrint(Node head) {
		head = reverse(head);
		while (head != null) {
			System.out.print(head.data + "-");
			head = head.next;
		}
	}

	static Node reverse(Node head) {
		Node next = null, prev = null;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		int t, n, m;
		Scanner s = new Scanner(System.in);
		t = Integer.parseInt(s.nextLine().trim());
		while (t > 0) {
			Node head = null;
			n = Integer.parseInt(s.nextLine().trim());
			while (n > 0) {
				m = Integer.parseInt(s.nextLine().trim());
				head = insertEnd(head, m);
				n--;
			}
			forwardPrint(head);
			System.out.print("\n");
			backwardPrint(head);
			System.out.print("\n");
			t--;
		}
		s.close();
	}
}