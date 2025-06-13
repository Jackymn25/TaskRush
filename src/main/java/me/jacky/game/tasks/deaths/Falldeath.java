package me.jacky.game.tasks.deaths;


import me.jacky.game.infrastructure.Listeners.Deathevent;
import me.jacky.game.tasks.task;
import org.bukkit.Bukkit;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Falldeath extends task {

    @Override
    public void publish() {
        // 使用在infrastructure里的监听器
        // Bukkit.getPluginManager().registerEvent(new Deathevent());

    }

    @Override
    public void cancel() {
        // 注销在玩家身上的监听器
        PlayerDeathEvent.getHandlerList().unregister(listener);

    }

    @Override
    public boolean is_complete() {
        // 判断是否完成
    }

}
