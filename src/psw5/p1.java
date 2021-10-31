package psw5;

import java.io.*;

public class p1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder eng = new StringBuilder();
		StringBuilder kor = new StringBuilder();
		int engN = 0;
		int korN = 0;
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) < 123) {
				engN++;
				eng.append(s.charAt(i));
			}
			else {
				korN++;
				kor.append(s.charAt(i));
			}
		System.out.println(eng.toString() + kor.toString());
		System.out.print(engN + " " + korN + " " + s.length());
	}
}