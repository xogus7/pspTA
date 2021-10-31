package psw4;

import java.io.*;

public class p3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			br.readLine();
			String line = br.readLine();
			int m = Integer.parseInt(line.split(" ")[0]);
			int n = Integer.parseInt(line.split(" ")[1]);
			char[][] grid = new char[m][n];
			for (int i = 0; i < m; i++) {
				line = br.readLine();
				grid[i] = line.toCharArray();
			}
			searchTeemo(grid, "TEEMO");	// �˻� ����
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++)
					System.out.print(grid[i][j]);
				System.out.println();
			}
			if(t > 0) System.out.println();
		}
	}

	public static void searchTeemo(char[][] grid, String word) {
				  //LU, UP, RU, L, R, DL,Down,DR
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 }; 
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				for (int k = 0; k < dr.length; k++) {
					int row = i;
					int col = j;
					int different = 0;
					for (int l = 0; l < word.length(); l++) {
						if (row < 0 || col < 0 || row >= grid.length || col >= grid[i].length) {
							different += 2;
							continue;
						}
						// ��ҹ��� ����, �ҹ����� ��� 32��ŭ ���� �빮�ڰ����� �ٲ۵� �˻�
						char c = (char) (grid[row][col] < 'a' ? grid[row][col] : grid[row][col] - 32);
						if (word.charAt(l) != c) { // �ٸ� ���ڸ�
							different++;
						}
						row += dr[k]; // �ش� �������� ��� �˻�
						col += dc[k];
					}
					if (different <= 1) { // �ѱ��� ���Ϸ� �ٸ� ���
						row = i;
						col = j;
						for (int l = 0; l < word.length(); l++) {
							grid[row][col] = '#';
							row += dr[k];
							col += dc[k];
						}
					}
				}
	}
}
