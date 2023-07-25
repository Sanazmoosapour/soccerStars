package soccer;

public class Player {
    private String name;
    private int number;
    private Team team;
    private int locationX;
    private int locationY;
    private int speed;
    private char show;

    public char getShow() {
        return show;
    }

    public void setShow(char show) {
        this.show = show;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player(String name, int number){
        this.name=name;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Team getTeam() {
        return team;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
