import java.io.*;

public class Main {	// 카드뽑기 2

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			int[] tom = new int[26];
			int[] jerry = new int[26];
			int tMax = 0, jMax = 0, tMaxin = 0, jMaxin = 0;
			// 가지고 있는 같은 카드 개수
			for (int i = 0; i < 5; i++)
				tom[s.charAt(i) - 'A']++;
			for (int i = 6; i < 11; i++)
				jerry[s.charAt(i) - 'A']++;
			for (int i = 0; i < 26; i++) {
				if (tMax <= tom[i]) {
					tMax = tom[i];	// 같은 카드의 가장 큰 개수
					tMaxin = i;		// 해당 카드의 알파벳
				}
				if (jMax <= jerry[i]) {
					jMax = jerry[i];
					jMaxin = i;
				}
			}
			if(tMax <= 1 && jMax <= 1) System.out.println("Draw"); // 둘 다 2장이상 같은 카드가 없을 경우
			else {
				if (tMax == jMax)	// 같은 카드의 개수가 똑같을 경우 해당 카드의 알파벳 비교
					if (tMaxin == jMaxin) System.out.println("Draw");
					else if (tMaxin > jMaxin) System.out.println("Tom");
					else System.out.println("Jerry");
				else if (tMax > jMax) System.out.println("Tom");
				else System.out.println("Jerry");
			}
		}
	}
}
