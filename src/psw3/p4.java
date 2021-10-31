package psw3;

import java.io.*;
import java.util.*;

// 난이도 조정 p3 삭제, 해당 문제 p1으로 추가 p1 -> p2, p2 -> p3
public class p4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null) {
			Deque<Character> d = new ArrayDeque<>();
			for(int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if(c == '*') {		// *이 입력되면
					if(!d.isEmpty()) d.pollLast(); // 최근에 들어온 거 뽑기
				} else
					if(d.size() < 10) d.add(c);		// 카드 추가
			}
			while(!d.isEmpty())
				System.out.print(d.poll());		// 앞에서부터 출력
			System.out.println();
		}
	}
}
