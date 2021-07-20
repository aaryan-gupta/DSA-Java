public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		int a[] = { 3, 8, 16, 20, 25 };
		int b[] = { 4, 10, 12, 22, 23 };
		int c[] = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}
		for (; i < a.length; i++)
			c[k++] = a[i];
		for (; j < b.length; j++)
			c[k++] = b[j];
		for (int l = 0; l < c.length; l++)
			System.out.print(c[l] + " ");
	}
}
