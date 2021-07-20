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

// The below class is given for use as Nodes
/*
 * class Node { int data; Node next;
 * 
 * Node(int d) { data = d; } }
 */

class Result {
	static int loopInList(Node head) {
		// Write your code here
		Node slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				int result = 1;
				Node temp = slow;
				while (temp.next != slow) {
					result++;
					temp = temp.next;
				}
				return result;
			}
		}
		return 0;
	}
}

class FindLoop {
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
			Node head = null;
			Node t1, t2;
			int c, k, ans;
			n = s.nextInt();
			while (n > 0) {
				m = s.nextInt();
				head = insertEnd(head, m);
				n--;
			}
			k = s.nextInt();
			c = s.nextInt();
			if (c > 0 && k > 0) {
				k--;
				c--;
				t1 = head;
				t2 = head;
				while (k > 0) {
					t1 = t1.next;
					k--;
				}
				while (c > 0) {
					t2 = t2.next;
					c--;
				}
				t1.next = t2;
			}
			ans = Result.loopInList(head);
			System.out.println(ans);
			t--;
		}
		s.close();
	}
}