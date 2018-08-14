import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class League {

    private String leagueType;
    private List<Match> matches;
    private Player mvp;

    public League(String leagueType) {
        this.leagueType = leagueType;
    }

    public String getLeagueType() {
        return leagueType;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public Player getMvp() {
        return mvp;
    }

    public void generateMVP() {

        Player mvp = matches.get(0).getBestPlayerOfTheMatch();

        for (Match match :
                matches) {

            Player bestPlayerOfTheMatch = match.getBestPlayerOfTheMatch();
            if (mvp.getTotalPoints() < bestPlayerOfTheMatch.getTotalPoints()) {

                mvp = bestPlayerOfTheMatch;

            }

        }

        this.mvp = mvp;
    }

    public void initMatches(List<File> files) {

        this.matches = new ArrayList<>();

        for (File file :
                files) {

            Match match = new Match();
            Team teamA = new Team();
            Team teamB = new Team();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                reader.readLine();

                String currentLine;
                while ((currentLine = reader.readLine()) != null) {

                    String[] splitted = currentLine.split(";");


                    switch (this.leagueType) {
                        //For basketball
                        case "basketball":
                            if (splitted[3].equals("Team A")) {

                                BasketPlayer player = new BasketPlayer(splitted[0], splitted[1], splitted[2], splitted[3],
                                        splitted[4], splitted[5], splitted[6], splitted[7]);

                                teamA.addToTeam(player);
                                teamA.increasePoints(Integer.parseInt(player.getScoredPoints()));

                            } else {

                                BasketPlayer player = new BasketPlayer(splitted[0], splitted[1], splitted[2], splitted[3],
                                        splitted[4], splitted[5], splitted[6], splitted[7]);

                                teamB.addToTeam(player);
                                teamB.increasePoints(Integer.parseInt(player.getScoredPoints()));

                            }
                            break;

                        //For handball
                        case "handball":
                            if (splitted[3].equals("Team A")) {

                                HandballPlayer player = new HandballPlayer(splitted[0], splitted[1], splitted[2], splitted[3],
                                        splitted[4], splitted[5], splitted[6], splitted[7]);

                                teamA.addToTeam(player);
                                teamA.increasePoints(Integer.parseInt(player.getGoalMade()));

                            } else {

                                HandballPlayer player = new HandballPlayer(splitted[0], splitted[1], splitted[2], splitted[3],
                                        splitted[4], splitted[5], splitted[6], splitted[7]);

                                teamB.addToTeam(player);
                                teamB.increasePoints(Integer.parseInt(player.getGoalMade()));

                            }

                            break;
                    }
                }

                match.setTeamA(teamA);
                match.setTeamB(teamB);

                this.matches.add(match);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
