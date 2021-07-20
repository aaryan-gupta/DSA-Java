import java.util.Scanner;

/* class Node {
	int data;
	Node next;

	Node() {
	}

	Node(int d) {
		data = d;
	}
} */

class Result {
	static int checkPalindrome(Node head) {
		if (head == null)
			return 0;
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = reverse(slow);
		fast = head;
		while (slow != null) {
			if (slow.data != fast.data)
				return 0;
			slow = slow.next;
			fast = fast.next;
		}
		return 1;
	}

	static Node reverse(Node head) {
		Node temp = head, next = null, prev = null;
		while (temp != null) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
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
	}
}

class CheckListForPalindrome {
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
			int ans;
			n = s.nextInt();
			while (n > 0) {
				m = s.nextInt();
				head = insertEnd(head, m);
				n--;
			}
			ans = Result.checkPalindrome(head);
			System.out.println(ans);
			t--;
		}
		s.close();
	}
}