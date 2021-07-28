import java.util.Scanner;

/* class Node {
	int data;
	Node next;
	Node() {}
	Node(int d) {
		data=d;
	}
} */
class Result {
	static void deleteNodeK(Node n1) {
		if (n1 == null || n1.next == null)
			return;
		n1.data = n1.next.data;
		n1.next = n1.next.next;
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

class DeleteGivenNode {
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
		int t, n, m, k;
		Scanner s = new Scanner(System.in);
		t = Integer.parseInt(s.nextLine());
		while (t > 0) {
			Node head = null, t1;
			n = s.nextInt();
			while (n > 0) {
				m = s.nextInt();
				head = insertEnd(head, m);
				n--;
			}
			k = s.nextInt();
			t1 = head;
			if (k > 0) {
				while (k > 0) {
					t1 = t1.next;
					k--;
				}
			}
			Result.deleteNodeK(t1);
			forwardPrint(head);
			System.out.println();
			t--;
		}
		s.close();
	}
}