import java.io.*;

public class Main { // 이웃수열
	private static boolean[] sequence;
	private static boolean[] prev;
	private static boolean[] result;
	private static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null) {
			sequence = new boolean[line.length()];
			prev = new boolean[line.length()];
			for (int i = 0; i < sequence.length; i++)
				sequence[i] = line.charAt(i) == '1' ? true : false; // 1 = true, 0 = false
			count = 0;
			bt(0);
			if (count > 1)
				System.out.println("multiple");
			else if (count == 0)
				System.out.println("zero");
			else {
				for (int i = 0; i < result.length; i++)
					System.out.print(result[i] ? '1' : '0');
				System.out.println();
			}
		}
	}
	public static void bt(int depth) {
		if (depth == sequence.length) {
			boolean[] check = new boolean[depth];
			for (int i = 0; i < depth; i++)
				check[i] = prev[i];
			for (int i = 0; i < depth; i++) {
				int left = i < 1 ? depth - 1 : i - 1;
				int right = (i + 1) % depth;
				check[i] = prev[left] ^ prev[right] ? !check[i] : check[i];
			}
			for (int i = 0; i < depth; i++)
				if (sequence[i] != check[i]) return;
			result = new boolean[depth];
			for (int i = 0; i < depth; i++)
				result[i] = prev[i];
			count++;
			return;
		}
		prev[depth] = false;
		bt(depth + 1);
		prev[depth] = true;
		bt(depth + 1);
	}
}
