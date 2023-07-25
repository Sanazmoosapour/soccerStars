package soccer;
import java.util.*;

public class Team {
    private String name;
    private ArrayList<Player> players=new ArrayList<>();
    private int playercounter=0;
    public Team(String name){
        this.name=name;
    }
    private int Goals=0;

    public int getGoals() {
        return Goals;
    }

    public void setGoals(int goals) {
        Goals = goals;
    }

    public void addplayer(Player p){
        players.add(p);
        p.setTeam(this);
        playercounter++;
    }
    @Override
    public boolean equals(Object obj){
        Team team=(Team) obj;
        if(this.name.equals(team.name))
            return true;
        return false;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getPlayercounter() {
        return playercounter;
    }

    public void setPlayercounter(int playercounter) {
        this.playercounter = playercounter;
    }
}
