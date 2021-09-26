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

class Main {
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
	static Node findUnion(Node head1, Node head2) {
		Node t1 = head1, t2 = head2;
		int c1 = 0, c2 = 0;
		while (t1 != null) {
			c1++;
			t1 = t1.next;
		}
		while (t2 != null) {
			c2++;
			t2 = t2.next;
		}
		t1 = head1;
		t2 = head2;
		int a1[] = new int[c1];
		int a2[] = new int[c2];
		for (int i = 0; t1 != null; i++) {
			a1[i] = t1.data;
			t1 = t1.next;
		}
		for (int i = 0; t2 != null; i++) {
			a2[i] = t2.data;
			t2 = t2.next;
		}
		if (a1.length > a2.length) {
			int t[] = a1;
			a1 = a2;
			a2 = t;
		}
		int result[] = new int[a1.length + a2.length];
		int z = 0;
		for (int i = 0; i < a1.length; i++) {
			result[z++] = a1[i];
		}
		for (int i = 0; i < a2.length; i++) {
			result[z++] = a2[i];
		}
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				if (result[i] < result[j]) {
					int t = result[i];
					result[i] = result[j];
					result[j] = t;
				}
			}
		}
		Node head = null;
		for (int i = 0; i < result.length; i++) {
			head = insertEnd(head, result[i]);
		}
		System.out.println(head.data);
		Node temp = head;
		while (temp != null && temp.next != null) {
			if (temp.data == temp.next.data) {
				temp.next = temp.next.next;
			} else
				temp = temp.next;
		}
		System.out.println();
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
		System.out.println();
		for (int i = 0; head != null; head = head.next) {
			System.out.print(head.data + " -> ");
		}
		return null;
	}

	public static void main(String[] args) {
		int t, n, m, x;
		Scanner s = new Scanner(System.in);
		// t = Integer.parseInt(s.nextLine());
		t = 1;
		while (t > 0) {
			Node head = null, head2 = null, t1;
			// n = Integer.parseInt(s.nextLine());
			n = 6;
			while (n > 0) {
				m = Integer.parseInt(s.nextLine());
				head = insertEnd(head, m);
				n--;
			}
			// n = Integer.parseInt(s.nextLine());
			n = 4;
			while (n > 0) {
				m = Integer.parseInt(s.nextLine());
				head2 = insertEnd(head2, m);
				n--;
			}

			t1 = findUnion(head, head2);
			forwardPrint(t1);
			System.out.println();
			t--;
		}
	}
}
// 1 // Number of Test cases
// 6 // Number of nodes in list1
// 7 1 2 3 4 5
// 4 // Number of nodes in list2
// 2 4 6 8