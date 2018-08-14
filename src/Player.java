public class Player {

    private String name;
    private String nick;
    private String number;
    private String team;
    private String position;

    int totalPoints;

    public Player(){

    }

    public Player(String name, String nick, String number, String team, String position) {
        this.name = name;
        this.nick = nick;
        this.number = number;
        this.team = team;
        this.position = position;
        this.totalPoints = totalPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void appendStdDataToSB(StringBuilder sb, Player player) {

        sb.append("\nName: ");
        sb.append(player.getName());
        sb.append("\nNick: ");
        sb.append(player.getNick());
        sb.append("\nNumber: ");
        sb.append(player.getNumber());

    }
}
