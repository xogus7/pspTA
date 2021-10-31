package psw2;

import java.io.*;

public class p1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			int result = 0;
			String num = "";// 숫자
			char op = 0; // 연산자
			boolean error = false;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if ((i == 0 || i == s.length() - 1) && (c == 'P' || c == 'S' || c == 'T' || c == 'V')) {
					error = true; // 맨 앞, 맨 뒤가 연산자일 경우
					break;
				}
				if (c <= 'J' && c >= 'A') { // s의 i번째 글자가 알파벳일 경우
					if (num == "" && c == 'A') // 처음 숫자가 0이면 넘김
						continue;
					num += c - 'A'; // 숫자 저장 BD의 경우 num : "1"
									// num : "12" 과 같은 순서를 문자열 행태로 저장
				} else { // 연산자가 들어온 경우
					if (op == 0) { // 처음으로 연산자가 들어왔다면 연산에는 숫자가 두개 필요하므로
						if (num == "") { // 앞에 들어온 숫자가 없으면 error
							error = true;
							break;
						}
						op = c; // 현재 들어온 연산자 저장
						result = Integer.parseInt(num); // 연산자가 들어왔다면 숫자의 입력도 끝이므로
						num = ""; // 현재까지 문자열로 저장한 숫자를 int로 변환 후 num초기화

					} else if (num != "") { // 이미 이전에 입력이 있었다면 아니고 숫자도 저장된게 있다면
						result = calculate(result, Integer.parseInt(num), op); // 이전 숫자, 이전 연산자, 현재 숫자를 이용해 계산
						num = "";
						op = c; // 현재 입력된 연산자를 저장
					} else {
						error = true;
						break;
					}
				}
				if (i == s.length() - 1 && num != "")	//문자열 끝이 숫자로 끝났고
					if (op == 0)						// 연산자가 단 한번도 등장하지 않았다면
						result = Integer.parseInt(num);	// 그냥 결과 저장
					else								// 아니면 마지막 계산하기
						result = calculate(result, Integer.parseInt(num), op);
			}
			if (!error)
				System.out.println(result);
			else
				System.out.println("Error");
		}
	}

	public static int calculate(int n, int m, char op) {
		if (op == 'P')
			return n + m;
		else if (op == 'S')
			return n - m;
		else if (op == 'T')
			return n * m;
		else
			return n / m;
	}
}
