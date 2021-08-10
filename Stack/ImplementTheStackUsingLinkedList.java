import java.util.*;

class LinkList {
    public int data; // data item
    public LinkList next; // next link in list

    public LinkList(int dd) // constructor
    {
        data = dd;
    }
}
/*
 * class LinkList { public int data; // data item public LinkList next; // next
 * link in list public LinkList(int dd) // constructor { data = dd; } } The
 * LinkList class is given as above
 */

class LinkStack {
    private LinkList first; // ref to first item on list

    public LinkStack() // constructor
    {
        first = null;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        } else
            return false;
    }

    public void push(int dd) {
        LinkList Node = new LinkList(dd);
        if (first == null) {
            first = Node;
        } else {
            Node.next = first;
            first = Node;
        }
    }

    public int pop() {
        if (first == null) {
            return -1;
        } else {
            LinkList temp = first;
            first = first.next;
            return temp.data;
        }
    }
}

class ImplementTheStackUsingLinkedList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t, n, q1, q2;
        t = Integer.parseInt(s.nextLine().trim());
        while (t > 0) {
            LinkStack theStack = new LinkStack(); // make new stack
            n = Integer.parseInt(s.nextLine().trim());
            while (n > 0) {
                q1 = Integer.parseInt(s.nextLine().trim());
                if (q1 == 1) {
                    q2 = Integer.parseInt(s.nextLine().trim());
                    theStack.push(q2);
                } else
                    System.out.print(theStack.pop() + " ");
                n--;
            }
            System.out.print("\n");
            theStack = null;
            t--;
        }
        s.close();
    }
}