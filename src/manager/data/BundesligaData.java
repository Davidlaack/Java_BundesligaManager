package manager.data;

import java.util.ArrayList;
import manager.model.Club;
import manager.model.Player;

public class BundesligaData {

	public static ArrayList<Club> createBundesligaClubs() {
		ArrayList<Club> clubs = new ArrayList<>();

		clubs.add(createBayern());
		clubs.add(createDortmund());
		clubs.add(createWerderBremen());
		clubs.add(createLeverkusen());
		clubs.add(createLeipzig());
		clubs.add(createStuttgart());
		clubs.add(createFrankfurt());
		clubs.add(createFreiburg());
		clubs.add(createHoffenheim());
		clubs.add(createMainz());
		clubs.add(createUnionBerlin());
		clubs.add(createGladbach());
		clubs.add(createWolfsburg());
		clubs.add(createAugsburg());
		clubs.add(createStPauli());
		clubs.add(createHeidenheim());
		clubs.add(createKoeln());
		clubs.add(createHSV());

		return clubs;
	}

	private static Club createBayern() {
		Club club = new Club("FC Bayern München");

		club.addPlayer(new Player("Manuel Neuer", "GK", 10, 90));
		club.addPlayer(new Player("Jonas Urbig", "GK", 8, 82));
		club.addPlayer(new Player("Sven Ulreich", "GK", 6, 78));

		club.addPlayer(new Player("Dayot Upamecano", "DEF", 40, 84));
		club.addPlayer(new Player("Min-jae Kim", "DEF", 38, 85));
		club.addPlayer(new Player("Jonathan Tah", "DEF", 35, 86));
		club.addPlayer(new Player("Alphonso Davies", "DEF", 72, 78));
		club.addPlayer(new Player("Josip Stanišić", "DEF", 55, 79));
		club.addPlayer(new Player("Raphaël Guerreiro", "DEF", 68, 73));
		club.addPlayer(new Player("Sacha Boey", "DEF", 60, 74));
		club.addPlayer(new Player("Hiroki Ito", "DEF", 42, 80));

		club.addPlayer(new Player("Joshua Kimmich", "MF", 82, 78));
		club.addPlayer(new Player("Leon Goretzka", "MF", 78, 74));
		club.addPlayer(new Player("Aleksandar Pavlović", "MF", 74, 72));
		club.addPlayer(new Player("João Palhinha", "MF", 66, 80));
		club.addPlayer(new Player("Jamal Musiala", "MF", 92, 55));
		club.addPlayer(new Player("Konrad Laimer", "MF", 70, 74));
		club.addPlayer(new Player("Paul Wanner", "MF", 77, 52));
		club.addPlayer(new Player("Michael Olise", "MF", 88, 46));

		club.addPlayer(new Player("Harry Kane", "ST", 95, 35));
		club.addPlayer(new Player("Kingsley Coman", "ST", 84, 42));
		club.addPlayer(new Player("Serge Gnabry", "ST", 83, 40));
		club.addPlayer(new Player("Bryan Zaragoza", "ST", 79, 34));
		club.addPlayer(new Player("Jonah Kusi-Asare", "ST", 72, 28));

		return club;

	}

	private static Club createDortmund() {
		Club club = new Club("Borussia Dortmund");

		club.addPlayer(new Player("Gregor Kobel", "GK", 8, 89));
		club.addPlayer(new Player("Alexander Meyer", "GK", 5, 76));

		club.addPlayer(new Player("Niklas Süle", "DEF", 35, 81));
		club.addPlayer(new Player("Nico Schlotterbeck", "DEF", 44, 84));
		club.addPlayer(new Player("Julian Ryerson", "DEF", 52, 77));
		club.addPlayer(new Player("Waldemar Anton", "DEF", 34, 80));
		club.addPlayer(new Player("Yan Couto", "DEF", 66, 70));
		club.addPlayer(new Player("Ramy Bensebaini", "DEF", 48, 76));
		club.addPlayer(new Player("Daniel Svensson", "DEF", 50, 72));

		club.addPlayer(new Player("Julian Brandt", "MF", 84, 48));
		club.addPlayer(new Player("Marcel Sabitzer", "MF", 74, 69));
		club.addPlayer(new Player("Pascal Groß", "MF", 76, 68));
		club.addPlayer(new Player("Felix Nmecha", "MF", 73, 67));
		club.addPlayer(new Player("Carney Chukwuemeka", "MF", 75, 60));

		club.addPlayer(new Player("Serhou Guirassy", "ST", 91, 33));
		club.addPlayer(new Player("Karim Adeyemi", "ST", 86, 38));
		club.addPlayer(new Player("Maximilian Beier", "ST", 82, 36));
		club.addPlayer(new Player("Jamie Gittens", "ST", 84, 34));
		club.addPlayer(new Player("Fábio Silva", "ST", 78, 30));

		return club;
	}

	private static Club createLeverkusen() {
		Club club = new Club("Bayer 04 Leverkusen");

		club.addPlayer(new Player("Mark Flekken", "GK", 6, 86));
		club.addPlayer(new Player("Jonas Omlin", "GK", 5, 80));
		club.addPlayer(new Player("Janis Blaswich", "GK", 4, 78));

		club.addPlayer(new Player("Álex Grimaldo", "DEF", 78, 74));
		club.addPlayer(new Player("Arthur", "DEF", 58, 70));
		club.addPlayer(new Player("Loïc Badé", "DEF", 34, 82));
		club.addPlayer(new Player("Lucas Vázquez", "DEF", 63, 68));
		club.addPlayer(new Player("Tim Oermann", "DEF", 40, 72));
		club.addPlayer(new Player("Jarell Quansah", "DEF", 38, 81));
		club.addPlayer(new Player("Edmond Tapsoba", "DEF", 36, 84));

		club.addPlayer(new Player("Aleix García", "MF", 76, 66));
		club.addPlayer(new Player("Robert Andrich", "MF", 72, 75));
		club.addPlayer(new Player("Ezequiel Fernández", "MF", 73, 71));
		club.addPlayer(new Player("Jonas Hofmann", "MF", 77, 60));
		club.addPlayer(new Player("Exequiel Palacios", "MF", 78, 69));
		club.addPlayer(new Player("Nathan Tella", "MF", 80, 52));
		club.addPlayer(new Player("Malik Tillman", "MF", 84, 55));

		club.addPlayer(new Player("Patrik Schick", "ST", 89, 31));
		club.addPlayer(new Player("Martin Terrier", "ST", 82, 35));
		club.addPlayer(new Player("Eliesse Ben Seghir", "ST", 81, 36));
		club.addPlayer(new Player("Ernest Poku", "ST", 76, 30));

		return club;

	}

	private static Club createLeipzig() {
		Club club = new Club("RB Leipzig");

		club.addPlayer(new Player("Péter Gulácsi", "GK", 4, 85));
		club.addPlayer(new Player("Maarten Vandevoordt", "GK", 5, 82));
		club.addPlayer(new Player("Leopold Zingerle", "GK", 3, 74));

		club.addPlayer(new Player("David Raum", "DEF", 71, 73));
		club.addPlayer(new Player("Castello Lukeba", "DEF", 38, 82));
		club.addPlayer(new Player("Willi Orbán", "DEF", 34, 84));
		club.addPlayer(new Player("Ridle Baku", "DEF", 69, 68));

		club.addPlayer(new Player("Christoph Baumgartner", "MF", 81, 56));
		club.addPlayer(new Player("Nicolas Seiwald", "MF", 72, 68));
		club.addPlayer(new Player("Assan Ouédraogo", "MF", 74, 60));
		club.addPlayer(new Player("Xaver Schlager", "MF", 73, 71));
		club.addPlayer(new Player("Kevin Kampl", "MF", 70, 63));

		club.addPlayer(new Player("Antonio Nusa", "ST", 83, 35));
		club.addPlayer(new Player("Rômulo", "ST", 79, 31));
		club.addPlayer(new Player("Yussuf Poulsen", "ST", 76, 38));
		club.addPlayer(new Player("Benjamin Šeško", "ST", 88, 33));

		return club;
	}

	private static Club createFrankfurt() {
		Club club = new Club("Eintracht Frankfurt");

		club.addPlayer(new Player("Kauã Santos", "GK", 4, 82));
		club.addPlayer(new Player("Jens Grahl", "GK", 2, 72));
		club.addPlayer(new Player("Michael Zetterer", "GK", 4, 79));

		club.addPlayer(new Player("Robin Koch", "DEF", 34, 83));
		club.addPlayer(new Player("Arthur Theate", "DEF", 36, 81));
		club.addPlayer(new Player("Rasmus Kristensen", "DEF", 58, 74));
		club.addPlayer(new Player("Nathaniel Brown", "DEF", 61, 72));
		club.addPlayer(new Player("Nnamdi Collins", "DEF", 54, 71));
		club.addPlayer(new Player("Aurèle Amenda", "DEF", 33, 76));
		club.addPlayer(new Player("Buta", "DEF", 60, 69));

		club.addPlayer(new Player("Ellyes Skhiri", "MF", 68, 76));
		club.addPlayer(new Player("Hugo Larsson", "MF", 77, 68));
		club.addPlayer(new Player("Mario Götze", "MF", 79, 56));
		club.addPlayer(new Player("Farès Chaïbi", "MF", 78, 57));
		club.addPlayer(new Player("Mahmoud Dahoud", "MF", 73, 65));
		club.addPlayer(new Player("Can Uzun", "MF", 84, 48));
		club.addPlayer(new Player("Ritsu Doan", "MF", 82, 52));

		club.addPlayer(new Player("Jonathan Burkardt", "ST", 87, 34));
		club.addPlayer(new Player("Ansgar Knauff", "ST", 81, 38));
		club.addPlayer(new Player("Jean-Mattéo Bahoya", "ST", 78, 34));
		club.addPlayer(new Player("Michy Batshuayi", "ST", 79, 30));
		club.addPlayer(new Player("Elye Wahi", "ST", 82, 31));

		return club;
	}

	private static Club createWerderBremen() {
		Club club = new Club("SV Werder Bremen");

		club.addPlayer(new Player("Karl Hein", "GK", 5, 80));
		club.addPlayer(new Player("Markus Kolke", "GK", 3, 74));
		club.addPlayer(new Player("Mio Backhaus", "GK", 4, 76));

		club.addPlayer(new Player("Marco Friedl", "DEF", 38, 79));
		club.addPlayer(new Player("Niklas Stark", "DEF", 34, 78));
		club.addPlayer(new Player("Amos Pieper", "DEF", 30, 76));
		club.addPlayer(new Player("Mitchell Weiser", "DEF", 68, 70));
		club.addPlayer(new Player("Felix Agu", "DEF", 61, 68));
		club.addPlayer(new Player("Julián Malatini", "DEF", 33, 72));
		club.addPlayer(new Player("Yukinari Sugawara", "DEF", 64, 69));
		club.addPlayer(new Player("Isaac Schmidt", "DEF", 58, 66));
		club.addPlayer(new Player("Olivier Deman", "DEF", 57, 65));
		club.addPlayer(new Player("Maximilian Wöber", "DEF", 35, 75));

		club.addPlayer(new Player("Jens Stage", "MF", 74, 66));
		club.addPlayer(new Player("Leonardo Bittencourt", "MF", 70, 60));
		club.addPlayer(new Player("Senne Lynen", "MF", 69, 67));
		club.addPlayer(new Player("Cameron Puertas", "MF", 76, 62));
		club.addPlayer(new Player("Romano Schmid", "MF", 81, 54));
		club.addPlayer(new Player("Isak Hansen-Aarøen", "MF", 71, 52));
		club.addPlayer(new Player("Skelly Alvero", "MF", 67, 64));

		club.addPlayer(new Player("Justin Njinmah", "ST", 81, 32));
		club.addPlayer(new Player("Keke Topp", "ST", 75, 30));
		club.addPlayer(new Player("Marco Grüll", "ST", 77, 31));
		club.addPlayer(new Player("Samuel Mbangula", "ST", 79, 33));
		club.addPlayer(new Player("Victor Boniface", "ST", 87, 34));

		return club;
	}

	private static Club createStuttgart() {
		Club club = new Club("VfB Stuttgart");

		club.addPlayer(new Player("Fabian Bredlow", "GK", 3, 75));
		club.addPlayer(new Player("Stefan Drljača", "GK", 3, 73));

		club.addPlayer(new Player("Ameen Al Dakhil", "DEF", 34, 77));
		club.addPlayer(new Player("Ramon Hendriks", "DEF", 33, 76));
		club.addPlayer(new Player("Josha Vagnoman", "DEF", 63, 71));
		club.addPlayer(new Player("Maximilian Mittelstädt", "DEF", 67, 72));
		club.addPlayer(new Player("Luca Jaquez", "DEF", 31, 74));
		club.addPlayer(new Player("Finn Jeltsch", "DEF", 29, 72));
		club.addPlayer(new Player("Pascal Stenzel", "DEF", 55, 70));

		club.addPlayer(new Player("Angelo Stiller", "MF", 80, 69));
		club.addPlayer(new Player("Atakan Karazor", "MF", 68, 74));
		club.addPlayer(new Player("Chris Führich", "MF", 83, 51));
		club.addPlayer(new Player("Enzo Millot", "MF", 82, 55));
		club.addPlayer(new Player("Jamie Leweling", "MF", 79, 49));
		club.addPlayer(new Player("Yannik Keitel", "MF", 69, 68));
		club.addPlayer(new Player("Luca Raimund", "MF", 73, 50));

		club.addPlayer(new Player("Ermedin Demirović", "ST", 86, 33));
		club.addPlayer(new Player("Deniz Undav", "ST", 85, 32));
		club.addPlayer(new Player("Nick Woltemade", "ST", 82, 31));
		club.addPlayer(new Player("El Bilal Touré", "ST", 80, 30));

		return club;
	}

	private static Club createFreiburg() {
		Club club = new Club("SC Freiburg");
		club.addPlayer(new Player("Noah Atubolu", "GK", 4, 82));
		club.addPlayer(new Player("Jannik Huth", "GK", 2, 72));

		club.addPlayer(new Player("Philipp Lienhart", "DEF", 35, 80));
		club.addPlayer(new Player("Matthias Ginter", "DEF", 34, 81));
		club.addPlayer(new Player("Lukas Kübler", "DEF", 52, 74));
		club.addPlayer(new Player("Niklas Beste", "DEF", 69, 68));
		club.addPlayer(new Player("Anthony Jung", "DEF", 33, 75));
		club.addPlayer(new Player("Bruno Ogbus", "DEF", 28, 72));
		club.addPlayer(new Player("Max Rosenfelder", "DEF", 39, 71));

		club.addPlayer(new Player("Maximilian Eggestein", "MF", 73, 68));
		club.addPlayer(new Player("Nicolas Höfler", "MF", 67, 73));
		club.addPlayer(new Player("Merlin Röhl", "MF", 77, 60));
		club.addPlayer(new Player("Ritsu Doan", "MF", 83, 54));
		club.addPlayer(new Player("Daniel-Kofi Kyereh", "MF", 76, 56));
		club.addPlayer(new Player("Florent Muslija", "MF", 78, 53));

		club.addPlayer(new Player("Junior Adamu", "ST", 79, 30));
		club.addPlayer(new Player("Michael Gregoritsch", "ST", 81, 34));
		club.addPlayer(new Player("Lucas Höler", "ST", 78, 33));

		return club;
	}

	private static Club createMainz() {
		Club club = new Club("1. FSV Mainz 05");

		club.addPlayer(new Player("Robin Zentner", "GK", 4, 83));
		club.addPlayer(new Player("Lasse Rieß", "GK", 3, 75));
		club.addPlayer(new Player("Daniel Batz", "GK", 2, 72));

		club.addPlayer(new Player("Stefan Bell", "DEF", 28, 76));
		club.addPlayer(new Player("Danny da Costa", "DEF", 53, 72));
		club.addPlayer(new Player("Andreas Hanche-Olsen", "DEF", 32, 77));
		club.addPlayer(new Player("Dominik Kohr", "DEF", 34, 74));
		club.addPlayer(new Player("Anthony Caci", "DEF", 66, 70));
		club.addPlayer(new Player("Phillipp Mwene", "DEF", 60, 69));

		club.addPlayer(new Player("Nadiem Amiri", "MF", 81, 62));
		club.addPlayer(new Player("Paul Nebel", "MF", 79, 55));
		club.addPlayer(new Player("Kaishu Sano", "MF", 73, 69));
		club.addPlayer(new Player("Sota Kawasaki", "MF", 72, 65));
		club.addPlayer(new Player("Lee Jae-sung", "MF", 78, 58));

		club.addPlayer(new Player("Jonathan Burkardt", "ST", 86, 34));
		club.addPlayer(new Player("Nelson Weiper", "ST", 76, 29));
		club.addPlayer(new Player("Armindo Sieb", "ST", 77, 30));
		club.addPlayer(new Player("Brajan Gruda", "ST", 80, 31));

		return club;
	}

	private static Club createGladbach() {
		Club club = new Club("Borussia Mönchengladbach");
		club.addPlayer(new Player("Moritz Nicolas", "GK", 4, 82));
		club.addPlayer(new Player("Jonas Omlin", "GK", 4, 81));
		club.addPlayer(new Player("Tiago Pereira Cardoso", "GK", 3, 74));
		club.addPlayer(new Player("Tobias Sippel", "GK", 2, 70));

		club.addPlayer(new Player("Nico Elvedi", "DEF", 33, 79));
		club.addPlayer(new Player("Ko Itakura", "DEF", 35, 80));
		club.addPlayer(new Player("Joe Scally", "DEF", 58, 72));
		club.addPlayer(new Player("Luca Netz", "DEF", 62, 70));
		club.addPlayer(new Player("Fabio Chiarodia", "DEF", 30, 74));
		club.addPlayer(new Player("Kevin Diks", "DEF", 55, 74));
		club.addPlayer(new Player("Marvin Friedrich", "DEF", 28, 76));
		club.addPlayer(new Player("Lukas Ullrich", "DEF", 57, 68));

		club.addPlayer(new Player("Julian Weigl", "MF", 72, 73));
		club.addPlayer(new Player("Florian Neuhaus", "MF", 75, 62));
		club.addPlayer(new Player("Rocco Reitz", "MF", 74, 66));
		club.addPlayer(new Player("Kevin Stöger", "MF", 79, 58));
		club.addPlayer(new Player("Philipp Sander", "MF", 71, 63));
		club.addPlayer(new Player("Oscar Fraulo", "MF", 70, 61));
		club.addPlayer(new Player("Robin Hack", "MF", 80, 50));
		club.addPlayer(new Player("Franck Honorat", "MF", 81, 49));

		club.addPlayer(new Player("Tim Kleindienst", "ST", 84, 34));
		club.addPlayer(new Player("Tomáš Čvančara", "ST", 79, 31));
		club.addPlayer(new Player("Haris Tabaković", "ST", 78, 30));
		club.addPlayer(new Player("Grant-Leon Ranos", "ST", 72, 27));

		return club;
	}

	private static Club createUnionBerlin() {
		Club club = new Club("1. FC Union Berlin");
		club.addPlayer(new Player("Frederik Rønnow", "GK", 4, 83));
		club.addPlayer(new Player("Carl Klaus", "GK", 2, 71));
		club.addPlayer(new Player("Alexander Schwolow", "GK", 3, 74));

		club.addPlayer(new Player("Danilho Doekhi", "DEF", 34, 80));
		club.addPlayer(new Player("Diogo Leite", "DEF", 35, 79));
		club.addPlayer(new Player("Leopold Querfeld", "DEF", 31, 76));
		club.addPlayer(new Player("Tom Rothe", "DEF", 63, 71));
		club.addPlayer(new Player("Christopher Trimmel", "DEF", 58, 70));
		club.addPlayer(new Player("Josip Juranović", "DEF", 61, 72));
		club.addPlayer(new Player("Jerome Roussillon", "DEF", 54, 69));

		club.addPlayer(new Player("Rani Khedira", "MF", 69, 74));
		club.addPlayer(new Player("Aljoscha Kemlein", "MF", 72, 66));
		club.addPlayer(new Player("András Schäfer", "MF", 73, 64));
		club.addPlayer(new Player("László Bénes", "MF", 75, 60));
		club.addPlayer(new Player("Janik Haberer", "MF", 71, 61));
		club.addPlayer(new Player("Woo-yeong Jeong", "MF", 74, 55));

		club.addPlayer(new Player("Benedict Hollerbach", "ST", 80, 33));
		club.addPlayer(new Player("Marin Ljubičić", "ST", 78, 30));
		club.addPlayer(new Player("Andrej Ilić", "ST", 76, 29));
		club.addPlayer(new Player("Ivan Prtajin", "ST", 74, 31));
		club.addPlayer(new Player("Tim Skarke", "ST", 75, 30));

		return club;
	}

	private static Club createWolfsburg() {
		Club club = new Club("VfL Wolfsburg");
		club.addPlayer(new Player("Kamil Grabara", "GK", 4, 84));
		club.addPlayer(new Player("Marius Müller", "GK", 3, 76));
		club.addPlayer(new Player("Niklas Klinger", "GK", 2, 70));

		club.addPlayer(new Player("Konstantinos Koulierakis", "DEF", 33, 79));
		club.addPlayer(new Player("Denis Vavro", "DEF", 31, 78));
		club.addPlayer(new Player("Sebastiaan Bornauw", "DEF", 30, 77));
		club.addPlayer(new Player("Kilian Fischer", "DEF", 57, 70));
		club.addPlayer(new Player("Joakim Maehle", "DEF", 64, 72));
		club.addPlayer(new Player("Rogério", "DEF", 56, 69));

		club.addPlayer(new Player("Maximilian Arnold", "MF", 77, 72));
		club.addPlayer(new Player("Mattias Svanberg", "MF", 74, 65));
		club.addPlayer(new Player("Aster Vranckx", "MF", 72, 66));
		club.addPlayer(new Player("Kevin Paredes", "MF", 76, 56));
		club.addPlayer(new Player("Lovro Majer", "MF", 80, 58));
		club.addPlayer(new Player("Bence Dárdai", "MF", 70, 60));
		club.addPlayer(new Player("Tiago Tomás", "MF", 77, 52));

		club.addPlayer(new Player("Jonas Wind", "ST", 84, 33));
		club.addPlayer(new Player("Mohamed Amoura", "ST", 86, 31));
		club.addPlayer(new Player("Patrick Wimmer", "ST", 81, 34));
		club.addPlayer(new Player("Lukas Nmecha", "ST", 78, 29));

		return club;
	}

	private static Club createAugsburg() {
		Club club = new Club("FC Augsburg");
		club.addPlayer(new Player("Finn Dahmen", "GK", 3, 82));
		club.addPlayer(new Player("Nediljko Labrović", "GK", 3, 77));
		club.addPlayer(new Player("Daniel Klein", "GK", 2, 70));

		club.addPlayer(new Player("Jeffrey Gouweleeuw", "DEF", 29, 78));
		club.addPlayer(new Player("Cédric Zesiger", "DEF", 30, 77));
		club.addPlayer(new Player("Chrislain Matsima", "DEF", 31, 76));
		club.addPlayer(new Player("Mads Pedersen", "DEF", 58, 70));
		club.addPlayer(new Player("Robert Gumny", "DEF", 55, 68));
		club.addPlayer(new Player("Henri Koudossou", "DEF", 54, 67));

		club.addPlayer(new Player("Elvis Rexhbecaj", "MF", 72, 68));
		club.addPlayer(new Player("Frank Onyeka", "MF", 69, 71));
		club.addPlayer(new Player("Arne Maier", "MF", 73, 63));
		club.addPlayer(new Player("Kristijan Jakić", "MF", 68, 70));
		club.addPlayer(new Player("Alexis Claude-Maurice", "MF", 80, 52));
		club.addPlayer(new Player("Fredrik Jensen", "MF", 74, 58));

		club.addPlayer(new Player("Mergim Berisha", "ST", 81, 31));
		club.addPlayer(new Player("Phillip Tietz", "ST", 79, 33));
		club.addPlayer(new Player("Samuel Essende", "ST", 78, 30));
		club.addPlayer(new Player("Steve Mounié", "ST", 77, 34));

		return club;
	}

	private static Club createHeidenheim() {
		Club club = new Club("1. FC Heidenheim 1846");
		club.addPlayer(new Player("Kevin Müller", "GK", 2, 80));
		club.addPlayer(new Player("Vitus Eicher", "GK", 2, 71));
		club.addPlayer(new Player("Paul Tschernuth", "GK", 1, 68));

		club.addPlayer(new Player("Patrick Mainka", "DEF", 28, 78));
		club.addPlayer(new Player("Benedikt Gimber", "DEF", 30, 76));
		club.addPlayer(new Player("Tim Siersleben", "DEF", 27, 74));
		club.addPlayer(new Player("Omar Traoré", "DEF", 58, 70));
		club.addPlayer(new Player("Frans Krätzig", "DEF", 62, 67));
		club.addPlayer(new Player("Norman Theuerkauf", "DEF", 40, 72));

		club.addPlayer(new Player("Jan Schöppner", "MF", 70, 66));
		club.addPlayer(new Player("Julian Niehues", "MF", 67, 68));
		club.addPlayer(new Player("Luca Kerber", "MF", 68, 64));
		club.addPlayer(new Player("Adrian Beck", "MF", 75, 56));
		club.addPlayer(new Player("Niklas Dorsch", "MF", 71, 65));

		club.addPlayer(new Player("Marvin Pieringer", "ST", 79, 31));
		club.addPlayer(new Player("Stefan Schimmer", "ST", 76, 33));
		club.addPlayer(new Player("Budu Zivzivadze", "ST", 77, 30));
		club.addPlayer(new Player("Mikkel Kaufmann", "ST", 74, 29));

		return club;
	}

	private static Club createStPauli() {
		Club club = new Club("FC St. Pauli");
		club.addPlayer(new Player("Nikola Vasilj", "GK", 2, 81));
		club.addPlayer(new Player("Ben Voll", "GK", 2, 72));
		club.addPlayer(new Player("Sascha Burchert", "GK", 1, 69));

		club.addPlayer(new Player("Hauke Wahl", "DEF", 27, 77));
		club.addPlayer(new Player("David Nemeth", "DEF", 28, 75));
		club.addPlayer(new Player("Siebe Van der Heyden", "DEF", 27, 74));
		club.addPlayer(new Player("Phillipp Treu", "DEF", 57, 69));
		club.addPlayer(new Player("Manolis Saliakas", "DEF", 58, 68));
		club.addPlayer(new Player("Lars Ritzka", "DEF", 54, 67));

		club.addPlayer(new Player("Jackson Irvine", "MF", 72, 67));
		club.addPlayer(new Player("Eric Smith", "MF", 69, 70));
		club.addPlayer(new Player("Carlo Boukhalfa", "MF", 68, 64));
		club.addPlayer(new Player("Connor Metcalfe", "MF", 71, 63));
		club.addPlayer(new Player("Danel Sinani", "MF", 77, 54));
		club.addPlayer(new Player("Elias Saad", "MF", 78, 52));

		club.addPlayer(new Player("Johannes Eggestein", "ST", 77, 31));
		club.addPlayer(new Player("Andreas Albers", "ST", 74, 33));
		club.addPlayer(new Player("Abdoulie Ceesay", "ST", 72, 28));
		club.addPlayer(new Player("Noah Weißhaupt", "ST", 75, 29));

		return club;
	}

	private static Club createKoeln() {
		Club club = new Club("1. FC Köln");
		club.addPlayer(new Player("Marvin Schwäbe", "GK", 3, 82));
		club.addPlayer(new Player("Ron-Robert Zieler", "GK", 2, 76));
		club.addPlayer(new Player("Matthias Köbbing", "GK", 1, 70));

		club.addPlayer(new Player("Joël Schmied", "DEF", 31, 77));
		club.addPlayer(new Player("Dominique Heintz", "DEF", 28, 76));
		club.addPlayer(new Player("Timo Hübers", "DEF", 30, 79));
		club.addPlayer(new Player("Luca Kilian", "DEF", 27, 74));
		club.addPlayer(new Player("Jahmai Simpson-Pusey", "DEF", 26, 73));
		club.addPlayer(new Player("Sebastian Sebulonsen", "DEF", 56, 69));
		club.addPlayer(new Player("Kristoffer Lund", "DEF", 58, 68));
		club.addPlayer(new Player("Rav van den Berg", "DEF", 29, 75));

		club.addPlayer(new Player("Denis Huseinbašić", "MF", 73, 63));
		club.addPlayer(new Player("Eric Martel", "MF", 70, 71));
		club.addPlayer(new Player("Dejan Ljubičić", "MF", 74, 65));
		club.addPlayer(new Player("Florian Kainz", "MF", 77, 56));
		club.addPlayer(new Player("Jakub Kamiński", "MF", 79, 52));
		club.addPlayer(new Player("Marius Bülter", "MF", 78, 54));
		club.addPlayer(new Player("Said El Mala", "MF", 72, 49));
		club.addPlayer(new Player("Malek El Mala", "MF", 71, 48));

		club.addPlayer(new Player("Ragnar Ache", "ST", 84, 32));
		club.addPlayer(new Player("Tim Lemperle", "ST", 77, 30));
		club.addPlayer(new Player("Damion Downs", "ST", 76, 29));
		club.addPlayer(new Player("Steffen Tigges", "ST", 74, 31));

		return club;
	}

	private static Club createHSV() {
		Club club = new Club("Hamburger HSV");
		club.addPlayer(new Player("Daniel Heuer Fernandes", "GK", 3, 82));
		club.addPlayer(new Player("Daniel Peretz", "GK", 3, 79));
		club.addPlayer(new Player("Hannes Hermann", "GK", 1, 69));
		club.addPlayer(new Player("Fernando Dickes", "GK", 1, 67));

		club.addPlayer(new Player("William Mikelbrencis", "DEF", 57, 69));
		club.addPlayer(new Player("Noah Katterbach", "DEF", 56, 68));
		club.addPlayer(new Player("Guilherme Ramos", "DEF", 30, 75));
		club.addPlayer(new Player("Giorgi Gocholeishvili", "DEF", 58, 69));
		club.addPlayer(new Player("Warmed Omari", "DEF", 31, 76));
		club.addPlayer(new Player("Aboubaka Soumahoro", "DEF", 27, 72));
		club.addPlayer(new Player("Jordan Torunarigha", "DEF", 33, 78));
		club.addPlayer(new Player("Miro Muheim", "DEF", 63, 71));
		club.addPlayer(new Player("Silvan Hefti", "DEF", 55, 68));
		club.addPlayer(new Player("Luka Vušković", "DEF", 35, 77));

		club.addPlayer(new Player("Albert Sambi Lokonga", "MF", 74, 66));
		club.addPlayer(new Player("Daniel Elfadli", "MF", 70, 70));
		club.addPlayer(new Player("Immanuel Pherai", "MF", 77, 56));
		club.addPlayer(new Player("Bakery Jatta", "MF", 75, 52));
		club.addPlayer(new Player("Fabio Vieira", "MF", 82, 55));
		club.addPlayer(new Player("Nicolai Remberg", "MF", 71, 67));
		club.addPlayer(new Player("Jonas Meffert", "MF", 69, 68));
		club.addPlayer(new Player("Nicolás Capaldo", "MF", 73, 64));

		club.addPlayer(new Player("Jean-Luc Dompé", "ST", 82, 33));
		club.addPlayer(new Player("Robert Glatzel", "ST", 84, 31));
		club.addPlayer(new Player("Ransford-Yeboah Königsdörffer", "ST", 81, 32));
		club.addPlayer(new Player("Rayan Philippe", "ST", 80, 31));
		club.addPlayer(new Player("Yussuf Poulsen", "ST", 79, 34));
		club.addPlayer(new Player("Emir Sahiti", "ST", 77, 30));
		club.addPlayer(new Player("Alexander Røssing-Lelesiit", "ST", 72, 27));
		club.addPlayer(new Player("Fabio Baldé", "ST", 74, 28));

		return club;
	}

	private static Club createHoffenheim() {
		Club club = new Club("TSG Hoffenheim");
		club.addPlayer(new Player("Oliver Baumann", "GK", 4, 84));
		club.addPlayer(new Player("Lúkas Petersson", "GK", 2, 74));
		club.addPlayer(new Player("Luca Philipp", "GK", 2, 72));

		club.addPlayer(new Player("Kevin Akpoguma", "DEF", 31, 78));
		club.addPlayer(new Player("Ozan Kabak", "DEF", 34, 80));
		club.addPlayer(new Player("Robin Hranác", "DEF", 29, 76));
		club.addPlayer(new Player("Bernardo", "DEF", 30, 77));
		club.addPlayer(new Player("Koki Machida", "DEF", 32, 78));
		club.addPlayer(new Player("Valentin Gendrey", "DEF", 58, 70));
		club.addPlayer(new Player("Alexander Prass", "DEF", 63, 69));
		club.addPlayer(new Player("Albian Hajdari", "DEF", 28, 75));
		club.addPlayer(new Player("Vladimír Coufal", "DEF", 55, 71));
		club.addPlayer(new Player("Kelven Frees", "DEF", 22, 68));
		club.addPlayer(new Player("Luca Erlein", "DEF", 20, 67));

		club.addPlayer(new Player("Dennis Geiger", "MF", 74, 64));
		club.addPlayer(new Player("Grischa Prömel", "MF", 72, 69));
		club.addPlayer(new Player("Wouter Burger", "MF", 77, 66));
		club.addPlayer(new Player("Leon Avdullahu", "MF", 71, 63));
		club.addPlayer(new Player("Muhammed Damar", "MF", 75, 58));
		club.addPlayer(new Player("Florian Micheler", "MF", 68, 57));
		club.addPlayer(new Player("Luka Djuric", "MF", 67, 56));

		club.addPlayer(new Player("Andrej Kramarić", "ST", 86, 34));
		club.addPlayer(new Player("Fisnik Asllani", "ST", 82, 31));
		club.addPlayer(new Player("Tim Lemperle", "ST", 80, 30));
		club.addPlayer(new Player("Mergim Berisha", "ST", 79, 31));
		club.addPlayer(new Player("Adam Hlozek", "ST", 81, 32));
		club.addPlayer(new Player("Ihlas Bebou", "ST", 77, 30));
		club.addPlayer(new Player("Max Moerstedt", "ST", 74, 28));
		club.addPlayer(new Player("Bazoumana Touré", "ST", 76, 29));

		return club;
	}
}