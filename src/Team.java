import java.util.ArrayList;
import java.util.List;

public class Team {

    int points;
    List<Player> playerList;
    Player bestPlayer;

    Team(){
        this.playerList = new ArrayList<>();
        this.points = 0;
    }

    public void addToTeam(Player player) {
        this.playerList.add(player);
    }

    public void increasePoints(int i) {
        this.points += i;
    }

    public Player getBestPlayer(){
        return this.bestPlayer;
    }

    public void setBestPlayer(Player bestPlayer){
        this.bestPlayer = bestPlayer;
    }

    public int getPoints(){
        return this.points;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
