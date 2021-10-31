package psw10;

import java.util.Scanner;

public class p1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t-- > 0) {
			int n = input.nextInt();
			int totalW = 0;
			int[] W = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				W[i] = input.nextInt();
				totalW += W[i];
			}
			int[][] dp = new int[n + 1][totalW + 1];
			
			for (int i = 0; i < n; i++) {
				dp[i][W[i]] = 1;
				for (int j = n; j > 0; j--) {
					for(int k = totalW; k >= W[i]; k--)
					if (dp[j - 1][k - W[i]] > 0)
						dp[j][k] = dp[j - 1][k - W[i]] + 1;
				}
			}
			int left = 0;
			for (int i = 0; i < totalW; i++) {
				if ((dp[n][i] == n / 2)	&& (Math.abs(totalW - i*2) < Math.abs(totalW - left*2)))
					left = i;
			}
			left = totalW - left > left ? left : totalW - left;
			System.out.println(left + " " + (totalW - left) + "\n");
		}
	}
}
