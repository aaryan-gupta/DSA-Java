import java.util.*;

class Result {
	static void printNextGreaterElement(int arr[], int n) {
		// Write your code here
		Stack<Integer> s = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		s.push(arr[0]);
		for (int i = 1; i < n; i++) {
			while (!s.empty() && s.peek() < arr[i]) {
				map.put(s.peek(), arr[i]);
				s.pop();
			}
			s.push(arr[i]);
		}
		while (!s.empty()) {
			map.put(s.peek(), -1);
			s.pop();
		}
		for (int i = 0; i < n; i++)
			System.out.print(map.get(arr[i]) + " ");
	}
}

class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Result result = new Result();
		int t = s.nextInt();
		while (t-- > 0) {
			int n;
			n = s.nextInt();
			int arr[] = new int[n];
			int i = 0;
			for (i = 0; i < n; i++)
				arr[i] = s.nextInt();
			result.printNextGreaterElement(arr, n);
			System.out.println();
		}
	}
}