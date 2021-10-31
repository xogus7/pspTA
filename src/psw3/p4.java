package psw3;

import java.io.*;
import java.util.*;

// ���̵� ���� p3 ����, �ش� ���� p1���� �߰� p1 -> p2, p2 -> p3
public class p4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null) {
			Deque<Character> d = new ArrayDeque<>();
			for(int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if(c == '*') {		// *�� �ԷµǸ�
					if(!d.isEmpty()) d.pollLast(); // �ֱٿ� ���� �� �̱�
				} else
					if(d.size() < 10) d.add(c);		// ī�� �߰�
			}
			while(!d.isEmpty())
				System.out.print(d.poll());		// �տ������� ���
			System.out.println();
		}
	}
}
