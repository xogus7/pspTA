package psw6;

import java.util.*;

public class p1 {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String name, s;
		int d, m, y, value;
		List<Product> list = new ArrayList<>(); // ������ �ķ�ǰ
		for (int i = 0; i < n; i++) {
			name = input.next(); // ��ǰ��
			s = input.next();	 // �������
			d = Integer.parseInt(s.split("/")[0]);
			m = Integer.parseInt(s.split("/")[1]);
			y = Integer.parseInt(s.split("/")[2]);
			value = y * 10000 + m * 100 + d; 	// String : 29/10/2017 -> int : 20171029
			if (value < 20171019) // 2017�� 10�� 19�� ������ ���� x
				continue;
			list.add(new Product(name, d, m, y, value)); 
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
class Product implements Comparable<Product> {
	private String name;
	private int day, month, year, value;
	public Product(String name, int day, int month, int year, int value) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
		this.value = value;
	}
	public int compareTo(Product o) {
		if (this.name.compareTo(o.name) == 0) { // �̸��� ������
			return this.value - o.value;		// ������� ��������
		}
		return this.name.compareTo(o.name); // �̸� ������
	}
	public String toString() {
		return this.name + " " + this.day + "/" + this.month + "/" + this.year;
	}
}
