public class QuickSort {
	static int a[] = { 6, 5, 8, 9, 3, 10, 15, 120, 16, 17 };

	static void quickSort(int l, int h) {
		if (l < h) {
			int j = partition(l, h);
			quickSort(l, j - 1);
			quickSort(j + 1, h);
		}
	}

	static int partition(int l, int h) {
		int j = l - 1, pivot = a[h];
		for (int i = l; i < h; i++) {
			if (a[i] < pivot) {
				j++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		int t = a[j + 1];
		a[j + 1] = a[h];
		a[h] = t;
		return j;
	}

	public static void main(String[] args) {
		quickSort(0, a.length - 1);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}
}