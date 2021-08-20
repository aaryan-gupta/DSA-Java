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

/*
 * class CQStack{ public CQStack(int s) // constructor public void push(int j)
 * // put item on top of stack public int pop() // take item from top of stack
 * public boolean isEmpty() // true if stack is empty public boolean isFull() //
 * true if stack is full } CQStack class already defined as per the above
 * blueprint
 */
class Result {
	static int evalPrefix(CQStack s, String exp) {
		// Write your code here
		for (int i = exp.length() - 1; i >= 0; i--) {
			if (isOperand(exp.charAt(i)))
				s.push((int) (exp.charAt(i) - 48));
			else {
				int o1 = s.pop(), o2 = s.pop();
				switch (exp.charAt(i)) {
					case '+':
						s.push(o1 + o2);
						break;
					case '-':
						s.push(o1 - o2);
						break;
					case '*':
						s.push(o1 * o2);
						break;
					case '/':
						s.push(o1 / o2);
						break;
					case '^':
						s.push((int) Math.pow(o1, o2));
						break;
				}
			}
		}
		return s.pop();
	}

	static boolean isOperand(char c) {
		if (c >= 48 && c <= 57)
			return true;
		else
			return false;
	}
}

class EvaluatePrefix {
	public static void main(String[] args) {
		CQStack theStack = new CQStack(100); // make new stack
		Scanner s = new Scanner(System.in);
		int t;
		String st;
		t = Integer.parseInt(s.nextLine());
		while (t > 0) {
			st = s.nextLine();
			System.out.println(Result.evalPrefix(theStack, st));
			t--;
		}
		s.close();
	}
}