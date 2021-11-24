import java.io.*;
import java.util.*;

public class Main {
  static boolean[][] graph;
	static int N, C;
	static int[] color;
	static StringBuilder sb;
	static boolean NONE = true;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new boolean[N + 1][N + 1];
		color = new int[N + 1];
		for (int i = 1; i <= N; i++) {
       st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
			  graph[i][j] = st.nextToken().equals("1") ? true : false;
		}
		setColor(1);
		if (NONE)
			System.out.print("NONE");
		else
			System.out.print(sb);
	}

	public static boolean check(int curr) {
		for (int i = 0; i < curr; i++)
			if (graph[curr][i] && color[i] != 0 && color[curr] == color[i])
				return false;
		return true;
	}
	public static void setColor(int depth) {
		if (depth == N + 1) {
			NONE = false;
			for (int i = 1; i <= N; i++)
				sb.append(color[i] + " ");
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= C; i++) {
			color[depth] = i;
			if (check(depth)) setColor(depth + 1);
		}
	}
}
