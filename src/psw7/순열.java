import java.util.*;

public class Main { // 순열
	private static char[] s;
	private static char[] result;
	private static Set<String> set;
	private static boolean[] check;
	private static int n;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		s = input.nextLine().toCharArray();
		Arrays.sort(s);
		n = s.length;
		result = new char[n];
		check = new boolean[n];
		set = new HashSet<>();
		perm(n, 0);
	}
	//nPr
	public static void perm(int r, int curr) {
		if(curr == r) {
			String str = new String(result);
			if(set.add(str))
				System.out.println(str);
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!check[i]) {
				check[i]=true;
				result[curr] = s[i];
				perm(r, curr + 1);
				check[i] = false;
			}
		}
	}
}
