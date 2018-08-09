/**
 * Created by Alvaro on 08/08/2018.
 */
public class Match {

    Team teamA;
    Team teamB;

    public Match(){
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public Player getBestPlayerOfTheMatch() {

        Player bestATeamPlayer;
        Player bestBTeamPlayer;


        bestATeamPlayer = teamA.getPlayerList().get(0);
        for (int i = 1; i < teamA.getPlayerList().size(); i++) {

            if (bestATeamPlayer.getTotalPoints() < teamA.getPlayerList().get(i).getTotalPoints()) {

                bestATeamPlayer = teamA.getPlayerList().get(i);

            }

        }

        bestBTeamPlayer = teamB.getPlayerList().get(0);
        for (int i = 1; i < teamB.getPlayerList().size(); i++) {

            if (bestBTeamPlayer.getTotalPoints() < teamB.getPlayerList().get(i).getTotalPoints()) {

                bestBTeamPlayer = teamB.getPlayerList().get(i);

            }

        }

        if (teamA.getPoints() > teamB.getPoints()) {
            bestATeamPlayer.setTotalPoints(bestATeamPlayer.getTotalPoints() + 10);
        } else {
            bestBTeamPlayer.setTotalPoints(bestBTeamPlayer.getTotalPoints() + 10);
        }

        if (bestATeamPlayer.getTotalPoints() > bestBTeamPlayer.getTotalPoints()) {
            return bestATeamPlayer;
        } else {
            return bestBTeamPlayer;
        }
    }
}
