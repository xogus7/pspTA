import java.io.*;
import java.util.*;

public class Main { // 암호 마저 깨기
	private static final String plainText = "the quick brown fox jumps over the lazy dog";
	private static String[] plainWord;
	private static String[] encryptedWord;
	private static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] encrypted = new int[26]; // 암호화 : 평문 -> 암호문 ex) en[b] = h
		int[] decrypted = new int[26]; // 복호화 : 암호문 -> 평문
		String line = br.readLine();
		for (int i = 0; i < line.length(); i++) { // 첫줄의 암호화 힌트 저장
			if (line.charAt(i) == '?' || line.charAt(i) == ' ')
				continue;
			encrypted[plainText.charAt(i) - 'a'] = line.charAt(i);
			decrypted[line.charAt(i) - 'a'] = plainText.charAt(i);
		}
		n = Integer.parseInt(br.readLine()); // 단어 개수
		plainWord = new String[n];			 // 암호화되지 않은 단어
		encryptedWord = new String[n];		 // 암호화된 단어
		StringTokenizer st = new StringTokenizer(br.readLine()); // 공백 기준 문자열 자르기
		for (int i = 0; i < n; i++)			 // 각 단어 배열에 넣기
			plainWord[i] = st.nextToken();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			encryptedWord[i] = st.nextToken();
		matched(encrypted, decrypted, 0); // 매칭 시작
	}

	public static boolean matched(int[] encrypted, int[] decrypted, int depth) {
		int[] tempEn = new int[26]; // 암호화 가능 여부를 판단할 임시 배열
		int[] tempDe = new int[26];

		if (depth == n) { // 현재 깊이 = 단어 개수 -> 모든 단어 암호화 완료
			for (int i = 0; i < plainText.length(); i++)
				if (plainText.charAt(i) == ' ')
					System.out.print(' ');
				else // 암호화 배열을 통해 평문을 암호화
					System.out.print((char) encrypted[plainText.charAt(i) - 'a']);
			return true; // 재귀함수 종료
		}
		
		for (int i = 0; i < n; i++) {
			boolean done = true; // 암호화 가능 판단 여부
			if (plainWord[depth].length() == encryptedWord[i].length()) { // 각 단어의 길이가 같으면 매칭 시도
				tempEn = encrypted.clone(); // 현재까지 암호화 한 이전 과정을
				tempDe = decrypted.clone(); // Deep Copy로 임시 저장
				
				// depth번째 단어와 i번째 단어의 암호화 시도
				for (int j = 0; j < plainWord[depth].length(); j++) { 
					int index = plainWord[depth].charAt(j) - 'a';
					int index2 = encryptedWord[i].charAt(j) - 'a';
					
					if ((tempEn[index] != 0 && tempEn[index] != encryptedWord[i].charAt(j))
							|| (tempDe[index2] != 0 && tempDe[index2] != plainWord[depth].charAt(j))) {
						done = false; // 불가능하면
						break; 		  // 암호화된 i+1 단어와 매칭 시도
					} else {
						tempEn[index] = encryptedWord[i].charAt(j); // 현재 단어의 j번째 글자 암호화
						tempDe[index2] = plainWord[depth].charAt(j);
					}
				}
				if (done && matched(tempEn, tempDe, depth + 1)) // 무사히 완료됐다면 현재까지 진행한 암호화를 전달하고 depth+1 번째 단어 매칭 시작
					return true;
			}
		} 	      // depth번째 단어가 남은 암호화된 단어와 매칭 가능한 경우가 없다면
		return false; // 이전 단어들의 매치가 정답이 아니므로 함수를 종료하고
	} 		      // depth - 1 번째 단어 매칭을 다른 단어와 시도
}
