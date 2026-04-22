package manager.simulation;

import java.util.Random;

import manager.model.Club;
import manager.model.Lineup;
import manager.model.Player;

public class MatchSimulator {

    private static Random random = new Random();

    public static void simulateMatch(Match match) {
        Club homeClub = match.getHomeClub();
        Club awayClub = match.getAwayClub();

        int homeAttack = calculateAttackStrength(homeClub);
        int homeDefense = calculateDefenseStrength(homeClub);

        int awayAttack = calculateAttackStrength(awayClub);
        int awayDefense = calculateDefenseStrength(awayClub);

        int homeGoals = calculateGoals(homeAttack, awayDefense, true);
        int awayGoals = calculateGoals(awayAttack, homeDefense, false);

        match.setResult(homeGoals, awayGoals);

        homeClub.updateStats(homeGoals, awayGoals);
        awayClub.updateStats(awayGoals, homeGoals);
    }

    private static int calculateAttackStrength(Club club) {
        Lineup lineup = club.getCurrentLineup();

        if (lineup != null) {
            int totalAttack = 0;

            for (Player player : lineup.getStartingEleven()) {
                totalAttack += player.getAttack();
            }

            return totalAttack / lineup.getStartingEleven().size();
        } else {
            int totalAttack = 0;

            for (Player player : club.getSquad()) {
                totalAttack += player.getAttack();
            }

            return totalAttack / club.getSquad().size();
        }
    }

    private static int calculateDefenseStrength(Club club) {
        Lineup lineup = club.getCurrentLineup();

        if (lineup != null) {
            int totalDefense = 0;

            for (Player player : lineup.getStartingEleven()) {
                totalDefense += player.getDefense();
            }

            return totalDefense / lineup.getStartingEleven().size();
        } else {
            int totalDefense = 0;

            for (Player player : club.getSquad()) {
                totalDefense += player.getDefense();
            }

            return totalDefense / club.getSquad().size();
        }
    }

    private static int calculateGoals(int attack, int opponentDefense, boolean isHomeTeam) {
        int baseChance = attack - opponentDefense;

        if (isHomeTeam) {
            baseChance += 2;
        }

        int randomValue = random.nextInt(25);

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