import java.util.Scanner;

// Other imports go here
// Do NOT change the class name
class Node1 {
	int data;
	Node1 next;

	Node1(int d) {
		data = d;
	}
}

class CopyFirstToSecond {
	static Node1 insertEnd(Node1 head, int data) {
		Node1 newLink = new Node1(data);
		Node1 last = head;
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

	static void forwardPrint(Node1 head) {
		Node1 current = head; // start at beginning of list
		while (current != null) // until end of list,
		{
			System.out.print(current.data + " "); // print data
			current = current.next; // move to next link
		}
	}
	/*
	 * class Node1 { int data; Node1 next; }
	 */

	static Node1 copyList(Node1 org) {
		Node1 current = org;
		Node1 newList = null;
		Node1 tail = null;
		while (current != null) {
			if (newList == null) {
				newList = new Node1(current.data);
				tail = newList;
			} else {
				tail.next = new Node1(0);
				tail = tail.next;
				tail.data = current.data;
				tail.next = null;
			}
			current = current.next;
		}
		return newList;
	}

	public static void main(String[] args) {
		int t, n, m;
		Scanner s = new Scanner(System.in);
		t = Integer.parseInt(s.nextLine().trim());
		while (t > 0) {
			Node1 head = null;
			Node1 h2 = null;
			n = Integer.parseInt(s.nextLine().trim());
			while (n > 0) {
				m = Integer.parseInt(s.nextLine().trim());
				head = insertEnd(head, m);
				n--;
			}
			h2 = copyList(head);
			if (h2 != null && h2 == head)
				System.out.print("Don't be Smart, CodeQuotient is more than you!");
			else
				forwardPrint(h2);
			System.out.print("\n");
			t--;
		}
		s.close();
	}
}