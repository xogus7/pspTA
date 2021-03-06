import java.util.*;

public class Main { // 부분집합
	private static List<Integer> list;
	private static boolean[] check;
	private static int n;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		list = new ArrayList<>();
		String[] num = input.nextLine().split(" ");
		n = num.length;
		for(int i = 0; i < n; i++)
			list.add(Integer.parseInt(num[i]));
		check = new boolean[n];
		for(int i = 0; i <= n; i++)
			combination(i, 0);
	}
	//nCr
	public static void combination(int r, int curr) {
		if(r == 0) {
			System.out.print("{ ");
			for(int i = 0; i < n; i++) {
				if(check[i])
				System.out.print((list.get(i) + " "));
			}
			System.out.println("}");
			return;
		}
		if(curr == n) return;
		check[curr] = true;
		combination(r - 1, curr+1);
		check[curr] = false;
		combination(r, curr+1);
	}
}
