import java.util.*;

class CQStack {
    int maxSize; // size of stack array
    int[] stackArray;
    int top; // top of stack

    public CQStack() // constructor
    {
        maxSize = 100; // set array size
        stackArray = new int[maxSize]; // create array
        top = -1; // no items yet
    }

    public void push(int j) // put item on top of stack
    {
        if (isFull()) {
        } else
            stackArray[++top] = j; // increment top, insert item
    }

    public int pop() // take item from top of stack
    {
        if (isEmpty()) {
            return -1;
        } else {
            int temp = stackArray[top--];
            return temp; // access item, decrement top
        }
    }

    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }

    public boolean isFull() // true if stack is full
    {
        return (top == maxSize - 1);
    }
}

/* push(int), pop(), isEmpty(), isFull() are available on Stack. */
class Queue {
    void enqueue(CQStack st1, CQStack st2, int item) {
        st1.push(item);
    }

    int dequeue(CQStack st1, CQStack st2) {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }

        }
        return st2.pop();
    }
}

class ImplementQueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t, q1, q2;
        t = Integer.parseInt(s.nextLine());
        Queue qa1 = new Queue();
        CQStack st1 = new CQStack();
        CQStack st2 = new CQStack();
        while (t > 0) {
            q1 = s.nextInt();
            if (q1 == 1) {
                q2 = s.nextInt();
                qa1.enqueue(st1, st2, q2);
            } else
                System.out.print(qa1.dequeue(st1, st2) + " ");
            t--;
        }
        System.out.println();
        s.close();
    }
}