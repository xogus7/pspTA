import java.util.*;

class Location implements Comparable<Location> {
	int x, y, d, order;
	public Location(int x, int y, int pX, int pY,int order) {
		this.x = x;
		this.y = y;
		this.d = Math.abs(x - pX) + Math.abs(y - pY);	// 펌프와의 거리
		this.order = order;				// 입력된 순서
	}
	public int compareTo(Location o) { // 객체 정렬 기준 재정의
		if(o.d == this.d)
			return o.order - this.order;	// 입력 순서 내림차순
		return o.d - this.d;			// 거리 내림차순
	}
	public String toString() { return this.x + " " + this.y; }
}
public class Main { // 수로
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		List<Location> point = new ArrayList<>(); // 집들의 좌표 리스트
		int sum = 0;
		for (int i = 0; i < n; i++) {
			x[i] = input.nextInt();
			y[i] = input.nextInt();
		}
		/* 임시 배열을 라이브러리 함수로 정렬 후 중앙값 추출 */
		int[] tempX = x.clone();
		int[] tempY = y.clone();
		Arrays.sort(tempX);
		Arrays.sort(tempY);
		int pumpX = tempX[n/2];
		int pumpY = tempY[n/2];
		
		for (int i = 0; i < n; i++) { // 각 집의 좌표와 거리, 입력 순서를 리스트에 추가
			point.add(new Location(x[i], y[i], pumpX, pumpY, i)); 
			sum += point.get(i).d;
		}
		Collections.sort(point); // 재정의한 기준대로 정렬
		System.out.println(sum);
		for (int i = 0; i < n; i++)
			if (point.get(i).d > m)
				System.out.println(point.get(i));
	}
}
