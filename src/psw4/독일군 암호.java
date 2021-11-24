import java.io.*;

public class Main { // 독일군 암호

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] list = new char[26][26];	// 알파벳을 인덱스로 바로 사용
		String index = br.readLine();		// 행 열 이름
		String s = br.readLine();		// 그 안에 채울 문자
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++)
				list[index.charAt(i) - 'A'][index.charAt(j) - 'A'] = s.charAt(i * 6 + j);
		
		while ((s = br.readLine()) != null) {
			StringBuilder sb = new StringBuilder();	// 출력문
			boolean error = false;
			s = s.toUpperCase();	// 입력된 문자열 대문자로 치환
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ' ')
					sb.append(' ');
				else {
					if (i + 1 >= s.length() || s.charAt(i) - 'A' >= 26 || s.charAt(i + 1) - 'A' >= 26) {
						error = true;	// 해독할 문자가 홀수 또는 알파벳이 아닌 경우
						System.out.println("-ERROR-");
						break;
					}
					char plain = list[s.charAt(i) - 'A'][s.charAt(i + 1) - 'A']; // 표에 따라 문자 해독
					if (plain != '\0')
						sb.append(plain);
					else {		// 알파벳이지만 행 열 이름에 없을 경우
						error = true;
						System.out.println("-ERROR-");
						break;
					}
					i++;
				}
			}
			if (!error) System.out.println(sb);
		}
	}
}
