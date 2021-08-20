import java.util.Scanner;
import java.util.*;

/*
 * class Node { int data; Node next; Node(int d) { data=d; } }
 */
class Result {
	static Node findIntersection(Node head1, Node head2) {
		// Write your code here
		HashSet<Integer> hs = new HashSet<>();
		Node t1 = head1, t2 = head2, head = null;
		while (t1 != null) {
			hs.add(t1.data);
			t1 = t1.next;
		}
		ArrayList<Integer> l = new ArrayList<>();
		while (t2 != null) {
			if (hs.contains(t2.data))
				l.add(t2.data);
			t2 = t2.next;
		}
		int a[] = new int[l.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = l.get(i);
		}
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			head = FindTheSortedIntersectionOfTwoLists.insertEnd(head, a[i]);
		}
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

class FindTheSortedIntersectionOfTwoLists {
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
			Node head = null, head2 = null, t1;
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
			t1 = Result.findIntersection(head, head2);
			forwardPrint(t1);
			System.out.println();
			t--;
		}
		s.close();
	}
}