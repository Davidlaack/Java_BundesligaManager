package manager.model;
import java.util.ArrayList;

public class Club {

    private String name;
    private ArrayList<Player> squad;

    public Club(String name) {
        this.name = name;
        this.squad = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getSquad() {
        return squad;
    }

    public void addPlayer(Player player) {
        squad.add(player);
    }

    @Override
    public String toString() {
        return name;
    }
    
    public void showSquad() {
        System.out.println("Kader von " + name + ":");
        for (Player player : squad) {
            System.out.println(player.getName() + " - " + player.getPosition());
        }
    }
}