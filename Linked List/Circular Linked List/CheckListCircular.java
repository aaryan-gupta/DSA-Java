import java.util.Scanner;

// Other imports go here
// Do NOT change the class name
class LinkList {
    int data;
    LinkList next;

    LinkList(int d) {
        data = d;
    }
}

class CheckListCircular {
    // Insert in Beginning
    static LinkList insertBeg(LinkList head, int data) {
        LinkList newLink = new LinkList(data);
        LinkList t = head;
        newLink.next = head; // link new node at beginning of list
        if (head != null) {
            while (t.next != head)
                t = t.next;
            t.next = newLink;
        } else
            newLink.next = newLink;
        head = newLink; // Change the head to new node.
        return head;
    }

    // Insert in end
    static LinkList insertEnd(LinkList head, int data) {
        LinkList newLink = new LinkList(data);
        LinkList last = head;
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

    public static void traverse(LinkList first) {
        LinkList temp = first;
        if (first != null) {
            // Keep printing nodes till we reach the first node again
            do {
                System.out.println(temp.data + " "); // print data
                temp = temp.next;
            } while (temp != first);
        }
        System.out.println("");
    }
    /*
     * class LinkList { int data; LinkList next; }
     */

    static int isCircular(LinkList head) {
        if (head == null)
            return 1;
        LinkList temp = head.next;
        while (temp != head && temp != null) {
            temp = temp.next;
        }
        if (temp == null)
            return 0;
        return 1;
    }

    public static void main(String[] args) {
        int t, n, m, x;
        Scanner s = new Scanner(System.in);
        t = Integer.parseInt(s.nextLine());
        while (t > 0) {
            LinkList head = null;
            n = s.nextInt();
            if (n <= 4) {
                while (n > 0) {
                    m = s.nextInt();
                    head = insertBeg(head, m);
                    n--;
                }
            } else {
                while (n > 0) {
                    m = s.nextInt();
                    head = insertEnd(head, m);
                    n--;
                }
            }
            x = isCircular(head);
            System.out.println(x);
            t--;
        }
        s.close();
    }
}