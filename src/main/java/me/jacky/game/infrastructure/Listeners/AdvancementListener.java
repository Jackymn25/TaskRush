package me.jacky.game.infrastructure.Listeners;

import me.jacky.game.tasks.TaskManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

public class AdvancementListener implements Listener {

    private ArrayList<Team> teams;

    public AdvancementListener(ArrayList<Team> teams) {
        this.teams = teams;
    }

    @EventHandler
    public void onPlayerAdvance(PlayerAdvancementDoneEvent event) {
        Player player = event.getPlayer();
        for (Team team : teams) {
            if (team.hasEntry(player.getName())) {
                TaskManager.handlepossibletask(event, team);
                break;
            }
        }

    }
}
}
