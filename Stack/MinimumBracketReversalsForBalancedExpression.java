import java.util.*;

class Result {
	static int minReversal(String s) {
		Stack<Character> st = new Stack<>();
		int c1 = 0, c2 = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '[') {
				st.push(ch);
				c1++;
			} else {
				if (!st.isEmpty() && st.peek() == '[') {
					st.pop();
					c1--;
				} else {
					st.push(ch);
					c2++;
				}
			}
		}
		double f = (double) c1 / 2, g = (double) c2 / 2;
		if ((c1 + c2) % 2 == 1)
			return -1;
		return (int) (Math.ceil(f) + Math.ceil(g));
	}
}

class Main {
	public static void main(String[] args) {
		int t, ans;
		Scanner s = new Scanner(System.in);
		t = Integer.parseInt(s.nextLine().trim());
		while (t != 0) {
			String expr;
			expr = s.nextLine().trim();
			ans = Result.minReversal(expr);
			System.out.println(ans);
			t--;
		}
	}
}