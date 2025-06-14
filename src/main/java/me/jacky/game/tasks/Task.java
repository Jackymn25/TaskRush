package me.jacky.game.tasks;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public abstract class Task {

    private final Plugin plugin;
    private final Listener listener;

    protected Task(Plugin plugin, Listener listener) {
        this.plugin = plugin;
        this.listener = listener;
    }

    public abstract void publish();

    public abstract void cancel();

    public abstract boolean is_complete(Event e);

}
