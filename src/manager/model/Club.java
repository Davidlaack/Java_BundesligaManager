package manager.model;

import java.util.ArrayList;

// Die Klasse Club repräsentiert einen Fußballverein
public class Club {

    // Name des Vereins
    private String name;

    // Liste aller Spieler im Kader
    private ArrayList<Player> squad;

    // Statistiken des Vereins
    private int points;        // Punkte in der Tabelle
    private int goalsFor;      // geschossene Tore
    private int goalsAgainst;  // kassierte Tore
    private int wins;          // Anzahl Siege
    private int draws;         // Anzahl Unentschieden
    private int losses;        // Anzahl Niederlagen

    // Aktuelle Aufstellung (z.B. Startelf)
    private Lineup currentLineup;

    // Konstruktor: Initialisiert einen neuen Club mit Namen und leeren Werten
    public Club(String name) {
        this.name = name;
        this.squad = new ArrayList<>();

        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.currentLineup = null;
    }

    // Getter für den Vereinsnamen
    public String getName() {
        return name;
    }

    // Gibt die komplette Spielerliste zurück
    public ArrayList<Player> getSquad() {
        return squad;
    }

    // Getter für Punkte
    public int getPoints() {
        return points;
    }

    // Getter für geschossene Tore
    public int getGoalsFor() {
        return goalsFor;
    }

    // Getter für kassierte Tore
    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    // Getter für Siege
    public int getWins() {
        return wins;
    }

    // Getter für Unentschieden
    public int getDraws() {
        return draws;
    }

    // Getter für Niederlagen
    public int getLosses() {
        return losses;
    }

    // Berechnet die Tordifferenz (Tore für - Tore gegen)
    public int getGoalDifference() {
        return goalsFor - goalsAgainst;
    }

    // Fügt einen Spieler zum Kader hinzu
    public void addPlayer(Player player) {
        squad.add(player);
    }

    // Gibt den gesamten Kader in der Konsole aus
    public void showSquad() {
        System.out.println("Kader von " + name + ":");
        for (Player player : squad) {
            System.out.println(player.getName() + " - " + player.getPosition());
        }
    }

    // Aktualisiert die Statistik nach einem Spiel
    public void updateStats(int scoredGoals, int concededGoals) {
        goalsFor += scoredGoals;
        goalsAgainst += concededGoals;

        // Spielausgang auswerten
        if (scoredGoals > concededGoals) {
            wins++;
            points += 3; // Sieg = 3 Punkte
        } else if (scoredGoals == concededGoals) {
            draws++;
            points += 1; // Unentschieden = 1 Punkt
        } else {
            losses++; // Niederlage = 0 Punkte
        }
    }

    // Gibt alle Vereinsstatistiken in der Konsole aus
    public void showClubStats() {
        System.out.println("Verein: " + name);
        System.out.println("Punkte: " + points);
        System.out.println("Tore: " + goalsFor + ":" + goalsAgainst);
        System.out.println("Tordifferenz: " + getGoalDifference());
        System.out.println("Siege: " + wins);
        System.out.println("Unentschieden: " + draws);
        System.out.println("Niederlagen: " + losses);
    }

    // Getter für die aktuelle Aufstellung
    public Lineup getCurrentLineup() {
        return currentLineup;
    }

    // Setter für die aktuelle Aufstellung
    public void setCurrentLineup(Lineup currentLineup) {
        this.currentLineup = currentLineup;
    }

    // Überschreibt toString(), damit einfach der Vereinsname ausgegeben wird
    @Override
    public String toString() {
        return name;
    }
}