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

class FindMidAndNthFromLast {
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

	/*
	 * class Node { int data; Node next; }
	 */
	static int findMiddle(Node head) {
		if (head == null)
			return -1;
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

	static int findNLast(Node head, int n) {
		if (n == 0 || head == null)
			return -1;
		Node slow = head, fast = head;
		for (int i = 0; i < n; i++) {
			if (fast.next == null)
				return fast.data;
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;
	}

	public static void main(String[] args) {
		int t, n, m, x;
		Scanner s = new Scanner(System.in);
		t = s.nextInt();
		while (t > 0) {
			Node head = null;
			n = s.nextInt();
			while (n > 0) {
				m = s.nextInt();
				head = insertEnd(head, m);
				n--;
			}
			x = s.nextInt();
			System.out.println(findMiddle(head));
			System.out.println(findNLast(head, x));
			t--;
		}
		s.close();
	}
}