import java.util.Scanner;

public class Main {	// 동맹휴업
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String[] week = { "SAT", "SUN", "Mon", "Tue", "Wed", "Thu", "Fri" };
		int t = input.nextInt();
		while (t-- > 0) {
			int n = input.nextInt(); // 날짜 수
			int lost = 0;			 // 휴일 수
			int p = input.nextInt(); // 정당 수
			boolean[][] partys = new boolean[p + 1][n + 1]; // 문제에 나온 표의 정당들을 그대로 표현
			for (int i = 1; i <= p; i++) {
				int hartalsNum = input.nextInt();
				for (int j = 1; j * hartalsNum <= n; j++) {
					if ((j * hartalsNum) % 7 == 0 || (j * hartalsNum) % 7 == 1 || (j * hartalsNum) % 7 == 4)
						continue;
					partys[i][j * hartalsNum] = true;
				}
			}
			boolean[] hartals = new boolean[n + 1]; // 해당 날짜가 동맹 휴업일인지 아닌지 저장
			for (int j = 1; j <= n; j++) {
				int h = 0;	// j번째 날에 휴업 추진 수
				for (int i = 1; i <= p; i++) {
					if (partys[i][j])
						h++;
				}
				if (h > p / 2 || ((p & 1) == 0 && h >= p / 2)) { // 반 이상 찬성하면
					lost++;	// 동맹 휴업으로 인해 일을 하지 못한 근무 일수 증가
					hartals[j] = true; // 해당 날짜 휴업
				}
			}
			System.out.println("Lost: " + lost);
			for (int i = 1; i <= n; i++) {
				if (hartals[i]) {
					System.out.println(week[i % 7] + ": " + i);
				}
			}
			System.out.println();
		}
		input.close();
	}
}
