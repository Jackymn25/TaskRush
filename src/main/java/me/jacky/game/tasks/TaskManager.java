package me.jacky.game.tasks;

import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

public class TaskManager {

    private Team team;
    private ArrayList<task> tasks;

    public Team  getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void addTask(task task) {
        tasks.add(task);
    }

    public void removeTask(task task) {
        tasks.remove(task);
    }

    public int getSize() {
        return tasks.size();
    }

    public task getTask(int index) {
        return tasks.get(index);
    }
}
