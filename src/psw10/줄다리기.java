import java.util.*;

public class Main {

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
			boolean[][] dp = new boolean[n + 1][totalW + 1];
			dp[0][0] = true;
			for (int i = 1; i <= n; i++) {			// 현재 선택한 사람의 무게
				for (int j = n / 2; j > 0; j--) {	// n/2명까지만 보면 됨
					for (int k = totalW; k >= W[i]; k--)	// k - W[i]의 가능한 모든 무게 조합
						if (dp[j - 1][k - W[i]]) {
							dp[j][k] = true;
						}
				}
			}
			int left = 0;	// 왼쪽팀 무게
			int diff_min = totalW;	// (총합 - left * 2)의 최소
			for (int i = 0; i <= totalW; i++) {
				if ((dp[n / 2][i]) && diff_min > Math.abs(totalW - i * 2)) {
					diff_min = Math.abs(totalW - i * 2);
					left = i;
				}
			}
			left = totalW - left < left ? totalW - left : left;
			System.out.println(left + " " + (totalW - left) + "\n");
		}
	}
}
