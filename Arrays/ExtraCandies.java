import java.util.ArrayList;
import java.util.List;

public class ExtraCandies {
	public static void main(String[] args) {
		int candies[] = { 2, 3, 5, 1, 3 };
		List<Boolean> list = kidsWithCandies(candies, 3);
		System.out.println(list);
	}

	static List<Boolean> kidsWithCandies(int candies[], int extraCandies) {
		List<Boolean> list = new ArrayList<>();
		int max = candies[0];
		for (int i = 1; i < candies.length; i++) {
			if (max < candies[i])
				max = candies[i];
		}
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] + extraCandies >= max)
				list.add(true);
			else
				list.add(false);
		}
		System.out.println(max);
		return list;
	}
}
