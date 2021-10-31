package psw5;

import java.io.*;
import java.util.*;

public class p3 {
	private static final String plainText = "the quick brown fox jumps over the lazy dog";
	private static String[] plainWord;
	private static String[] encryptedWord;
	private static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] encrypted = new int[26]; // ��ȣȭ : �� -> ��ȣ�� ex) en[b] = h
		int[] decrypted = new int[26]; // ��ȣȭ : ��ȣ�� -> ��
		String line = br.readLine();
		for (int i = 0; i < line.length(); i++) { // ù���� ��ȣȭ ��Ʈ ����
			if (line.charAt(i) == '?' || line.charAt(i) == ' ')
				continue;
			encrypted[plainText.charAt(i) - 'a'] = line.charAt(i);
			decrypted[line.charAt(i) - 'a'] = plainText.charAt(i);
		}
		n = Integer.parseInt(br.readLine()); // �ܾ� ����
		plainWord = new String[n];			 // ��ȣȭ���� ���� �ܾ�
		encryptedWord = new String[n];		 // ��ȣȭ�� �ܾ�
		StringTokenizer st = new StringTokenizer(br.readLine()); // ���� ���� ���ڿ� �ڸ���
		for (int i = 0; i < n; i++)			 // �� �ܾ� �迭�� �ֱ�
			plainWord[i] = st.nextToken();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			encryptedWord[i] = st.nextToken();
		matched(encrypted, decrypted, 0); // ��Ī ����
	}

	public static boolean matched(int[] encrypted, int[] decrypted, int depth) {
		int[] tempEn = new int[26]; // ��ȣȭ ���� ���θ� �Ǵ��� �ӽ� �迭
		int[] tempDe = new int[26];

		if (depth == n) { // ���� ���� = �ܾ� ���� -> ��� �ܾ� ��ȣȭ �Ϸ�
			for (int i = 0; i < plainText.length(); i++)
				if (plainText.charAt(i) == ' ')
					System.out.print(' ');
				else // ��ȣȭ �迭�� ���� ���� ��ȣȭ
					System.out.print((char) encrypted[plainText.charAt(i) - 'a']);
			return true; // ����Լ� ����
		}
		
		for (int i = 0; i < n; i++) {
			boolean done = true; // ��ȣȭ ���� �Ǵ� ����
			if (plainWord[depth].length() == encryptedWord[i].length()) { // �� �ܾ��� ���̰� ������ ��Ī �õ�
				tempEn = encrypted.clone(); // ������� ��ȣȭ �� ���� ������
				tempDe = decrypted.clone(); // Deep Copy�� �ӽ� ����
				
				// depth��° �ܾ�� i��° �ܾ��� ��ȣȭ �õ�
				for (int j = 0; j < plainWord[depth].length(); j++) { 
					int index = plainWord[depth].charAt(j) - 'a';
					int index2 = encryptedWord[i].charAt(j) - 'a';
					
					if ((tempEn[index] != 0 && tempEn[index] != encryptedWord[i].charAt(j))
							|| (tempDe[index2] != 0 && tempDe[index2] != plainWord[depth].charAt(j))) {
						done = false; // �Ұ����ϸ�
						break; 		  // ��ȣȭ�� i+1 �ܾ�� ��Ī �õ�
					} else {
						tempEn[index] = encryptedWord[i].charAt(j); // ���� �ܾ��� j��° ���� ��ȣȭ
						tempDe[index2] = plainWord[depth].charAt(j);
					}
				}
				if (done && matched(tempEn, tempDe, depth + 1)) // ������ �Ϸ�ƴٸ� ������� ������ ��ȣȭ�� �����ϰ� depth+1 ��° �ܾ� ��Ī ����
					return true;
			}
		} 			  // depth��° �ܾ ���� ��ȣȭ�� �ܾ�� ��Ī ������ ��찡 ���ٸ�
		return false; // ���� �ܾ���� ��ġ�� ������ �ƴϹǷ� �Լ��� �����ϰ�
	} 				  // depth - 1 ��° �ܾ� ��Ī�� �ٸ� �ܾ�� �õ�
}