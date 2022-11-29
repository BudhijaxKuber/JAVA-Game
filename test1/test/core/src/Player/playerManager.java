package Player;

public class playerManager {

    private player p1;
    private player p2;

    private int playerNo;

    public playerManager() {
        playerNo = 1;
    }

    public void setPlayer(player player) {
        if (playerNo==1) {
            p1=player;
            playerNo++;
        }
        else {
            p2=player;
            playerNo=0;
        }
    }

    public int getPlayerNo() {
        return playerNo;
    }

}
