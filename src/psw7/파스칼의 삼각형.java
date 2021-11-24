import java.io.*;

public class Main { // 파스칼의 삼각형

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] pascal = new int[20][20];
		int n = Integer.parseInt(br.readLine());
		int start = 0, length = 20;
		for (int i = 0; i < 20; i++) {
			pascal[i][0] = 1;
			pascal[i][i] = 1;
		}
		for (int i = 2; i < 20; i++)
			for (int j = 1; j < i; j++)
				pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
		for (int i = 0; i < 20; i++) {
			int col = 0, sum = 0;
			while (i + col < 20) {
				sum += pascal[i + col][col];
				if (sum == n && col < length) {
					start = i;
					length = col;
					break;
				}
				col++;
			}
		}
		if (n == 1)
			System.out.print(1);
		else if (length == 20)
			System.out.println(0);
		else
			for (int i = 0; i <= length; i++)
				System.out.print(pascal[start + i][i] + " ");
	}
}
