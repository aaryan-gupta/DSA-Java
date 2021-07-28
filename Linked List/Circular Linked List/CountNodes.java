import java.util.Scanner;

/* class LinkList {
  int data;
  LinkList next;
  LinkList() {}
  LinkList(int d) {
    data=d;
  }
} */
class Result {
    static int countNodes(LinkList head) {
        // Write your code here
        if (head == null)
            return 0;
        LinkList temp = head.next;
        int c = 1;
        while (temp != head) {
            temp = temp.next;
            c++;
        }
        return c;
    }
}

class LinkList {
    int data;
    LinkList next;

    LinkList() {
    }

    LinkList(int d) {
        data = d;
    }
}

class CountNodes {
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
                System.out.print(temp.data + " "); // print data
                temp = temp.next;
            } while (temp != first);
        }
    }

    public static void main(String[] args) {
        int t, n, m, x;
        Scanner s = new Scanner(System.in);
        t = Integer.parseInt(s.nextLine().trim());
        while (t > 0) {
            LinkList head = null;
            n = s.nextInt();
            while (n > 0) {
                m = s.nextInt();
                head = insertBeg(head, m);
                n--;
            }
            x = Result.countNodes(head);
            System.out.println(x);
            t--;
        }
        s.close();
    }
}