package manager.ui;

import manager.model.Club;
import manager.model.Lineup;
import manager.season.Season;
import manager.simulation.Match;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Verantwortlich für die gesamte Konsolenausgabe und Benutzereingabe.
 * Trennt die UI-Logik von der Spiellogik
 * Alle Ausgaben und Eingabeabfragen laufen zentral über diese Klasse.
 */
public class ConsoleUI {

    // Scanner-Instanz für alle Benutzereingaben
    private final Scanner scanner = new Scanner(System.in);


    // Zeigt den Willkommensbildschirm beim Spielstart an.
    public void showWelcome() {
        System.out.println("============================================");
        System.out.println("     Willkommen zum Bundesliga Manager");
        System.out.println("============================================");
    }

    // Zeigt die Liste aller verfügbaren Vereine zur Auswahl an.
    public void displayClubSelection(List<Club> clubs) {
        System.out.println("\nWähle den Verein, den du diese Saison managen möchtest:\n");
        for (int i = 0; i < clubs.size(); i++) {
            System.out.println((i + 1) + ". " + clubs.get(i).getName());
        }
    }

    // Anzeige des Hauptmenüs mit Auswahloptionen
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

    // Zeigt das nächste geplante Spiel des Nutzervereins an.
    //Gibt eine Hinweismeldung aus, wenn kein Spiel mehr ansteht.
    public void showNextMatch(Match match) {
        if (match == null) {
            System.out.println("Für deinen Verein gibt es aktuell kein geplantes Spiel.");
        } else {
            System.out.println("Nächstes Spiel von " + match.getHomeClub().getName() + ":");
            System.out.println(match);
        }
    }


    // Zeigt den aktuellen Tabellenplatz des Nutzervereins an.
    public void showUserClubPosition(String clubName, int position) {
        System.out.println("Aktueller Tabellenplatz von " + clubName + ": " + position);
    }


    // Zeigt die aktuell festgelegte Startelf an.
    // Gibt einen Hinweis aus, wenn noch keine Startelf gewählt wurde.
    public void showCurrentLineup(Lineup lineup) {
        if (lineup == null) {
            System.out.println("Du hast noch keine Startelf festgelegt.");
        } else {
            lineup.showLineup();
        }
    }


    // Zeigt an, der wie vielte Spieltag aktuell ist.
    public void showMatchdayHeader(int matchdayNumber) {
        System.out.println("\n===== SPIELTAG " + matchdayNumber + " =====");
    }

    /**
     * Gibt das Ergebnis eines einzelnen Spiels auf der Konsole aus.
     * Nutzt die toString()-Methode der Match-Klasse.
     */
    public void showMatchResult(Match match) {
        System.out.println(match);
    }

    // Informiert den Nutzer, dass keine weiteren Spieltage mehr vorhanden sind.
    public void showNoMoreMatchdays() {
        System.out.println("Es gibt keinen weiteren Spieltag mehr.");
    }

    /**
     * Liest eine ganzzahlige Eingabe vom Benutzer ein und validiert sie.
     * Wiederholt die Abfrage solange, bis eine gültige Zahl im erlaubten Bereich eingegeben wird.
     */
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
                // Eingabe war keine gültige Zahl
                System.out.println("Bitte gib eine gültige Zahl ein.");
            }
        }
    }


	// Lässt den Spieler einen Verein per Nummer auswählen.
    // Gibt den 0-basierten Index zurück (Eingabe 1 → Index 0).
    public int chooseClubIndex(int max) {
        return getIntInput("\nDeine Auswahl: ", 1, max) - 1;
    }


    // Liest die Hauptmenü-Auswahl des Spielers ein (0–8).
    public int getMenuChoice() {
        return getIntInput("", 0, 8);
    }

     // Zeigt die verfügbaren Formationen an und lässt den Spieler eine wählen.
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

    /**
     * Lässt den Nutzer einen Spieler aus einer Liste auswählen.
     * Zeigt die aktuelle Position im Auswahlprozess an (z. B. "Spieler 1 von 4").
     */
    public int choosePlayer(int availableCount, int needed, int currentCount) {
        String prompt = "Wähle Spieler " + (currentCount + 1) + " von " + needed + ": ";
        return getIntInput(prompt, 1, availableCount) - 1;
    }

    // ==================== HILFSMETHODEN ====================

    /**
     * Pausiert die Programmausführung und wartet auf ENTER-Tastendruck.
     * Nützlich um dem Spieler Zeit zum Lesen der Ausgabe zu geben.
     */
    public void pause() {
        System.out.print("\nDrücke ENTER zum Fortfahren...");
        scanner.nextLine();
    }

    /**
     * Gibt eine beliebige Nachricht auf der Konsole aus.
     * Ermöglicht es der Spiellogik, Texte über die UI auszugeben,
     * ohne direkt auf System.out zuzugreifen.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Zeigt den Saisonabschluss-Bildschirm mit der Endtabelle und
     * einer persönlichen Zusammenfassung für den Nutzerverein an.
     */
    public void showSeasonEnd(Season season, Club userClub) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("SAISON 2025/26 BEENDET!");
        System.out.println("=".repeat(50));

        ArrayList<Club> finalTable = season.getFinalTable();

        // Meister ermitteln: Platz 1 der sortierten Abschlusstabelle
        Club champion = finalTable.get(0);
        System.out.println("DEUTSCHER MEISTER: " + champion.getName());
        System.out.println();

        // Vollständige Endtabelle formatiert ausgeben
        System.out.println("===== ENDPLATZIERUNG =====");
        for (int i = 0; i < finalTable.size(); i++) {
            Club club = finalTable.get(i);
            // Nutzerverein in der Tabelle hervorheben
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

        // Endposition des Nutzervereins in der Tabelle bestimmen
        int userPosition = 0;
        for (int i = 0; i < finalTable.size(); i++) {
            if (finalTable.get(i).equals(userClub)) {
                userPosition = i + 1;
                break;
            }
        }

        System.out.println("\nDein Verein (" + userClub.getName() + ") belegt Platz " + userPosition + "!");

        // Situationsbezogener Abschlusskommentar je nach Tabellenposition
        if (userPosition == 1) {
            System.out.println("HERZLICHEN GLÜCKWUNSCH ZUM MEISTERTITEL!!!");
        } else if (userPosition <= 6) {
            System.out.println("Starke Saison – Europa-Pokal erreicht!");
        } else if (userPosition >= 12) {
            System.out.println("Solider Mittelfeldplatz.");
        } else if (userPosition >= 16) {
            System.out.println("Abstiegskampf... nächstes Jahr besser!");
        }
    }
}