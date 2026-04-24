package manager.simulation;

import java.util.Random;

import manager.model.Club;
import manager.model.Lineup;
import manager.model.Player;

// Diese Klasse simuliert ein Fußballspiel zwischen zwei Clubs
public class MatchSimulator {

    // Zufallszahlengenerator für die Spielsimulation
    private static Random random = new Random();

    // Hauptmethode zur Simulation eines Matches
    public static void simulateMatch(Match match) {
        // Heim- und Auswärtsmannschaft holen
        Club homeClub = match.getHomeClub();
        Club awayClub = match.getAwayClub();

        // Angriffs- und Verteidigungsstärken berechnen
        int homeAttack = calculateAttackStrength(homeClub);
        int homeDefense = calculateDefenseStrength(homeClub);

        int awayAttack = calculateAttackStrength(awayClub);
        int awayDefense = calculateDefenseStrength(awayClub);

        // Tore basierend auf Stärke + Zufall berechnen
        int homeGoals = calculateGoals(homeAttack, awayDefense, true);
        int awayGoals = calculateGoals(awayAttack, homeDefense, false);

        // Ergebnis im Match speichern
        match.setResult(homeGoals, awayGoals);

        // Statistiken der Clubs aktualisieren
        homeClub.updateStats(homeGoals, awayGoals);
        awayClub.updateStats(awayGoals, homeGoals);
    }

    // Berechnet die durchschnittliche Angriffsstärke eines Clubs
    private static int calculateAttackStrength(Club club) {
        Lineup lineup = club.getCurrentLineup();

        // Wenn eine Startelf vom Nutzer gesetzt ist, nutze diese
        if (lineup != null) {
            int totalAttack = 0;

            for (Player player : lineup.getStartingEleven()) {
                totalAttack += player.getAttack();
            }

            // Durchschnittswert berechnen
            return totalAttack / lineup.getStartingEleven().size();
        } else {
            // Falls keine Aufstellung existiert ( gilt für alle CPU Clubs) : gesamter Kader als Maßstab nehmen
            int totalAttack = 0;

            for (Player player : club.getSquad()) {
                totalAttack += player.getAttack();
            }

            return totalAttack / club.getSquad().size();
        }
    }

    // Berechnet die durchschnittliche Verteidigungsstärke eines Clubs
    private static int calculateDefenseStrength(Club club) {
        Lineup lineup = club.getCurrentLineup();

        // Wenn eine Startelf gesetzt ist, nutze diese
        if (lineup != null) {
            int totalDefense = 0;

            for (Player player : lineup.getStartingEleven()) {
                totalDefense += player.getDefense();
            }

            return totalDefense / lineup.getStartingEleven().size();
        } else {
            // Falls keine Aufstellung existiert: gesamter Kader
            int totalDefense = 0;

            for (Player player : club.getSquad()) {
                totalDefense += player.getDefense();
            }

            return totalDefense / club.getSquad().size();
        }
    }

 // Berechnet die Anzahl der Tore basierend auf Angriff, Verteidigung und Zufall
    private static int calculateGoals(int attack, int opponentDefense, boolean isHomeTeam) {
        // Basiswert: Differenz zwischen Angriff und gegnerischer Verteidigung
        int baseChance = attack - opponentDefense;

        // Heimvorteil (kleiner Bonus)
        if (isHomeTeam) {
            baseChance += 2;
        }

        // Zufallswert (0–24), sorgt für Varianz im Spiel
        int randomValue = random.nextInt(25);

        // Kombination aus Stärke und Zufall entscheidet über Tore
        if (baseChance + randomValue < 5) {
            return 0;
        } else if (baseChance + randomValue < 9) {
            return 1;
        } else if (baseChance + randomValue < 13) {
            return 2;
        } else if (baseChance + randomValue < 17) {
            return 3;
        } else if (baseChance + randomValue < 20) {
            return 4;
        } else {
            return 5;
        }
    }
}