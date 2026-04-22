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
        createFullSchedule();
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

    public Matchday getCurrentMatchdayObject() {
        if (currentMatchday < matchdays.size()) {
            return matchdays.get(currentMatchday);
        }
        return null;
    }

    public void showAllClubs() {
        System.out.println("Bundesliga-Clubs:");
        for (Club club : clubs) {
            System.out.println("- " + club.getName());
        }
    }

    private void createFullSchedule() {
        ArrayList<Club> teams = new ArrayList<>(clubs);
        int teamCount = teams.size();

        if (teamCount % 2 != 0) {
            return;
        }

        int rounds = teamCount - 1;
        int matchesPerRound = teamCount / 2;

        ArrayList<Club> rotatingTeams = new ArrayList<>(teams);

        for (int round = 0; round < rounds; round++) {
            Matchday matchday = new Matchday(round + 1);

            for (int i = 0; i < matchesPerRound; i++) {
                Club home = rotatingTeams.get(i);
                Club away = rotatingTeams.get(teamCount - 1 - i);

                if (round % 2 == 0) {
                    matchday.addMatch(new Match(home, away));
                } else {
                    matchday.addMatch(new Match(away, home));
                }
            }

            matchdays.add(matchday);

            Club fixed = rotatingTeams.get(0);
            Club last = rotatingTeams.remove(rotatingTeams.size() - 1);
            rotatingTeams.add(1, last);
            rotatingTeams.set(0, fixed);
        }

        for (int round = 0; round < rounds; round++) {
            Matchday firstHalf = matchdays.get(round);
            Matchday secondHalf = new Matchday(round + 1 + rounds);

            for (Match match : firstHalf.getMatches()) {
                secondHalf.addMatch(new Match(match.getAwayClub(), match.getHomeClub()));
            }

            matchdays.add(secondHalf);
        }
    }

    public Club findClubByName(String name) {
        for (Club club : clubs) {
            if (club.getName().equals(name)) {
                return club;
            }
        }
        return null;
    }

    public Match getNextMatchForClub(Club club) {
        if (currentMatchday >= matchdays.size()) {
            return null;
        }

        Matchday matchday = matchdays.get(currentMatchday);

        for (Match match : matchday.getMatches()) {
            if (match.getHomeClub().equals(club) || match.getAwayClub().equals(club)) {
                return match;
            }
        }

        return null;
    }

    public void showTable() {
        ArrayList<Club> table = new ArrayList<>(clubs);

        table.sort((club1, club2) -> {
            if (club2.getPoints() != club1.getPoints()) {
                return club2.getPoints() - club1.getPoints();
            }
            return club2.getGoalDifference() - club1.getGoalDifference();
        });

        System.out.println("\n===== TABELLE =====");
        for (int i = 0; i < table.size(); i++) {
            Club club = table.get(i);
            System.out.println(
                (i + 1) + ". " +
                club.getName() +
                " | Punkte: " + club.getPoints() +
                " | Tore: " + club.getGoalsFor() + ":" + club.getGoalsAgainst() +
                " | Diff: " + club.getGoalDifference()
            );
        }
    }

    public int getTablePosition(Club userClub) {
        ArrayList<Club> table = new ArrayList<>(clubs);

        table.sort((club1, club2) -> {
            if (club2.getPoints() != club1.getPoints()) {
                return club2.getPoints() - club1.getPoints();
            }
            return club2.getGoalDifference() - club1.getGoalDifference();
        });

        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).equals(userClub)) {
                return i + 1;
            }
        }

        return -1;
    }

    public void nextMatchday() {
        currentMatchday++;

        if (currentMatchday >= matchdays.size()) {
            System.out.println("Die Saison ist beendet.");
        }
    }
}