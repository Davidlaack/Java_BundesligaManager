package manager.season;

import java.util.ArrayList;
import manager.data.BundesligaData;
import manager.model.Club;
import manager.simulation.Match;

public class Season {

	private ArrayList<Club> clubs;
	private ArrayList<Matchday> matchdays;
	private int currentMatchday;

	public Season() {
		clubs = BundesligaData.createBundesligaClubs();
		matchdays = new ArrayList<>();
		currentMatchday = 0;
		createTestSchedule();
	}

	public ArrayList<Club> getClubs() {
		return clubs;
	}

	public ArrayList<Matchday> getMatchdays() {
		return matchdays;
	}

	public int getCurrentMatchday() {
		return currentMatchday;
	}

	public void nextMatchday() {
		if (currentMatchday < matchdays.size() - 1) {
			currentMatchday++;
		}
	}

	public Matchday getCurrentMatchdayObject() {
		return matchdays.get(currentMatchday);
	}

	public void showAllClubs() {
		System.out.println("Bundesliga-Clubs:");
		for (Club club : clubs) {
			System.out.println("- " + club.getName());
		}
	}

	private void createTestSchedule() {
		Matchday matchday1 = new Matchday(1);
		matchday1.addMatch(new Match(clubs.get(0), clubs.get(9)));
		matchday1.addMatch(new Match(clubs.get(1), clubs.get(2)));
		matchday1.addMatch(new Match(clubs.get(3), clubs.get(4)));

		Matchday matchday2 = new Matchday(2);
		matchday2.addMatch(new Match(clubs.get(9), clubs.get(2)));
		matchday2.addMatch(new Match(clubs.get(0), clubs.get(3)));
		matchday2.addMatch(new Match(clubs.get(4), clubs.get(1)));

		matchdays.add(matchday1);
		matchdays.add(matchday2);
	}

	public Match getNextMatchForClub(Club club) {
		if (currentMatchday >= matchdays.size()) {
			return null;
		}

		Matchday current = matchdays.get(currentMatchday);

		for (Match match : current.getMatches()) {
			if (match.getHomeClub().equals(club) || match.getAwayClub().equals(club)) {
				return match;
			}
		}

		return null;
	}
}