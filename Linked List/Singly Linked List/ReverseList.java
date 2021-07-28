import java.util.Scanner;

/* class Node {
	int data;
	Node next;
	Node(){}
	Node(int d) {
		data=d; next=null;
	}
} */
class Result {
	static Node reverseList(Node head) {
		// Write your code here
		Node current = head, next = null, prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}

class Node {
	int data;
	Node next;

	Node() {
	}

	Node(int d) {
		data = d;
		next = null;
	}
}

class ReverseList {
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
		t = Integer.parseInt(s.nextLine());
		while (t > 0) {
			Node head = null;
			Node newHead = null;
			n = s.nextInt();
			while (n > 0) {
				m = s.nextInt();
				head = insertEnd(head, m);
				n--;
			}
			newHead = Result.reverseList(head);
			forwardPrint(newHead);
			System.out.println();
			t--;
		}
		s.close();
	}
}