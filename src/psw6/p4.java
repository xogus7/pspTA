package psw6;

import java.util.*;

class Location implements Comparable<Location> {
	int x, y, d, order;
	public Location(int x, int y, int pX, int pY,int order) {
		this.x = x;
		this.y = y;
		this.d = Math.abs(x - pX) + Math.abs(y - pY);	// �������� �Ÿ�
		this.order = order;								// �Էµ� ����
	}
	public int compareTo(Location o) { // ��ü ���� ���� ������
		if(o.d == this.d)
			return o.order - this.order;	// ���� ��������
		return o.d - this.d;				// �Ÿ��� �� ��찡 ���������� �Ÿ� ��������
	}
	public String toString() { return this.x + " " + this.y; }
}
public class p4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		List<Location> point = new ArrayList<>(); // ������ ��ǥ ����Ʈ
		int sum = 0;
		for (int i = 0; i < n; i++) {
			x[i] = input.nextInt();
			y[i] = input.nextInt();
		}
		/* �ӽ� �迭�� ���̺귯�� �Լ��� ���� �� �߾Ӱ� ���� */
		int[] tempX = x.clone();
		int[] tempY = y.clone();
		Arrays.sort(tempX);
		Arrays.sort(tempY);
		int pumpX = tempX[n/2];
		int pumpY = tempY[n/2];
		
		for (int i = 0; i < n; i++) { // �� ���� ��ǥ�� �Ÿ�, �Է� ������ ����Ʈ�� �߰�
			point.add(new Location(x[i], y[i], pumpX, pumpY, i)); 
			sum += point.get(i).d;
		}
		Collections.sort(point); // �������� ���ش�� ����
		System.out.println(sum);
		for (int i = 0; i < n; i++)
			if (point.get(i).d > m)
				System.out.println(point.get(i));
	}
}