import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] graph;
	static int[] path;
	static int n, m, k;
	static StringBuilder sb;
	static boolean found = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		graph = new boolean[n + 1][n + 1];
		path = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v][v2] = true;
			graph[v2][v] = true;
		}
		path[0] = k; // starting from k
		search(1, k);
		if (found) System.out.print(sb);
		else System.out.print(0);
	}
	public static void search(int index, int curr) {
		if (index == n) {
			if (graph[curr][k]) {
				path[index] = k;
				found = true;
				for (int i = 0; i <= n; i++) {
					sb.append(path[i]);
					if (i != n) sb.append(" ");
				}
				sb.append("\n");
			}
			return;
		}
		for (int next = 1; next <= n; next++)
			if (graph[curr][next]) {
				path[index] = next;
				if (check(index))
					search(index + 1, next);
			}
	}
	public static boolean check(int i) {
		for (int j = 0; j < i; j++)
			if (path[i] == path[j]) return false;
		return true;
	}
}
