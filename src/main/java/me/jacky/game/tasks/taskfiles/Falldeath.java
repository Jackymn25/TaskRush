package me.jacky.game.tasks.taskfiles;


import me.jacky.game.tasks.Task;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Falldeath extends Task {

    public Falldeath() {
        super(, );
    }

    @Override
    public void publish() {


    }

    @Override
    public void cancel() {


    }

    @Override
    public boolean is_complete(Event event) {
        // 判断是否完成
        if (!(event instanceof PlayerDeathEvent)) return false;

        PlayerDeathEvent deathEvent = (PlayerDeathEvent) event;
        EntityDamageEvent damage = deathEvent.getEntity().getLastDamageCause();

        if (damage != null && damage.getCause() == EntityDamageEvent.DamageCause.FALL) {
            return true;
        }
        return false;
    }

}
