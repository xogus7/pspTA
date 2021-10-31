package psw4;

import java.io.*;

public class p2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] list = new char[26][26];	// ���ĺ��� �ε����� �ٷ� ���
		String index = br.readLine();		// �� �� �̸�
		String s = br.readLine();			// �� �ȿ� ä�� ����
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++)		// 2���� �ε��� 1���� ǥ��
				list[index.charAt(i) - 'A'][index.charAt(j) - 'A'] = s.charAt(i * 6 + j);
		
		while ((s = br.readLine()) != null) {
			StringBuilder sb = new StringBuilder();	// ��¹�
			boolean error = false;
			s = s.toUpperCase();	// �Էµ� ���ڿ� �빮�ڷ� ġȯ
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ' ')
					sb.append(' ');
				else {
					if (i + 1 >= s.length() || s.charAt(i) - 'A' >= 26 || s.charAt(i + 1) - 'A' >= 26) {
						error = true;	// �ص��� ���ڰ� Ȧ�� �Ǵ� ���ĺ��� �ƴ� ���
						System.out.println("-ERROR-");
						break;
					}
					char plain = list[s.charAt(i) - 'A'][s.charAt(i + 1) - 'A']; // ǥ�� ���� ���� �ص�
					if (plain != '\0')
						sb.append(plain);
					else {		// ���ĺ������� �� �� �̸��� ���� ���
						error = true;
						System.out.println("-ERROR-");
						break;
					}
					i++;
				}
			}
			if (!error)
				System.out.println(sb);
		}
	}
}