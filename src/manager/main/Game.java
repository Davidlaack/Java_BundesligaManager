package manager.main;

import java.util.ArrayList;
import java.util.Scanner;

import manager.model.Club;
import manager.model.Lineup;
import manager.model.Player;
import manager.season.Season;
import manager.simulation.Match;

public class Game {

    private Season season;
    private Club userClub;
    private Scanner scanner;
    private boolean running;

    public Game() {
        season = new Season();
        scanner = new Scanner(System.in);
        running = true;
    }

    public void start() {
        System.out.println("==================================");
        System.out.println("     Willkommen zum Bundesliga Manager");
        System.out.println("==================================");

        chooseClub();
        mainMenu();
    }

    private void chooseClub() {
        System.out.println("\nWähle den Verein, den du diese Saison managen möchtest:\n");

        for (int i = 0; i < season.getClubs().size(); i++) {
            System.out.println((i + 1) + ". " + season.getClubs().get(i).getName());
        }

        int choice = -1;

        while (choice < 1 || choice > season.getClubs().size()) {
            System.out.print("\nDeine Auswahl: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                if (choice < 1 || choice > season.getClubs().size()) {
                    System.out.println("Bitte wähle eine Zahl aus der Liste.");
                }
            } else {
                System.out.println("Bitte gib eine gültige Zahl ein.");
                scanner.next();
            }
        }

        userClub = season.getClubs().get(choice - 1);
        System.out.println("\nDu bist jetzt Manager von " + userClub.getName() + "!");
    }

    private void mainMenu() {
        while (running) {
            System.out.println("\n========== HAUPTMENÜ ==========");
            System.out.println("Dein Verein: " + userClub.getName());
            System.out.println("1. Meinen Kader anzeigen");
            System.out.println("2. Nächstes Spiel anzeigen");
            System.out.println("3. Tabellenplatz anzeigen");
            System.out.println("4. Ganze Tabelle anzeigen");
            System.out.println("5. Aktuellen Spieltag anzeigen");
            System.out.println("6. Startelf festlegen");
            System.out.println("7. Aktuelle Startelf anzeigen");
            System.out.println("0. Spiel beenden");
            System.out.print("Auswahl: ");

            int choice = -1;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Bitte gib eine gültige Zahl ein.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    userClub.showSquad();
                    break;
                case 2:
                    showNextMatch();
                    break;
                case 3:
                    showUserClubPosition();
                    break;
                case 4:
                    season.showTable();
                    break;
                case 5:
                    if (season.getCurrentMatchdayObject() != null) {
                        season.getCurrentMatchdayObject().showMatches();
                    } else {
                        System.out.println("Es gibt aktuell keinen Spieltag.");
                    }
                    break;
                case 6:
                    createLineup();
                    break;
                case 7:
                    showCurrentLineup();
                    break;
                case 0:
                    running = false;
                    System.out.println("Spiel beendet.");
                    break;
                default:
                    System.out.println("Ungültige Auswahl.");
            }
        }
    }

    private void showNextMatch() {
        Match match = season.getNextMatchForClub(userClub);

        if (match == null) {
            System.out.println("Für deinen Verein gibt es aktuell kein geplantes Spiel.");
        } else {
            System.out.println("Nächstes Spiel von " + userClub.getName() + ":");
            System.out.println(match);
        }
    }

    private void showUserClubPosition() {
        int position = season.getTablePosition(userClub);
        System.out.println("Aktueller Tabellenplatz von " + userClub.getName() + ": " + position);
    }

    private void createLineup() {
        System.out.println("\nWähle eine Formation:");
        System.out.println("1. 3-4-3");
        System.out.println("2. 4-4-2");
        System.out.println("3. 5-3-2");
        System.out.println("4. 4-3-3");
        System.out.println("5. 4-5-1");
        System.out.print("Auswahl: ");

        int choice = -1;

        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            System.out.println("Ungültige Eingabe.");
            scanner.next();
            return;
        }

        String formation = "";

        switch (choice) {
            case 1:
                formation = "3-4-3";
                break;
            case 2:
                formation = "4-4-2";
                break;
            case 3:
                formation = "5-3-2";
                break;
            case 4:
                formation = "4-3-3";
                break;
            case 5:
                formation = "4-5-1";
                break;
            default:
                System.out.println("Ungültige Formation.");
                return;
        }

        Lineup lineup = new Lineup(userClub, formation);

        System.out.println("\nTorwart auswählen:");
        selectPlayersForPosition(lineup, "GK", 1);

        System.out.println("\nAbwehrspieler auswählen:");
        selectPlayersForPosition(lineup, "DEF", lineup.getRequiredDefenders());

        System.out.println("\nMittelfeldspieler auswählen:");
        selectPlayersForPosition(lineup, "MF", lineup.getRequiredMidfielders());

        System.out.println("\nStürmer auswählen:");
        selectPlayersForPosition(lineup, "ST", lineup.getRequiredStrikers());

        userClub.setCurrentLineup(lineup);

        System.out.println("\nStartelf wurde gespeichert.");
    }

    private void selectPlayersForPosition(Lineup lineup, String position, int needed) {
        int selectedCount = 0;

        while (selectedCount < needed) {
            ArrayList<Player> availablePlayers = new ArrayList<>();

            System.out.println("\nVerfügbare Spieler für Position " + position + ":");

            int number = 1;
            for (Player player : userClub.getSquad()) {
                if (player.getPosition().equals(position) && !lineup.containsPlayer(player)) {
                    availablePlayers.add(player);
                    System.out.println(number + ". " + player);
                    number++;
                }
            }

            if (availablePlayers.isEmpty()) {
                System.out.println("Keine verfügbaren Spieler für diese Position.");
                return;
            }

            System.out.print("Wähle Spieler " + (selectedCount + 1) + " von " + needed + ": ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= availablePlayers.size()) {
                    Player selectedPlayer = availablePlayers.get(choice - 1);
                    lineup.addPlayer(selectedPlayer);
                    System.out.println(selectedPlayer.getName() + " wurde hinzugefügt.");
                    selectedCount++;
                } else {
                    System.out.println("Ungültige Auswahl.");
                }
            } else {
                System.out.println("Bitte eine Zahl eingeben.");
                scanner.next();
            }
        }
    }

    private void showCurrentLineup() {
        if (userClub.getCurrentLineup() == null) {
            System.out.println("Du hast noch keine Startelf festgelegt.");
        } else {
            userClub.getCurrentLineup().showLineup();
        }
    }

    public Club getUserClub() {
        return userClub;
    }
}