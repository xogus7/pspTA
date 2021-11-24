import java.util.Scanner;

public class Main { // anagram

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] anagram = new int[26];
		int result = 0;
		String word1 = input.nextLine();
		String word2 = input.nextLine();
		for (int i = 0; i < word1.length(); i++)
			anagram[word1.charAt(i) - 'a']++;
		for (int i = 0; i < word2.length(); i++)
			anagram[word2.charAt(i) - 'a']--;
		for (int i = 0; i < 26; i++)
			result += (anagram[i] >= 0 ? anagram[i] : -anagram[i]);
		
		System.out.print(result);
	}
}
