import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		int[][] dist = new int[n][n];
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		Deque<Integer> que = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		que.add(0);
		dist[0][0] = 1;
		while (!que.isEmpty()) { // bfs
			int pos = que.poll();
			int row = pos / n;
			int col = pos % n;
			for (int i = 0; i < 4; i++) {
				int r = row + dr[i];
				int c = col + dc[i];
				if (r < 0 || r >= n || c < 0 || c >= n || map[r][c] == 0 || dist[r][c] != 0)
					continue;
				que.add(r * n + c);
				dist[r][c] = dist[row][col] + 1;
			}
		}
		System.out.print(dist[n - 1][n - 1]);
	}
}
