public class NumbersSmallerThanCurrentNumber {
	public static void main(String[] args) {
		int ary[] = { 8, 1, 2, 2, 3 };
		int b[] = new int[ary.length];
		for (int i = 0; i < ary.length; i++) {
			int count = 0;
			for (int j = 0; j < ary.length; j++) {
				if (i != j && ary[j] < ary[i])
					count++;
			}
			b[i] = count;
		}
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
	}
}