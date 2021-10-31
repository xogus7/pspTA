package psw5;

import java.io.*;
import java.util.*;

public class p2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n; // �ܾ� ��
		String s; // �Է� ����
		String word;
		while ((s = br.readLine()) != null) {
			Set<String> set = new HashSet<>(); // �ߺ� Ȯ��
			StringTokenizer st = new StringTokenizer(s); // �Է¹��� ���� ���� �������� �ڸ���
			StringBuilder sb = new StringBuilder();	// ��¹�
			n = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				word = st.nextToken();	// ���� �ܾ�
				if (i != 0) {
					// �ߺ� �ܾ �ƴϸ� �����ձⰡ �����̸�
					if (set.add(word) && word.charAt(0) == sb.charAt(sb.length() - 1))
						sb.append(" " + word);
					else
						break;
				} else { // ù �ܾ� �߰�
					sb.append(word);
					set.add(word);
				}
			}
			System.out.println(sb.toString());
		}
	}

}
