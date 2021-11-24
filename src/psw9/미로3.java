import java.io.*;
import java.util.*;

public class Main { // 미로3
	private static int[][] map;
	private static int[][] route;
	private static int[] dr = { 0, 1, 0, -1 }; // right, down, left, up
	private static int[] dc = { 1, 0, -1, 0 };
	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		route = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = st.nextToken().charAt(0) - '0';
		}
		bt(0,0);
	}
	public static void bt(int row, int col) {
		if (map[row][col] == 2) {
			route[row][col] = 2;
			int step = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(route[i][j] + " ");
					if (route[i][j] != 0)
						step++;
				}
				System.out.println();
			}
			System.out.println(step + "\n");
		}
		route[row][col] = 1;
		for (int i = 0; i < 4; i++) {
			int x = row + dr[i];
			int y = col + dc[i];
			if (x < 0 || x >= N || y < 0 || y >= M || map[x][y] == 0 || route[x][y] != 0)
				continue;	// check : index, wall, visited
			bt(x, y);
		}
		route[row][col] = 0; // back
	}
}
