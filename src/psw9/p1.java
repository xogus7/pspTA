package psw9;

import java.io.*;

public class p1 {
	private static int n, r, c;
	private static int[] pos;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String num = br.readLine();
		r = Integer.parseInt(num.split(" ")[0]);
		c = Integer.parseInt(num.split(" ")[1]);
		pos = new int[n];
		bt(0);
	}
	public static void bt(int depth) {
		if (depth == n) {
			if (pos[r - 1] == c - 1) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++)
						if (pos[i] == j) System.out.print("B ");
						else System.out.print("* ");
					System.out.println();
				}
				System.out.println();
			}
			return;

		}
		for (int i = 0; i < n; i++) {
			pos[depth] = i;
			if (check(depth)) bt(depth + 1);
		}
	}
	public static boolean check(int col) {
		for (int i = 0; i < col; i++)
			if (Math.abs(col - i) == Math.abs(pos[col] - pos[i]))
				return false;
		return true;
	}
}