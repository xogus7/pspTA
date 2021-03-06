import java.util.*;

class Point implements Comparable<Point> {
	int x, y, distance;
	public Point(int x, int y, int vitoX, int vitoY) {
		this.x = x;
		this.y = y;
		this.distance = Math.abs(x - vitoX) + Math.abs(y - vitoY); // 비토와의 거리
	}
	public int compareTo(Point o) { // 객체 정렬 기준 재정의
		return this.distance - o.distance; // 이동거리 오름차순
	}
	public String toString() { return this.x + " " + this.y; }
}

public class Main { // 비토와 친척들 2

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); // 집 수
		int m = input.nextInt(); // 출력할 수
		int[] x = new int[n];
		int[] y = new int[n];
		int sum = 0;	// 거리 총 합
		Point[] point = new Point[n]; // 각 집의 좌표
		for (int i = 0; i < n; i++) {
			x[i] = input.nextInt();
			y[i] = input.nextInt();
		}
		int vitoX = quickSort(x.clone()); // 친척집의 x좌표 중앙값
		int vitoY = quickSort(y.clone());          // y좌표 중앙값
		for (int i = 0; i < n; i++) {
			point[i] = new Point(x[i], y[i], vitoX, vitoY); // 친적집 좌표 입력
			sum += point[i].distance;			// 거리 더하기
		}
		Arrays.sort(point);	// 재정의한 기준대로 정렬
		System.out.println(sum);
		for (int i = 0; i < m; i++)
			System.out.println(point[i]);
	}

	/* quickSort 직접 구현 return: 중앙값 */
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
