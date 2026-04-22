package manager.simulation;

import manager.model.Club;

public class Match {

    private Club homeClub;
    private Club awayClub;
    private int homeGoals;
    private int awayGoals;
    private boolean played;

    public Match(Club homeClub, Club awayClub) {
        this.homeClub = homeClub;
        this.awayClub = awayClub;
        this.homeGoals = -1;
        this.awayGoals = -1;
        this.played = false;
    }

    public Club getHomeClub() {
        return homeClub;
    }

    public Club getAwayClub() {
        return awayClub;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setResult(int homeGoals, int awayGoals) {
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.played = true;
    }

    @Override
    public String toString() {
        if (played) {
            return homeClub.getName() + " " + homeGoals + " : " + awayGoals + " " + awayClub.getName();
        }
        return homeClub.getName() + " vs. " + awayClub.getName();
    }
}