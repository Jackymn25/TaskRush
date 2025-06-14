package me.jacky.game.tasks.taskfiles;

import me.jacky.game.infrastructure.Listeners.AdvancementListener;
import me.jacky.game.tasks.Task;
import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.plugin.Plugin;

import java.util.Iterator;
import java.util.Random;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AdvancementTask extends Task {

    private Advancement target;

    public AdvancementTask(Plugin plugin) {
        super(plugin, new AdvancementListener());
        Iterator<Advancement> advancementIterator = Bukkit.advancementIterator();

        // 转换为 Stream
        Stream<Advancement> stream = StreamSupport.stream(
                ((Iterable<Advancement>) () -> advancementIterator).spliterator(), false
        );

        // 转数组（或 List）
        Advancement[] advancements = stream.toArray(Advancement[]::new);

        this.target = advancements[new Random().nextInt(advancements.length)];
    }

    public String to_String() {
        return target.getKey().getKey();
    }

    @Override
    public void cancel() {

    }

    @Override
    public void publish() {

    }

    @Override
    public boolean is_complete(Event e) {
        if (e instanceof PlayerAdvancementDoneEvent) {
            PlayerAdvancementDoneEvent pe = (PlayerAdvancementDoneEvent) e;
            return pe.getAdvancement().getKey().equals(target.getKey());
        }
        return false;
    }
}
