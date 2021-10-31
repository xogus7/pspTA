package psw2;

import java.io.*;

public class p2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			int[] tom = new int[26];
			int[] jerry = new int[26];
			int tMax = 0, jMax = 0, tMaxin = 0, jMaxin = 0;
			// ������ �ִ� ���� ī�� ����
			for (int i = 0; i < 5; i++)
				tom[s.charAt(i) - 'A']++;
			for (int i = 6; i < 11; i++)
				jerry[s.charAt(i) - 'A']++;
			for (int i = 0; i < 26; i++) {
				if (tMax <= tom[i]) {
					tMax = tom[i];	// ���� ī���� ���� ū ����
					tMaxin = i;		// �ش� ī���� ���ĺ�
				}
				if (jMax <= jerry[i]) {
					jMax = jerry[i];
					jMaxin = i;
				}
			}
			if(tMax <= 1 && jMax <= 1) System.out.println("Draw"); // �� �� 2���̻� ���� ī�尡 ���� ���
			else {
				if (tMax == jMax)	// ���� ī���� ������ �Ȱ��� ��� �ش� ī���� ���ĺ� ��
					if (tMaxin == jMaxin) System.out.println("Draw");
					else if (tMaxin > jMaxin) System.out.println("Tom");
					else System.out.println("Jerry");
				else if (tMax > jMax) System.out.println("Tom");
				else System.out.println("Jerry");
			}
		}
	}
}
