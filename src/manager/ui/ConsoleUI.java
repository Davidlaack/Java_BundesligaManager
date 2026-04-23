package manager.ui;

import manager.model.Club;
import manager.model.Lineup;
import manager.season.Season;
import manager.simulation.Match;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner = new Scanner(System.in);

    // ==================== AUSGABE ====================

    public void showWelcome() {
        System.out.println("============================================");
        System.out.println("     Willkommen zum Bundesliga Manager");
        System.out.println("============================================");
    }

    public void displayClubSelection(List<Club> clubs) {
        System.out.println("\nWähle den Verein, den du diese Saison managen möchtest:\n");
        for (int i = 0; i < clubs.size(); i++) {
            System.out.println((i + 1) + ". " + clubs.get(i).getName());
        }
    }

    public void showMainMenu(String userClubName) {
        System.out.println("\n========== HAUPTMENÜ ==========");
        System.out.println("Dein Verein: " + userClubName);
        System.out.println("1. Meinen Kader anzeigen");
        System.out.println("2. Nächstes Spiel anzeigen");
        System.out.println("3. Tabellenplatz anzeigen");
        System.out.println("4. Ganze Tabelle anzeigen");
        System.out.println("5. Aktuellen Spieltag anzeigen");
        System.out.println("6. Startelf festlegen");
        System.out.println("7. Aktuelle Startelf anzeigen");
        System.out.println("8. Nächsten Spieltag spielen");
        System.out.println("0. Spiel beenden");
        System.out.print("Auswahl: ");
    }

    public void showNextMatch(Match match) {
        if (match == null) {
            System.out.println("Für deinen Verein gibt es aktuell kein geplantes Spiel.");
        } else {
            System.out.println("Nächstes Spiel von " + match.getHomeClub().getName() + ":");
            System.out.println(match);
        }
    }

    public void showUserClubPosition(String clubName, int position) {
        System.out.println("Aktueller Tabellenplatz von " + clubName + ": " + position);
    }

    public void showCurrentLineup(Lineup lineup) {
        if (lineup == null) {
            System.out.println("Du hast noch keine Startelf festgelegt.");
        } else {
            lineup.showLineup();
        }
    }

    public void showMatchdayHeader(int matchdayNumber) {
        System.out.println("\n===== SPIELTAG " + matchdayNumber + " =====");
    }

    public void showMatchResult(Match match) {
        System.out.println(match);
    }

    public void showNoMoreMatchdays() {
        System.out.println("Es gibt keinen weiteren Spieltag mehr.");
    }

    // ==================== EINGABE ====================

    public int getIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Bitte eine Zahl zwischen %d und %d eingeben.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Bitte gib eine gültige Zahl ein.");
            }
        }
    }

    public int chooseClubIndex(int max) {
        return getIntInput("\nDeine Auswahl: ", 1, max) - 1;
    }

    public int getMenuChoice() {
        return getIntInput("", 0, 8);
    }

    public int chooseFormation() {
        System.out.println("\nWähle eine Formation:");
        System.out.println("1. 3-4-3");
        System.out.println("2. 4-4-2");
        System.out.println("3. 5-3-2");
        System.out.println("4. 4-3-3");
        System.out.println("5. 4-5-1");
        System.out.print("Auswahl: ");
        return getIntInput("", 1, 5);
    }

    public int choosePlayer(int availableCount, int needed, int currentCount) {
        String prompt = "Wähle Spieler " + (currentCount + 1) + " von " + needed + ": ";
        return getIntInput(prompt, 1, availableCount) - 1;
    }

    // ==================== HELFER ====================

    public void pause() {
        System.out.print("\nDrücke ENTER zum Fortfahren...");
        scanner.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
    
    public void showSeasonEnd(Season season, Club userClub) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("SAISON 2025/26 BEENDET!");
        System.out.println("=".repeat(50));

        ArrayList<Club> finalTable = season.getFinalTable();

        // Meister
        Club champion = finalTable.get(0);
        System.out.println("DEUTSCHER MEISTER: " + champion.getName());
        System.out.println();

        // Komplette Tabelle
        System.out.println("===== ENDPLATZIERUNG =====");
        for (int i = 0; i < finalTable.size(); i++) {
            Club club = finalTable.get(i);
            String highlight = club.equals(userClub) ? " ← DEIN VEREIN" : "";

            System.out.printf("%2d. %-25s  %3d Punkte  %3d:%-3d  Diff %+3d%s%n",
                    i + 1,
                    club.getName(),
                    club.getPoints(),
                    club.getGoalsFor(),
                    club.getGoalsAgainst(),
                    club.getGoalDifference(),
                    highlight);
        }

        // Persönliche Zusammenfassung
        int userPosition = 0;
        for (int i = 0; i < finalTable.size(); i++) {
            if (finalTable.get(i).equals(userClub)) {
                userPosition = i + 1;
                break;
            }
        }

        System.out.println("\nDein Verein (" + userClub.getName() + ") belegt Platz " + userPosition + "!");
        
        if (userPosition == 1) {
            System.out.println("HERZLICHEN GLÜCKWUNSCH ZUM MEISTERTITEL!!!");
        } else if (userPosition <= 6) {
            System.out.println("Starke Saison – Europa-Pokal erreicht!");
        } else if (userPosition >= 16) {
            System.out.println("Abstiegskampf... nächstes Jahr besser!");
        }
    }
}