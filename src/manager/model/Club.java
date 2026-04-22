package manager.model;

import java.util.ArrayList;

public class Club {

	private String name;
	private ArrayList<Player> squad;

	private int points;
	private int goalsFor;
	private int goalsAgainst;
	private int wins;
	private int draws;
	private int losses;

	public Club(String name) {
		this.name = name;
		this.squad = new ArrayList<>();

		this.points = 0;
		this.goalsFor = 0;
		this.goalsAgainst = 0;
		this.wins = 0;
		this.draws = 0;
		this.losses = 0;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Player> getSquad() {
		return squad;
	}

	public int getPoints() {
		return points;
	}

	public int getGoalsFor() {
		return goalsFor;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public int getWins() {
		return wins;
	}

	public int getDraws() {
		return draws;
	}

	public int getLosses() {
		return losses;
	}

	public int getGoalDifference() {
		return goalsFor - goalsAgainst;
	}

	public void addPlayer(Player player) {
		squad.add(player);
	}

	public void showSquad() {
		System.out.println("Kader von " + name + ":");
		for (Player player : squad) {
			System.out.println(player.getName() + " - " + player.getPosition());
		}
	}

	public void updateStats(int scoredGoals, int concededGoals) {
		goalsFor += scoredGoals;
		goalsAgainst += concededGoals;

		if (scoredGoals > concededGoals) {
			wins++;
			points += 3;
		} else if (scoredGoals == concededGoals) {
			draws++;
			points += 1;
		} else {
			losses++;
		}
	}

	public void showClubStats() {
		System.out.println("Verein: " + name);
		System.out.println("Punkte: " + points);
		System.out.println("Tore: " + goalsFor + ":" + goalsAgainst);
		System.out.println("Tordifferenz: " + getGoalDifference());
		System.out.println("Siege: " + wins);
		System.out.println("Unentschieden: " + draws);
		System.out.println("Niederlagen: " + losses);
	}

	@Override
	public String toString() {
		return name;
	}
}