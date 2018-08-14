public class HandballPlayer extends Player {

    private String initialRatingPoints;
    private String goalMade;
    private String goalReceived;

    public HandballPlayer(){

    }

    public HandballPlayer(String name, String nick, String number, String team, String position,
                          String initialRatingPoints, String goalMade, String goalReceived) {
        super(name, nick, number, team, position);

        this.initialRatingPoints = initialRatingPoints;
        this.goalMade = goalMade;
        this.goalReceived = goalReceived;

        if(this.getPosition().equals("G")){

            this.totalPoints = Integer.parseInt(initialRatingPoints) * 50
                    + Integer.parseInt(goalMade) * 5
                    + Integer.parseInt(goalReceived) * -2;

        } else if (this.getPosition().equals("F")) {

            this.totalPoints = Integer.parseInt(initialRatingPoints) * 20
                    + Integer.parseInt(goalMade) * 1
                    + Integer.parseInt(goalReceived) * -1;

        }

    }

    public String getInitialRatingPoints() {
        return initialRatingPoints;
    }

    public void setInitialRatingPoints(String initialRatingPoints) {
        this.initialRatingPoints = initialRatingPoints;
    }

    public String getGoalMade() {
        return goalMade;
    }

    public void setGoalMade(String goalMade) {
        this.goalMade = goalMade;
    }

    public String getGoalReceived() {
        return goalReceived;
    }

    public void setGoalReceived(String goalReceived) {
        this.goalReceived = goalReceived;
    }

    @Override
    public String toString() {
        StringBuilder strToWrite = new StringBuilder();
        strToWrite.append("The MVP is: ");
        appendStdDataToSB(strToWrite, this);
        strToWrite.append("\n\tScored Points:")
                .append(this.getGoalMade())
                .append("\n\tGoal Received: ")
                .append(this.getGoalReceived());
        return strToWrite.toString();
    }
}
