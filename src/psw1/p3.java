package psw1;

import java.util.Scanner;

public class p3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNextInt()) {
			int n = input.nextInt();
			int x = input.nextInt();
			if (inNum(n, x))
				System.out.println("Y");
			else
				System.out.println("N");
		}
		input.close();
	}
	private static boolean inNum(int n, int x) {
		if (n == x)
			return true;
		while (n != 1) {
			n = ((n & 1) == 0) ? (n /= 2) : (n = 3 * n + 1);
			if (n == x)
				return true;
		}
		return false;
	}
}
