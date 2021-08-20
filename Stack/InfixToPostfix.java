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

class InfixToPostfix {
	/* isEmpty(), isFull(), push(), pop() are functions provided on stack. */
	static String infixToPostfix(CQStack s, String exp) {
		String result = new String("");
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < exp.length(); ++i) {
			char c = exp.charAt(i);
			if (Character.isLetterOrDigit(c))
				result += c;
			else if (c == '(')
				stack.push(c);
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();
				stack.pop();
			} else {
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
					result += stack.pop();
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				return "Invalid Expression";
			result += stack.pop();
		}
		return result;
	}

	static int Prec(char ch) {
		switch (ch) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
				return 3;
		}
		return -1;
	}

	public static void main(String[] args) {
		CQStack theStack = new CQStack(100); // make new stack
		Scanner s = new Scanner(System.in);
		int t;
		String st;
		t = Integer.parseInt(s.nextLine());
		while (t > 0) {
			st = s.nextLine();
			st = infixToPostfix(theStack, st);
			System.out.println(st);
			t--;
		}
		s.close();
	}
}