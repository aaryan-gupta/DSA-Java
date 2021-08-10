import java.util.Scanner;

/* class Node {
  int data;
  Node next;
  Node(){}
  Node(int d) {
    data=d;
  }
} */
class Result {
    static Node addListNumbers(Node l1, Node l2) {
        Node t1 = l1, t2 = l2, l3 = new Node(0);
        Node temp = l3;
        int x = 0, y = 0, carry = 0, sum = 0;
        while (t1 != null || t2 != null) {
            x = t1 == null ? 0 : t1.data;
            y = t2 == null ? 0 : t2.data;
            sum = carry + x + y;
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
            if (t1 != null)
                t1 = t1.next;
            if (t2 != null)
                t2 = t2.next;
        }
        if (carry > 0)
            temp.next = new Node(carry);
        return l3.next;
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

class AddTwoNumbers {
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
            t1 = Result.addListNumbers(head, head2);
            forwardPrint(t1);
            System.out.println();
            t--;
        }
        s.close();
    }
}