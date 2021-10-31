package psw2;

import java.io.*;

public class p1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			int result = 0;
			String num = "";// ����
			char op = 0; // ������
			boolean error = false;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if ((i == 0 || i == s.length() - 1) && (c == 'P' || c == 'S' || c == 'T' || c == 'V')) {
					error = true; // �� ��, �� �ڰ� �������� ���
					break;
				}
				if (c <= 'J' && c >= 'A') { // s�� i��° ���ڰ� ���ĺ��� ���
					if (num == "" && c == 'A') // ó�� ���ڰ� 0�̸� �ѱ�
						continue;
					num += c - 'A'; // ���� ���� BD�� ��� num : "1"
									// num : "12" �� ���� ������ ���ڿ� ���·� ����
				} else { // �����ڰ� ���� ���
					if (op == 0) { // ó������ �����ڰ� ���Դٸ� ���꿡�� ���ڰ� �ΰ� �ʿ��ϹǷ�
						if (num == "") { // �տ� ���� ���ڰ� ������ error
							error = true;
							break;
						}
						op = c; // ���� ���� ������ ����
						result = Integer.parseInt(num); // �����ڰ� ���Դٸ� ������ �Էµ� ���̹Ƿ�
						num = ""; // ������� ���ڿ��� ������ ���ڸ� int�� ��ȯ �� num�ʱ�ȭ

					} else if (num != "") { // �̹� ������ �Է��� �־��ٸ� �ƴϰ� ���ڵ� ����Ȱ� �ִٸ�
						result = calculate(result, Integer.parseInt(num), op); // ���� ����, ���� ������, ���� ���ڸ� �̿��� ���
						num = "";
						op = c; // ���� �Էµ� �����ڸ� ����
					} else {
						error = true;
						break;
					}
				}
				if (i == s.length() - 1 && num != "")	//���ڿ� ���� ���ڷ� ������
					if (op == 0)						// �����ڰ� �� �ѹ��� �������� �ʾҴٸ�
						result = Integer.parseInt(num);	// �׳� ��� ����
					else								// �ƴϸ� ������ ����ϱ�
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
