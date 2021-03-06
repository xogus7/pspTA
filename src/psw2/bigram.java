import java.io.*;
import java.util.*;

public class Main {	// bigram

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			Map<String, Integer> map = new HashMap<String, Integer>(); // map통해 빈도수 세기
			List<String> list = new ArrayList<String>(); // 빈도수가 같은 bigram들
			String bigram = "";
			int max = 0;
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) != ' ' && s.charAt(i + 1) != ' ' && s.charAt(i) != ',' && s.charAt(i + 1) != ',' ) {
					bigram = s.substring(i, i + 2); // 알파벳 두 글자씩 자르기
					if (map.containsKey(bigram))	// 이전에 이미 등장 했다면
						map.put(bigram, map.get(bigram) + 1); // 빈도수 증가
					else
						map.put(bigram, 1);	// 없으면 map에 추가
				}
			}
			if(max <= 1) {
				System.out.println("Not present");
				continue;
			}
			// 가장 많이 등장한 bigram들을 list에 추가
			for (String key : map.keySet()) {
				int value = map.get(key);
				if (value == max)
					list.add(key);
			}
			Collections.sort(list);	// 사전순으로 정렬
			for(int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
				if(i != list.size() - 1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
