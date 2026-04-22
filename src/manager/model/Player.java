package manager.model;

public class Player {

    private String name;
    private String position;
    private int attack;
    private int defense;

    public Player(String name, String position, int attack, int defense) {
        this.name = name;
        this.position = position;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public String toString() {
        return name + " - " + position + " | ANG: " + attack + " | DEF: " + defense;
    }
}