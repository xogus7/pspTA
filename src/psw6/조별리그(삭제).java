import java.util.*;

class Team implements Comparable<Team> {
	String name;
	int win, lose, GF, GA;
	Map<String, Integer> match = new HashMap<>();

	public Team(String name) {
		this.name = name;
		win = 0;
		lose = 0;
		GF = 0;
		GA = 0;
	}

	public int compareTo(Team o) {
		if (o.win == win) {
			if ((o.GF - o.GA) == (GF - GA))
				return o.match.get(name) - match.get(o.name);
			return (o.GF - o.GA) - (GF - GA);
		}
		return o.win - win;
	}

	public String toString() {
		return name + " " + win + " " + lose + " " + GF + "-" + GA + " " + (GF - GA);
	}
}

public class Main { // 조별리그

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		List<Team> list = new ArrayList<>();
		for (int i = 0; i < n; i++)
			list.add(new Team(input.next()));
		while (input.hasNext()) {
			int team1 = 0, team2 = 0;
			String name1 = input.next();
			String[] score = input.next().split(":");
			String name2 = input.next();
			int s1 = Integer.parseInt(score[0]);
			int s2 = Integer.parseInt(score[1]);
			for (int i = 0; i < n; i++) {
				if (list.get(i).name.equals(name1))
					team1 = i;
				if (list.get(i).name.equals(name2))
					team2 = i;
			}
			if (s1 > s2) {
				list.get(team1).win++;
				list.get(team2).lose++;
				list.get(team1).match.put(name2, 1);
				list.get(team2).match.put(name1, 0);
			} else {
				list.get(team2).win++;
				list.get(team1).lose++;
				list.get(team2).match.put(name1, 1);
				list.get(team1).match.put(name2, 0);
			}
			list.get(team1).GF += s1;
			list.get(team1).GA += s2;
			list.get(team2).GF += s2;
			list.get(team2).GA += s1;
		}
		Collections.sort(list);
		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + ") " + list.get(i));
		}
	}
}
