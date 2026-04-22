package manager.main;

import manager.model.Club;
import manager.model.Lineup;
import manager.model.Player;
import manager.season.Matchday;
import manager.season.Season;
import manager.simulation.Match;
import manager.simulation.MatchSimulator;
import manager.ui.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final ConsoleUI ui = new ConsoleUI();
    private Season season;
    private Club userClub;
    private boolean running;

    public Game() {
        season = new Season();
        running = true;
    }

    public void start() {
        ui.showWelcome();
        chooseClub();
        mainMenu();
    }

    private void chooseClub() {
        List<Club> clubs = season.getClubs();
        ui.displayClubSelection(clubs);

        int index = ui.chooseClubIndex(clubs.size());
        userClub = clubs.get(index);

        ui.printMessage("\nDu bist jetzt Manager von " + userClub.getName() + "!");
    }

    private void mainMenu() {
        while (running) {
            ui.showMainMenu(userClub.getName());
            int choice = ui.getMenuChoice();

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
                    showCurrentMatchday();
                    break;
                case 6:
                    createLineup();
                    break;
                case 7:
                    showCurrentLineup();
                    break;
                case 8:
                    playNextMatchday();
                    break;
                case 0:
                    running = false;
                    ui.printMessage("Spiel beendet.");
                    break;
                default:
                    ui.printMessage("Ungültige Auswahl.");
            }
            if (running) ui.pause();
        }
    }

    private void showNextMatch() {
        Match match = season.getNextMatchForClub(userClub);
        ui.showNextMatch(match);
    }

    private void showUserClubPosition() {
        int position = season.getTablePosition(userClub);
        ui.showUserClubPosition(userClub.getName(), position);
    }

    private void showCurrentMatchday() {
        if (season.getCurrentMatchdayObject() != null) {
            season.getCurrentMatchdayObject().showMatches();
        } else {
            ui.printMessage("Es gibt aktuell keinen Spieltag.");
        }
    }

    private void createLineup() {
        int formationChoice = ui.chooseFormation();

        String formation;
        switch (formationChoice) {                  // ← normales Switch-Statement (kein Expression)
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
                ui.printMessage("Ungültige Formation.");
                return;                             // ← jetzt erlaubt
        }

        Lineup lineup = new Lineup(userClub, formation);

        selectPlayersForPosition(lineup, "GK", 1);
        selectPlayersForPosition(lineup, "DEF", lineup.getRequiredDefenders());
        selectPlayersForPosition(lineup, "MF", lineup.getRequiredMidfielders());
        selectPlayersForPosition(lineup, "ST", lineup.getRequiredStrikers());

        userClub.setCurrentLineup(lineup);
        ui.printMessage("\nStartelf wurde gespeichert.");
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
                ui.printMessage("Keine verfügbaren Spieler für diese Position.");
                return;
            }

            int index = ui.choosePlayer(availablePlayers.size(), needed, selectedCount);
            Player selectedPlayer = availablePlayers.get(index);

            lineup.addPlayer(selectedPlayer);
            ui.printMessage(selectedPlayer.getName() + " wurde hinzugefügt.");
            selectedCount++;
        }
    }

    private void showCurrentLineup() {
        ui.showCurrentLineup(userClub.getCurrentLineup());
    }

    private void playNextMatchday() {
        if (userClub.getCurrentLineup() == null) {
            ui.printMessage("Du musst zuerst eine Startelf festlegen.");
            return;
        }

        Matchday currentMatchdayObj = season.getCurrentMatchdayObject();
        if (currentMatchdayObj == null) {
            ui.showNoMoreMatchdays();
            return;
        }

        ui.showMatchdayHeader(currentMatchdayObj.getNumber());

        for (Match match : currentMatchdayObj.getMatches()) {
            MatchSimulator.simulateMatch(match);
            ui.showMatchResult(match);
        }

        season.nextMatchday();

        if (season.isSeasonFinished()) {
            ui.showSeasonEnd(season, userClub);
            running = false;
        }
    }

    public Club getUserClub() {
        return userClub;
    }
}