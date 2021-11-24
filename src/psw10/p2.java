import java.util.*;

public class Main {
	private static boolean[] s;
	private static int n;
	private static StringBuilder sb;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		s = new boolean[n * 2 + 1];
		sb = new StringBuilder();
		bt(0, 0, 0);
		System.out.print(sb);
	}

	public static void bt(int select, int box, int cover) {
		if (select == n * 2) {
			for (int i = 0; i < n * 2; i++)
				if (s[i]) sb.append('b');
				else sb.append('c');
			sb.append('\n');
			return;
		}
		s[select] = true;
		if (box < n)
			bt(select + 1, box + 1, cover);
		s[select] = false;
		if (cover < box)
			bt(select + 1, box, cover + 1);
	}
}
