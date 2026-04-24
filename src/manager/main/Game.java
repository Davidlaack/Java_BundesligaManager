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

// Diese Klasse steuert den Ablauf des Managerspiels. 
// Sie verbindet Benutzeroberfläche, Saison und ausgewählten Verein und koordiniert die wichtigsten Spielaktionen.“


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

    // Der vom Nutzer ausgewählte Club wird hier in der Variablen userClub gespeichert
    private void chooseClub() {
        List<Club> clubs = season.getClubs();
        ui.displayClubSelection(clubs);

        int index = ui.chooseClubIndex(clubs.size());
        userClub = clubs.get(index);

        ui.printMessage("\nDu bist jetzt Manager von " + userClub.getName() + "!");
    }

    // Das wiederkehrende Hauptmenü mit Auswählmöglichkeiten im UI samt Aufruf der jeweils ausgewählten Funktionen
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

    // Zeigt die nächste Partie des Clubs des Nutzers
    private void showNextMatch() {
        Match match = season.getNextMatchForClub(userClub);
        ui.showNextMatch(match);
    }
    
    // Zeigt den aktuelle Tabellenplatz des Clubs des Nutzers an 
    private void showUserClubPosition() {
        int position = season.getTablePosition(userClub);
        ui.showUserClubPosition(userClub.getName(), position);
    }
    
    // Alle Partien (9) des aktuellen Spieltags anzeigen, sofern die Saison noch nicht zuende ist
    private void showCurrentMatchday() {
        if (season.getCurrentMatchdayObject() != null) {
            season.getCurrentMatchdayObject().showMatches();
        } else {
            ui.printMessage("Es gibt aktuell keinen Spieltag.");
        }
    }
    
    // Funktion, um eine Aufstellung zu speichern. 
    // Zunächst Auswahl aus verfügbaren Formationen. 
    private void createLineup() {
        int formationChoice = ui.chooseFormation();

        String formation;
        switch (formationChoice) {   
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
                return;                           
        }
        // Erzeugen eines Lineup-Objekts. Contructor der Klasse Lineup wird dem gewählten Club und der gewählten Formation des Nutzers aufgerufen
        // getRequiredDefenders() in class Lineup ermittelt Anzahl der benötigten Spieler pro Position
        Lineup lineup = new Lineup(userClub, formation);

        selectPlayersForPosition(lineup, "GK", 1);
        selectPlayersForPosition(lineup, "DEF", lineup.getRequiredDefenders());
        selectPlayersForPosition(lineup, "MF", lineup.getRequiredMidfielders());
        selectPlayersForPosition(lineup, "ST", lineup.getRequiredStrikers());

        userClub.setCurrentLineup(lineup);
        ui.printMessage("\nStartelf wurde gespeichert.");
    }

    // Auswahl der Spieler mit passender Anzahl an Spielern pro Position, je nach gewählter Formation
    // Ein Lineup-Objekt wird erstellt, das eine ArrayList enthält welche 11 Player-Objekte enthalten
    private void selectPlayersForPosition(Lineup lineup, String position, int needed) {
        int selectedCount = 0;

        while (selectedCount < needed) {
        	// In temporärer ArrayList availablePlayers werden alle Spieler, die zur aktuell benötigten Position gehören, gespeichert
            ArrayList<Player> availablePlayers = new ArrayList<>();
            
            // Und im UI ausgegeben, damit Nutzer seine Spieler wählen kann
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
    
    // Ausgabe der aktuell gespeicherten Aufstellung im UI
    private void showCurrentLineup() {
        ui.showCurrentLineup(userClub.getCurrentLineup());
    }
    
    // Aufruf der Funktion, um den nächsten Spieltag zu simulieren
    private void playNextMatchday() {
    	//Abbruch und return, falls keine Aufstellung vorhanden ist
        if (userClub.getCurrentLineup() == null) {
            ui.printMessage("Du musst zuerst eine Startelf festlegen.");
            return;
        }
        
        // Das aktuelle Matchday-Objekt aus der Saison holen
        // Enthält alle Spiele des aktuellen Spieltags
        Matchday currentMatchdayObj = season.getCurrentMatchdayObject();
        if (currentMatchdayObj == null) {
        	// Falls keine Spieltage mehr vorhanden sind, Saisonende melden
            ui.showNoMoreMatchdays();
            return;
        }
        
     // Überschrift im UI für den aktuellen Spieltag anzeigen
        ui.showMatchdayHeader(currentMatchdayObj.getNumber());
        
     // Alle Spiele des aktuellen Spieltags nacheinander in den Simulator schicken
        for (Match match : currentMatchdayObj.getMatches()) {
        	// Spiel berechnen und Ergebnis im Match-Objekt speichern
            MatchSimulator.simulateMatch(match);
            
         // Jedes Ergebnis im UI ausgeben
            ui.showMatchResult(match);
        }
        
        // Nach dem kompletten Spieltag den Saisonzähler erhöhen
        season.nextMatchday();
        
        // Prüfen, ob nach diesem Spieltag die Saison beendet ist.
        if (season.isSeasonFinished()) {
            ui.showSeasonEnd(season, userClub);
            running = false;
        }
    }

    //Funktion, um den vom User ausgewählen Club zu holen
    public Club getUserClub() {
        return userClub;
    }
}