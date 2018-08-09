public class BasketPlayer extends Player {

    private String scoredPoints;
    private String rebounds;
    private String assists;

    public BasketPlayer(){

    }

    public BasketPlayer(String name, String nick, String number, String team, String position,
                        String scoredPoints, String rebounds, String assists) {
        super(name, nick, number, team, position);

        this.scoredPoints = scoredPoints;
        this.rebounds = rebounds;
        this.assists = assists;

        if(this.getPosition().equals("G")){

            this.totalPoints = Integer.parseInt(scoredPoints) * 2
                    + Integer.parseInt(rebounds) * 3
                    + Integer.parseInt(assists) * 1;

        } else if (this.getPosition().equals("F")) {

            this.totalPoints = Integer.parseInt(scoredPoints) * 2
                    + Integer.parseInt(rebounds) * 2
                    + Integer.parseInt(assists) * 2;

        } else if (this.getPosition().equals("C")){

            this.totalPoints = Integer.parseInt(scoredPoints) * 2
                    + Integer.parseInt(rebounds) * 1
                    + Integer.parseInt(assists) * 3;

        }

    }

    public String getScoredPoints() {
        return scoredPoints;
    }

    public void setScoredPoints(String scoredPoints) {
        this.scoredPoints = scoredPoints;
    }

    public String getRebounds() {
        return rebounds;
    }

    public void setRebounds(String rebounds) {
        this.rebounds = rebounds;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    @Override
    public String toString() {
        return "BasketPlayer{" +
                "scoredPoints='" + scoredPoints + '\'' +
                ", rebounds='" + rebounds + '\'' +
                ", assists='" + assists + '\'' +
                ", name='" + this.getName() + '\'' +
                ", nick='" + this.getNick() + '\'' +
                ", number='" + this.getNumber() + '\'' +
                ", team='" + this.getTeam() + '\'' +
                ", position='" + this.getPosition() + '\'' +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
