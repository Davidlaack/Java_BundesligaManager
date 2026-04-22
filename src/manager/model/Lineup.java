package manager.model;

import java.util.ArrayList;

public class Lineup {

    private Club club;
    private String formation;
    private ArrayList<Player> startingEleven;

    public Lineup(Club club, String formation) {
        this.club = club;
        this.formation = formation;
        this.startingEleven = new ArrayList<>();
    }

    public Club getClub() {
        return club;
    }

    public String getFormation() {
        return formation;
    }

    public ArrayList<Player> getStartingEleven() {
        return startingEleven;
    }

    public void addPlayer(Player player) {
        startingEleven.add(player);
    }

    public boolean containsPlayer(Player player) {
        return startingEleven.contains(player);
    }

    public int getRequiredDefenders() {
        switch (formation) {
            case "3-4-3":
                return 3;
            case "4-4-2":
                return 4;
            case "5-3-2":
                return 5;
            case "4-3-3":
                return 4;
            case "4-5-1":
                return 4;
            default:
                return 0;
        }
    }

    public int getRequiredMidfielders() {
        switch (formation) {
            case "3-4-3":
                return 4;
            case "4-4-2":
                return 4;
            case "5-3-2":
                return 3;
            case "4-3-3":
                return 3;
            case "4-5-1":
                return 5;
            default:
                return 0;
        }
    }

    public int getRequiredStrikers() {
        switch (formation) {
            case "3-4-3":
                return 3;
            case "4-4-2":
                return 2;
            case "5-3-2":
                return 2;
            case "4-3-3":
                return 3;
            case "4-5-1":
                return 1;
            default:
                return 0;
        }
    }

    public void showLineup() {
        System.out.println("Startelf von " + club.getName());
        System.out.println("Formation: " + formation);

        for (Player player : startingEleven) {
            System.out.println(player);
        }
    }
}