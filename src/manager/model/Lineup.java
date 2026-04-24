package manager.model;

import java.util.ArrayList;

// Die Klasse Lineup repräsentiert die Startaufstellung eines Clubs
public class Lineup {

    // Referenz auf den zugehörigen Verein
    private Club club;

    // Formation als String (z.B. "4-4-2")
    private String formation;

    // Liste der Spieler in der Startelf (max. 11 Spieler)
    private ArrayList<Player> startingEleven;

    // Konstruktor: erstellt eine neue Aufstellung für einen Club mit Formation
    public Lineup(Club club, String formation) {
        this.club = club;
        this.formation = formation;
        this.startingEleven = new ArrayList<>();
    }

    // Getter für den Club
    public Club getClub() {
        return club;
    }

    // Getter für die Formation
    public String getFormation() {
        return formation;
    }

    // Gibt die komplette Startelf zurück
    public ArrayList<Player> getStartingEleven() {
        return startingEleven;
    }

    // Fügt einen Spieler zur Startelf hinzu
    public void addPlayer(Player player) {
        startingEleven.add(player);
    }

    // Prüft, ob ein bestimmter Spieler bereits in der Startelf ist
    public boolean containsPlayer(Player player) {
        return startingEleven.contains(player);
    }
    
    // Hilfsmethoden für Spiel-Logik
    // Diese Methoden werden in der Game-Klasse verwendet,
    // um abhängig von der Formation die benötigte Anzahl an Spielern
    // pro Position zu bestimmen

    // Gibt die Anzahl der Verteidiger zurück
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
                return 0; // ungültige Formation
        }
    }

    // Gibt die Anzahl der benötigten Mittelfeldspieler zurück
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

    // Gibt die Anzahl der benötigten Stürmer zurück
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

    // Gibt die komplette Startelf in der Konsole aus
    public void showLineup() {
        System.out.println("Startelf von " + club.getName());
        System.out.println("Formation: " + formation);

        // Iteriert über alle Spieler und gibt sie aus
        // (nutzt die toString()-Methode der Player-Klasse)
        for (Player player : startingEleven) {
            System.out.println(player);
        }
    }
}