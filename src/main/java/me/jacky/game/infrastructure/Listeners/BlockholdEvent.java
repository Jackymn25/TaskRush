package me.jacky.game.infrastructure.Listeners;

import me.jacky.game.tasks.TaskManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

public class BlockholdEvent {
    private ArrayList<Team> teams;

    public BlockholdEvent(ArrayList<Team> teams) {
        this.teams = teams;
    }

    @EventHandler
    public void onPlayerBlock(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        for (Team team : teams) {
            if (team.hasEntry(player.getName())) {
                TaskManager.handlepossibletask(e, team);
                break;
            }
        }

    }
}
