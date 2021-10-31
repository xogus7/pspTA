package psw3;

import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		char[] guests = new char[n];	// i��° �ڸ��� �ɾ� �ִ� �մ��� �̸�
		int[] seats = new int[n];		// i��° �ڸ��� �ɾ� �ִ� �մ��� ���� ��ȣ
		int order = 0;	// ���� ����
		int out = 0;	// ���� ������ �ϴ� ��ȣ
		for (int i = 0; i < n; i++)
			guests[i] = '#';
		input.nextLine();
		String s = input.nextLine();
		for (int i = 0; i < s.length(); i += 2) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {			// �մ��� �� ���
				for (int j = 0; j < n; j++) {
					if (guests[j] == '#') {		// ���ڸ� ã�Ƽ� �ɱ�
						guests[j] = c;
						seats[j] = order++;		// ���� �ڸ��� ���� ���
						break;
					}
				}
			}
			else {
				for (int j = 0; j < n; j++) {
					if (seats[j] == out) {		// ������ �ϴ� ��ȣ�� ã��
						guests[j] = '#';		// ���ڸ��� �����
						out++;
						break;
					}
				}
			}
		}
		for (int i = 0; i < n; i++)
			System.out.print(guests[i] + " ");
	}

}
