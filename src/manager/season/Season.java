package manager.season;

import java.util.ArrayList;
import manager.data.BundesligaData;
import manager.model.Club;

public class Season {

    private ArrayList<Club> clubs;

    public Season() {
        clubs = BundesligaData.createBundesligaClubs();
    }

    public ArrayList<Club> getClubs() {
        return clubs;
    }

    public void showAllClubs() {
        System.out.println("Bundesliga-Clubs:");
        for (Club club : clubs) {
            System.out.println("- " + club.getName());
        }
    }
}