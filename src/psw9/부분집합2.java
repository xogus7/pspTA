import java.util.*;

public class Main { // 부분집합 2
	private static char[] s;
	private static boolean[] check;
	private static int n;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		s = input.next().toCharArray();
		n = input.nextInt();
		check = new boolean[s.length];
		Arrays.sort(s);
		combination(0);
	}
	// nCr 사전순
	public static void combination(int curr) {
		if (curr == s.length) {
			int select = 0;
			for (int i = 0; i < curr; i++)
				if (check[i]) select++;
			if (select >= n) {
				System.out.print("{ ");
				for (int i = 0; i < s.length; i++) {
					if (check[i]) System.out.print((s[i] + " "));
				}
				System.out.println("}");
			}
			return;
		}
		check[curr] = true;
		combination(curr + 1);
		check[curr] = false;
		combination(curr + 1);
	}
}
