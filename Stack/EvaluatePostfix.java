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

	public void push(int j) // put item on top of stack
	{
		if (isFull()) {
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
}

class EvaluatePostfix {
	/* isEmpty(), isFull(), push(int) and int pop() functions available on Stack. */
	static int evalPostfix(CQStack s, String exp) {
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (Character.isDigit(c))
				s.push(c - '0');
			else {
				int val1 = s.pop(), val2 = s.pop();
				switch (c) {
					case '+':
						s.push(val2 + val1);
						break;
					case '-':
						s.push(val2 - val1);
						break;
					case '/':
						s.push(val2 / val1);
						break;
					case '*':
						s.push(val2 * val1);
						break;
					case '^':
						s.push((int) Math.pow(val2, val1));
						break;
				}
			}
		}
		return s.pop();
	}

	public static void main(String[] args) {
		CQStack theStack = new CQStack(100); // make new stack
		Scanner s = new Scanner(System.in);
		int t;
		String st;
		t = Integer.parseInt(s.nextLine().trim());
		while (t > 0) {
			st = s.nextLine().trim();
			System.out.println(evalPostfix(theStack, st));
			t--;
		}
		s.close();
	}
}