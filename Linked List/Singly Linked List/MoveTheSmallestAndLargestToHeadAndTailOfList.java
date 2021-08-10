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

class MoveTheSmallestAndLargestToHeadAndTailOfList {
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
    static Node deleteThisNode(Node org, Node del) {
        Node copy = org, prev = null;
        while (copy != null) {
            if (copy.data == del.data)
                break;
            prev = copy;
            copy = copy.next;
        }
        if (prev != null)
            prev.next = copy.next;
        else {
            copy = copy.next;
            return copy;
        }
        return org;
    }

    static Node shiftSmallLarge(Node org) {
        if (org == null || org.next == null)
            return org;
        Node copy = org, mn = null, mx = null;
        while (copy != null) {
            if (mn == null || copy.data < mn.data)
                mn = copy;
            if (mx == null || copy.data > mx.data)
                mx = copy;
            copy = copy.next;
        }
        org = deleteThisNode(org, mn);
        org = deleteThisNode(org, mx);
        Node newHead = new Node(mn.data);
        newHead.next = org;
        org = newHead;
        copy = org;
        while (copy != null && copy.next != null)
            copy = copy.next;
        copy.next = mx;
        mx.next = null;
        return org;
    }

    public static void main(String[] args) {
        int t, n, m;
        Scanner s = new Scanner(System.in);
        t = Integer.parseInt(s.nextLine().trim());
        while (t > 0) {
            Node head = null;
            n = Integer.parseInt(s.nextLine().trim());
            while (n > 0) {
                m = Integer.parseInt(s.nextLine().trim());
                head = insertEnd(head, m);
                n--;
            }
            head = shiftSmallLarge(head);
            forwardPrint(head);
            System.out.print("\n");
            t--;
        }
        s.close();
    }
}