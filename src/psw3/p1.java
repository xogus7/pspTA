package psw3;

import java.util.Scanner;

public class p1 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String[] week = { "SAT", "SUN", "Mon", "Tue", "Wed", "Thu", "Fri" };
		int t = input.nextInt();
		while (t-- > 0) {
			int n = input.nextInt(); // ��¥ ��
			int lost = 0;			 // ���� ��
			int p = input.nextInt(); // ���� ��
			boolean[][] partys = new boolean[p + 1][n + 1]; // ������ ���� ǥ�� ������� �״�� ǥ��
			for (int i = 1; i <= p; i++) {
				int hartalsNum = input.nextInt();
				for (int j = 1; j * hartalsNum <= n; j++) {
					if ((j * hartalsNum) % 7 == 0 || (j * hartalsNum) % 7 == 1 || (j * hartalsNum) % 7 == 4)
						continue;
					partys[i][j * hartalsNum] = true;
				}
			}
			boolean[] hartals = new boolean[n + 1]; // �ش� ��¥�� ���� �޾������� �ƴ��� ����
			for (int j = 1; j <= n; j++) {
				int h = 0;	// j��° ���� �޾� ���� ��
				for (int i = 1; i <= p; i++) {
					if (partys[i][j])
						h++;
				}
				if (h > p / 2 || ((p & 1) == 0 && h >= p / 2)) { // �� �̻� �����ϸ�
					lost++;	// ���� �޾����� ���� ���� ���� ���� �ٹ� �ϼ� ����
					hartals[j] = true; // �ش� ��¥ �޾�
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