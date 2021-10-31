package psw6;

import java.util.*;

class Point implements Comparable<Point> {
	int x, y, distance;

	public Point(int x, int y, int vitoX, int vitoY) {
		this.x = x;
		this.y = y;
		this.distance = Math.abs(x - vitoX) + Math.abs(y - vitoY); // ������� �Ÿ�
	}

	public int compareTo(Point o) { // ��ü ���� ���� ������
		return this.distance - o.distance; // �̵��Ÿ� ��������
	}

	public String toString() {
		return this.x + " " + this.y;
	}
}

public class p2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); // �� ��
		int m = input.nextInt(); // ��� �� ��
		int[] x = new int[n];
		int[] y = new int[n];
		int sum = 0;	// �Ÿ� �� ��
		Point[] point = new Point[n]; // �� ���� ��ǥ
		for (int i = 0; i < n; i++) {
			x[i] = input.nextInt();
			y[i] = input.nextInt();
		}
		int vitoX = quickSort(x.clone()); // ģô���� x��ǥ �߾Ӱ�
		int vitoY = quickSort(y.clone()); // y��ǥ �߾Ӱ�
		for (int i = 0; i < n; i++) {
			point[i] = new Point(x[i], y[i], vitoX, vitoY); // ģ���� ��ǥ �Է�
			sum += point[i].distance;						// �Ÿ� ���ϱ�
		}
		Arrays.sort(point);	// �������� ���ش�� ����
		System.out.println(sum);
		for (int i = 0; i < m; i++)
			System.out.println(point[i]);
	}

	/* quickSort ���� return: �߾Ӱ� */
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static int partition(int[] a, int left, int right) {
		int pivot = a[(left + right) / 2];
		while (left <= right) {
			while (a[left] < pivot)
				left++;
			while (a[right] > pivot)
				right--;
			if (left <= right) {
				swap(a, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void sort(int[] a, int left, int right) {
		if (left >= right)
			return;
		int mid = partition(a, left, right);
		sort(a, left, mid - 1);
		sort(a, mid, right);
	}

	public static int quickSort(int[] a) {
		sort(a, 0, a.length - 1);
		return a[a.length / 2];
	}
}