package me.jacky.game.infrastructure.command;

import me.jacky.game.infrastructure.Gateway.Switchable;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class launchgame {

    private Switchable mainbutton;

    public launchgame(Switchable mainbutton) {
        this.mainbutton = mainbutton;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("launch")) {
            if (mainbutton.isSwitchOn()) {
                sender.sendMessage(ChatColor.RED + "Game is already launched.");
                return true;
            } else {
                mainbutton.switchOn();
                sender.sendMessage(ChatColor.GREEN + "Game is launched.");
                return true;
            }
        }
        return true;
    }
}
