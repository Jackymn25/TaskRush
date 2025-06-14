package me.jacky.game.infrastructure.Listeners;

import me.jacky.game.tasks.TaskManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

public class Deathevent implements Listener {
    private ArrayList<Team> teams;

    public Deathevent(ArrayList<Team> teams) {
        this.teams = teams;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        for (Team team : teams) {
            if (team.hasEntry(player.getName())) {
                TaskManager.handlepossibletask(event, team);
                break;
            }
        }

        }
    }
