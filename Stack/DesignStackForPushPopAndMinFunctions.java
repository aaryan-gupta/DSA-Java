import java.util.*;

class CQStack {
    public int maxSize; // size of stack array
    public int[] stackArray;
    public int top; // top of stack

    public CQStack(int s) // constructor
    {
        maxSize = s; // set array size
        stackArray = new int[maxSize]; // create array
        top = -1; // no items yet
    }

    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }

    public boolean isFull() // true if stack is full
    {
        return (top == maxSize - 1);
    }

    int min;
    int secPrev;

    public void push(int j) // put item on top of stack
    {
        if (isFull()) {

        } else {
            top++;
            stackArray[top] = j;
        }
    }

    public int pop() // take item from top of stack
    {
        if (isEmpty()) {
            return -1;
        } else {
            int temp = top;
            top--;
            return stackArray[temp];
        }
    }

    public int getMin() {
        if (top >= 0) {
            min = stackArray[top];
            if (min > stackArray[top]) {
                min = stackArray[top];
            }
            return min;
        } else {
            return -1;
        }
    }
}

class Main {
    public static void main(String[] args) {
        CQStack theStack = new CQStack(100); // make new stack
        Scanner s = new Scanner(System.in);
        int t, n, q1, q2;
        t = Integer.parseInt(s.nextLine().trim());
        while (t > 0) {
            n = Integer.parseInt(s.nextLine().trim());
            while (n > 0) {
                q1 = Integer.parseInt(s.nextLine().trim());
                if (q1 == 1) {
                    q2 = Integer.parseInt(s.nextLine().trim());
                    theStack.push(q2);
                } else if (q1 == 2)
                    System.out.print(theStack.pop() + " ");
                else
                    System.out.print(theStack.getMin() + " ");
                n--;
            }
            System.out.print("\n");
            t--;
        }
        s.close();
    }
}