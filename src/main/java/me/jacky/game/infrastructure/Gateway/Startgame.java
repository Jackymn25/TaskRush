package me.jacky.game.infrastructure.Gateway;

import me.jacky.game.Application.Gamemanager;
import me.jacky.game.Game;

public class Startgame implements Switchable {
    private boolean switchOn;
    private final Gamemanager gamemanager;

    public Startgame(Gamemanager gamemanager) {
        this.gamemanager = gamemanager;
    }

    @Override
    public void switchOn() {
        gamemanager.startgame();
        switchOn = true;
    }

    @Override
    public void switchOff() {
        gamemanager.cancelgame();
        switchOn = false;
    }

    @Override
    public boolean isSwitchOn() {
        return switchOn;
    }
}
