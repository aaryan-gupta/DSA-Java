import java.util.*;

class CQStack {
    public int maxSize; // size of stack array
    public int[] stackArray;
    public int top; // top of stack

    public CQStack(int s) // constructor
    {
        stackArray = new int[s];
    }

    public void push(int j) // put item on top of stack
    {
        if (top != stackArray.length - 1) {
            top++;
            // System.out.println("array mein jagah hai "+stackArray[top]+"
            // "+stackArray.length+" "+j);
            stackArray[top] = j;
        }
    }

    public int pop() // take item from top of stack
    {
        if (top != -1) {
            int temp = top;
            top--;
            // System.out.println("Array ka POp "+stackArray[temp]+" top ki value "+top);
            return stackArray[temp];
        } else {
            return -1;
        }
    }

    public boolean isEmpty() // true if stack is empty
    {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() // true if stack is full
    {
        if (top == stackArray.length - 1) {
            return true;
        } else {
            return false;
        }
    }
}

class ImplementTheStackUsingArray {
    public static void main(String[] args) {
        CQStack theStack = new CQStack(10); // make new stack
        Scanner s = new Scanner(System.in);
        int t, n, q1, q2;
        t = Integer.parseInt(s.nextLine().trim());
        while (t > 0) {
            theStack.top = -1;
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
            t--;
        }
        s.close();
    }
}