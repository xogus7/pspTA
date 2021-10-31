package psw2;

import java.io.*;
import java.util.*;

public class p3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			Map<String, Integer> map = new HashMap<String, Integer>(); // map���� �󵵼� ����
			List<String> list = new ArrayList<String>(); // �󵵼��� ���� bigram��
			String bigram = "";
			int max = 0;
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) != ' ' && s.charAt(i + 1) != ' ' && s.charAt(i) != ',' && s.charAt(i + 1) != ',' ) {
					bigram = s.substring(i, i + 2); // ���ĺ� �� ���ھ� �ڸ���
					if (map.containsKey(bigram))	// ������ �̹� ���� �ߴٸ�
						map.put(bigram, map.get(bigram) + 1); // �󵵼� ����
					else
						map.put(bigram, 1);	// ������ map�� �߰�
				}
			}
			if(max <= 1) {
				System.out.println("Not present");
				continue;
			}
			// ���� ���� ������ bigram���� list�� �߰�
			for (String key : map.keySet()) {
				int value = map.get(key);
				if (value == max)
					list.add(key);
			}
			Collections.sort(list);	// ���������� ����
			for(int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
				if(i != list.size() - 1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
