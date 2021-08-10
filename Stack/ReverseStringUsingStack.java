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

    public void push(int j) // put item on top of stack
    {
        if (isFull()) {
            return;
        } else {
            stackArray[++top] = j; // increment top, insert item
        }
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

class ReverseStringUsingStack {
    static String reverseString(CQStack s, String st) {
        int i = 0;
        while (i < st.length()) {
            s.push(i);

            i++;
        }
        String s1 = "";
        while (!s.isEmpty()) {
            int index = s.pop();
            // System.out.println(index);;
            char c1 = st.charAt(index);
            String s3 = Character.toString(c1);
            s1 = s1.concat(s3);
        }
        // System.out.println(s1);
        return s1;
    }

    public static void main(String[] args) {
        CQStack theStack = new CQStack(100); // make new stack
        Scanner s = new Scanner(System.in);
        int t, n;
        String st;
        t = Integer.parseInt(s.nextLine().trim());
        while (t > 0) {
            theStack.top = -1;
            n = Integer.parseInt(s.nextLine().trim());
            while (n > 0) {
                st = s.nextLine().trim();
                st = reverseString(theStack, st);
                System.out.println(st);
                n--;
            }
            System.out.print("\n");
            t--;
        }
        s.close();
    }
}