package psw5;

import java.io.*;
import java.util.*;

public class p2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n; // 단어 수
		String s; // 입력 문장
		String word;
		while ((s = br.readLine()) != null) {
			Set<String> set = new HashSet<>(); // 중복 확인
			StringTokenizer st = new StringTokenizer(s); // 입력받은 문장 공백 기준으로 자르기
			StringBuilder sb = new StringBuilder();	// 출력문
			n = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				word = st.nextToken();	// 현재 단어
				if (i != 0) {
					// 중복 단어가 아니며 끝말잇기가 성공이면
					if (set.add(word) && word.charAt(0) == sb.charAt(sb.length() - 1))
						sb.append(" " + word);
					else
						break;
				} else { // 첫 단어 추가
					sb.append(word);
					set.add(word);
				}
			}
			System.out.println(sb.toString());
		}
	}

}
