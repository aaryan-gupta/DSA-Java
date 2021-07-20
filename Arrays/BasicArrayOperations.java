import java.util.Scanner;

public class BasicArrayOperations {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a[] = new int[100];
		a = inputArray(a, 5);
		displayArray(a, 5);
		a = insertInArray(a, 5, 2, 10);
		displayArray(a, 6);
		a = deleteInArray(a, 6, 3);
		displayArray(a, 5);
		getElement(a, 2);
		a = setElement(a, 3, 20);
		displayArray(a, 5);
		findMaxMin(a, 5);
		findSumAvg(a, 5);
		reverseArray(a, 5);
		int arraySorted[] = new int[100];
		insertInSortedArray(arraySorted, 5, 4);
		isSorted(arraySorted, 5);
		int arrangeElements[] = { -6, 3, -8, 10, 5, -7, -9, 12, -4, 2 };
		arrangeElements(arrangeElements, 10);
	}

	static int[] inputArray(int a[], int l) {

		for (int i = 0; i < l; i++) {
			System.out.print(i + " = ");
			a[i] = sc.nextInt();
		}
		return a;
	}

	static void displayArray(int a[], int l) {
		for (int i = 0; i < l; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	static int[] insertInArray(int a[], int l, int p, int ele) {
		for (int i = l; i > p; i--)
			a[i] = a[i - 1];
		a[p] = ele;
		return a;
	}

	static int[] deleteInArray(int a[], int l, int p) {
		for (int i = p; i < l - 1; i++)
			a[i] = a[i + 1];
		return a;
	}

	static void getElement(int a[], int i) {
		System.out.println(i + " = " + a[i]);
	}

	static int[] setElement(int a[], int p, int ele) {
		a[p] = ele;
		return a;
	}

	static void findMaxMin(int a[], int l) {
		int max = a[0], min = a[0];
		for (int i = 0; i < l; i++) {
			if (max < a[i])
				max = a[i];
			if (min > a[i])
				min = a[i];
		}
		System.out.println(max + " " + min);
	}

	static void findSumAvg(int a[], int l) {
		int sum = 0;
		for (int i = 0; i < l; i++)
			sum += a[i];
		System.out.println(sum + " " + (sum / (float) l));
	}

	static void reverseArray(int a[], int l) {
		int b[] = new int[l];
		for (int i = 0; i < l; i++) {
			b[l - i - 1] = a[i];
		}
		System.out.print("B = ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}

	static void insertInSortedArray(int a[], int l, int ele) {
		System.out.println("\ninsertInSortedArray :-");
		a = inputArray(a, l);
		int x = 0;
		for (int i = l - 1; a[i] > ele; i--) {
			a[i + 1] = a[i];
			x = i;
		}
		a[x] = ele;
		displayArray(a, l + 1);
	}

	static void isSorted(int a[], int l) {
		boolean sort = true;
		for (int i = 0; i < l - 1; i++) {
			if (a[i] > a[i + 1])
				sort = false;
		}
		if (sort)
			System.out.println("Sorted");
		else
			System.out.println("Not Sorted");
	}

	static void arrangeElements(int a[], int l) {
		int i = 0, j = l - 1;
		while (i < j) {
			while (a[i] < 0)
				i++;
			while (a[j] >= 0)
				j--;
			if (i < j) {
				a[i] = a[i] + a[j];
				a[j] = a[i] - a[j];
				a[i] = a[i] - a[j];
			}
		}
		displayArray(a, l);
	}
}
