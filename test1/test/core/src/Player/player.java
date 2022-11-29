package Player;

import Tanks.tank;

public class player {

    private String name;

    private Tanks.tank tank;

    public player(String name) {
        this.name = name;
    }

    public void allotTank(tank tank) {
        this.tank = tank;
    }

}
