package manager.season;

import java.util.ArrayList;
import manager.simulation.Match;

public class Matchday {

    private int number;
    private ArrayList<Match> matches;

    public Matchday(int number) {
        this.number = number;
        this.matches = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public void showMatches() {
        System.out.println("Spieltag " + number + ":");
        for (Match match : matches) {
            System.out.println(match);
        }
    }
}