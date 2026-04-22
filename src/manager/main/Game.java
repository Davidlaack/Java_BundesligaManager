package manager.main;

import java.util.Scanner;
import manager.model.Club;
import manager.season.Season;

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
		System.out.println("    Willkommen zum Bundesliga Manager");
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
			System.out.println("2. Alle Vereine anzeigen");
			System.out.println("3. Saisoninfo");
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
				season.showAllClubs();
				break;
			case 3:
				System.out.println("Du managst aktuell: " + userClub.getName());
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

	public Club getUserClub() {
		return userClub;
	}
}