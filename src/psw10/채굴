import java.io.*;
import java.util.*;

public class Main {
	private static int[][] map;
	private static int[][] route;
	private static int[] dr = { 0, 1, 0, -1 };
	private static int[] dc = { 1, 0, -1, 0 };
	private static int n, area;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		route = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if(map[i][j] == 1 && route[i][j] == 0) // 다이아몬드가 있고 구역 설정이 안되어 있다면
					search(i,j);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(route[i][j]+" ");
			System.out.println();
		}
	}

	public static void search(int i, int j) {
		area++;
		route[i][j] = area;
		Deque<Integer> q = new ArrayDeque<>();
		q.add(n * i + j);
		while (!q.isEmpty()) {
			int pos = q.poll();
			i = pos / n;
			j = pos % n;
			for (int k = 0; k < 4; k++) {
				int row = i + dr[k];
				int col = j + dc[k];
				if (row < 0 || row >= n || col < 0 || col >= n || map[row][col] == 0 || route[row][col] != 0)
					continue;
				route[row][col] = area;
				q.add(n * row + col);
			}
		}
	}
}
