package manager.season;

import java.util.ArrayList;
import manager.data.BundesligaData;
import manager.model.Club;
import manager.simulation.Match;

/**
 * Repräsentiert eine vollständige Bundesliga-Saison.
 * Verwaltet alle Vereine, den Spielplan (Hin- und Rückrunde)
 * sowie den aktuellen Spieltag.
 */
public class Season {

    // Liste aller Vereine in der Liga
    private ArrayList<Club> clubs;

    // Liste aller Spieltage der gesamten Saison (Hin- + Rückrunde)
    private ArrayList<Matchday> matchdays;

    // Index des aktuellen Spieltags (0-basiert)
    private int currentMatchday;

    /**
     * Konstruktor: Initialisiert die Saison.
     * Lädt die Bundesliga-Vereine aus BundesligaData,
     * setzt den Spieltag auf 0 und erstellt den vollständigen Spielplan.
     */
    public Season() {
        clubs = BundesligaData.createBundesligaClubs();
        matchdays = new ArrayList<>();
        currentMatchday = 0;
        createFullSchedule();
    }

    /**
     * Gibt die Liste aller Vereine zurück.
     *
     * @return ArrayList mit allen Club-Objekten
     */
    public ArrayList<Club> getClubs() {
        return clubs;
    }

    /**
     * Gibt die Liste aller Spieltage zurück.
     *
     * @return ArrayList mit allen Matchday-Objekten
     */
    public ArrayList<Matchday> getMatchdays() {
        return matchdays;
    }

    /**
     * Gibt den aktuellen Spieltag-Index zurück (0-basiert).
     *
     * @return Index des aktuellen Spieltags
     */
    public int getCurrentMatchday() {
        return currentMatchday;
    }

    /**
     * Gibt das Matchday-Objekt des aktuellen Spieltags zurück.
     * Gibt null zurück, wenn die Saison bereits beendet ist.
     *
     * @return aktuelles Matchday-Objekt oder null
     */
    public Matchday getCurrentMatchdayObject() {
        if (currentMatchday < matchdays.size()) {
            return matchdays.get(currentMatchday);
        }
        return null;
    }

    //Gibt alle Vereinsnamen auf der Konsole aus.

    public void showAllClubs() {
        System.out.println("Bundesliga-Clubs:");
        for (Club club : clubs) {
            System.out.println("- " + club.getName());
        }
    }

    /**
     * Erstellt den vollständigen Saisonspielplan (Hin- und Rückrunde)
     * nach dem Berger-Tableau-Algorithmus (Round-Robin).
     *
     * Funktionsweise:
     * - Ein Team bleibt immer an Position 0 fixiert ("fixed")
     * - Alle anderen Teams rotieren nach jedem Spieltag eine Position weiter
     * - In geraden Runden spielt Team i zu Hause, in ungeraden auswärts
     * - Die Rückrunde spiegelt die Hinrunde mit getauschten Heim-/Auswärtsteams
     *
     * Voraussetzung: gerade Anzahl von Teams (sonst Abbruch)
     */
    private void createFullSchedule() {
        ArrayList<Club> teams = new ArrayList<>(clubs);
        int teamCount = teams.size();

        // Nur bei gerader Teamanzahl funktioniert der Algorithmus korrekt
        if (teamCount % 2 != 0) {
            return;
        }

        int rounds = teamCount - 1;           // Anzahl Spieltage pro Hälfte
        int matchesPerRound = teamCount / 2;  // Anzahl Spiele pro Spieltag

        // Arbeitskopie der Teamliste, die rotiert wird
        ArrayList<Club> rotatingTeams = new ArrayList<>(teams);

        // --- Hinrunde erstellen ---
        for (int round = 0; round < rounds; round++) {
            Matchday matchday = new Matchday(round + 1);

            // Paarungen bilden: Team i spielt gegen Team (teamCount-1-i)
            for (int i = 0; i < matchesPerRound; i++) {
                Club home = rotatingTeams.get(i);
                Club away = rotatingTeams.get(teamCount - 1 - i);

                // Abwechselnd Heimrecht tauschen (gerade/ungerade Runde)
                if (round % 2 == 0) {
                    matchday.addMatch(new Match(home, away));
                } else {
                    matchday.addMatch(new Match(away, home));
                }
            }

            matchdays.add(matchday);

            // Rotation: letztes Team wird auf Position 1 geschoben,
            // Position 0 bleibt immer das fixe Team
            Club fixed = rotatingTeams.get(0);
            Club last = rotatingTeams.remove(rotatingTeams.size() - 1);
            rotatingTeams.add(1, last);
            rotatingTeams.set(0, fixed);
        }

        // --- Rückrunde erstellen (Heim/Auswärts der Hinrunde tauschen) ---
        for (int round = 0; round < rounds; round++) {
            Matchday firstHalf = matchdays.get(round);
            Matchday secondHalf = new Matchday(round + 1 + rounds);

            // Jedes Spiel der Hinrunde wird mit getauschten Teams übernommen
            for (Match match : firstHalf.getMatches()) {
                secondHalf.addMatch(new Match(match.getAwayClub(), match.getHomeClub()));
            }

            matchdays.add(secondHalf);
        }
    }

    /**
     * Sucht einen Verein anhand seines Namens.
     *
     * @param name Der gesuchte Vereinsname (exakter Match)
     * @return Das Club-Objekt bei Treffer, sonst null
     */
    public Club findClubByName(String name) {
        for (Club club : clubs) {
            if (club.getName().equals(name)) {
                return club;
            }
        }
        return null;
    }

    /**
     * Gibt das nächste Spiel eines bestimmten Vereins zurück
     * (aus dem aktuellen Spieltag).
     *
     * @param club Der gesuchte Verein
     * @return Das Match-Objekt, falls gefunden; null wenn Saison beendet
     *         oder kein Spiel für den Verein am aktuellen Spieltag existiert
     */
    public Match getNextMatchForClub(Club club) {
        // Saison bereits beendet
        if (currentMatchday >= matchdays.size()) {
            return null;
        }

        Matchday matchday = matchdays.get(currentMatchday);

        // Spiel suchen, in dem der Verein als Heim- oder Auswärtsteam vorkommt
        for (Match match : matchday.getMatches()) {
            if (match.getHomeClub().equals(club) || match.getAwayClub().equals(club)) {
                return match;
            }
        }

        return null;
    }

    /**
     * Gibt die aktuelle Tabelle auf der Konsole aus.
     * Sortiert nach Punkten (absteigend), bei Gleichstand nach Tordifferenz.
     */
    public void showTable() {
        ArrayList<Club> table = new ArrayList<>(clubs);

        // Sortierung: Punkte absteigend, bei Gleichstand Tordifferenz absteigend
        table.sort((club1, club2) -> {
            if (club2.getPoints() != club1.getPoints()) {
                return club2.getPoints() - club1.getPoints();
            }
            return club2.getGoalDifference() - club1.getGoalDifference();
        });

        System.out.println("\n===== TABELLE =====");
        for (int i = 0; i < table.size(); i++) {
            Club club = table.get(i);
            System.out.println(
                (i + 1) + ". " +
                club.getName() +
                " | Punkte: " + club.getPoints() +
                " | Tore: " + club.getGoalsFor() + ":" + club.getGoalsAgainst() +
                " | Diff: " + club.getGoalDifference()
            );
        }
    }

    /**
     * Gibt die aktuelle Tabellenposition eines bestimmten Vereins zurück.
     * Sortierung: Punkte absteigend, bei Gleichstand Tordifferenz absteigend.
     *
     * @param userClub Der Verein, dessen Position ermittelt werden soll
     * @return Tabellenposition (1-basiert) oder -1 wenn nicht gefunden
     */
    public int getTablePosition(Club userClub) {
        ArrayList<Club> table = new ArrayList<>(clubs);

        // Gleiche Sortierung wie showTable()
        table.sort((club1, club2) -> {
            if (club2.getPoints() != club1.getPoints()) {
                return club2.getPoints() - club1.getPoints();
            }
            return club2.getGoalDifference() - club1.getGoalDifference();
        });

        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).equals(userClub)) {
                return i + 1; // 1-basierte Position zurückgeben
            }
        }

        return -1; // Verein nicht in der Tabelle gefunden
    }

    /**
     * Rückt den Spieltag-Zähler um eins vor.
     * Wird nach Abschluss eines Spieltags aufgerufen.
     */
    public void nextMatchday() {
        currentMatchday++;
    }

    /**
     * Prüft, ob die Saison vollständig abgespielt wurde.
     *
     * @return true wenn alle Spieltage absolviert wurden, sonst false
     */
    public boolean isSeasonFinished() {
        return currentMatchday >= matchdays.size();
    }

    /**
     * Gibt die sortierte Abschlusstabelle der Saison zurück.
     * Sortierung: Punkte absteigend, bei Gleichstand Tordifferenz absteigend.
     *
     * @return Sortierte ArrayList mit allen Vereinen
     */
    public ArrayList<Club> getFinalTable() {
        ArrayList<Club> table = new ArrayList<>(clubs);
        table.sort((club1, club2) -> {
            if (club2.getPoints() != club1.getPoints()) {
                return club2.getPoints() - club1.getPoints();
            }
            return club2.getGoalDifference() - club1.getGoalDifference();
        });
        return table;
    }
}