package manager.simulation;

import manager.model.Club;

public class Match {

	private Club homeClub;
	private Club awayClub;
	private boolean played;

	public Match(Club homeClub, Club awayClub) {
		this.homeClub = homeClub;
		this.awayClub = awayClub;
		this.played = false;
	}

	public Club getHomeClub() {
		return homeClub;
	}

	public Club getAwayClub() {
		return awayClub;
	}

	public boolean isPlayed() {
		return played;
	}

	public void setPlayed(boolean played) {
		this.played = played;
	}

	@Override
	public String toString() {
		return homeClub.getName() + " vs. " + awayClub.getName();
	}
}