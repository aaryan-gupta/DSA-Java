import java.util.Scanner;
/* class Node {
  int data;
  Node next;
  Node() {}
  Node(int d) {
    data=d;
  }
} */
import java.util.*;

class Result {
	static Node findMergePoint(Node head1, Node head2) {
		Node temp1 = head1, temp2 = head2;
		List<Node> list = new ArrayList<>();
		while (temp1 != null) {
			list.add(temp1);
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			if (list.contains(temp2))
				break;
			temp2 = temp2.next;
		}
		return temp2;
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

class FindTheMergePointOfTwoLists {
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
			Node head = null, head2 = null, t1, t2, t3;
			n = s.nextInt();
			while (n > 0) {
				m = s.nextInt();
				head = insertEnd(head, m);
				n--;
			}
			n = s.nextInt();
			while (n > 0) {
				m = s.nextInt();
				head2 = insertEnd(head2, m);
				n--;
			}
			k = s.nextInt();
			if (k > 0) {
				t1 = head;
				while (k > 0) {
					t1 = t1.next;
					k--;
				}
				t2 = head2;
				while (t2.next != null)
					t2 = t2.next;
				t2.next = t1;
			}
			t3 = Result.findMergePoint(head, head2);
			forwardPrint(t3);
			System.out.println();
			t--;
		}
		s.close();
	}
}