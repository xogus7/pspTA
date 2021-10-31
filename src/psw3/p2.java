package psw3;

import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		char[] guests = new char[n];	// i번째 자리에 앉아 있는 손님의 이름
		int[] seats = new int[n];		// i번째 자리에 앉아 있는 손님의 입장 번호
		int order = 0;	// 들어온 순서
		int out = 0;	// 현재 나가야 하는 번호
		for (int i = 0; i < n; i++)
			guests[i] = '#';
		input.nextLine();
		String s = input.nextLine();
		for (int i = 0; i < s.length(); i += 2) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {			// 손님이 온 경우
				for (int j = 0; j < n; j++) {
					if (guests[j] == '#') {		// 빈자리 찾아서 앉기
						guests[j] = c;
						seats[j] = order++;		// 앉은 자리에 순서 기록
						break;
					}
				}
			}
			else {
				for (int j = 0; j < n; j++) {
					if (seats[j] == out) {		// 나가야 하는 번호를 찾고
						guests[j] = '#';		// 빈자리로 만들기
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
