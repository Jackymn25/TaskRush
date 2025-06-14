package me.jacky.game.tasks;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import me.jacky.game.tasks.taskfiles.*;

public class TaskManager {

    public static class TaskGenerator {

        private static final List<Supplier<Task>> generators = List.of(
                AdvancementTask::new,
                DeathTask::new,
                DigBlockTask::new,
                GetItemTask::new,
                HoldBlockTask::new,
                KillEntityTask::new,
                PlayerBehaviourTask::new
                // 添加更多任务子类
        );

        private static final Random random = new Random();

        public static Task generate() {
            return generators.get(random.nextInt(generators.size())).get();
        }
    }

    public static class TaskAssigner {

        public static void assign(Task t, Team team) {
            TaskManager.addTask(team, t);
        }
    }

    private static HashMap<Team, ArrayList<Task>> tasks;

    public static ArrayList<Task> getTasks(Team team) {
        return tasks.get(team);
    }

    public static void addTask(Team team, Task task) {
        tasks.get(team).add(task);
    }

    public static void removeTask(Team team, Task task) {
        tasks.get(team).remove(task);
    }

    public static int getsize(Team team) {
        tasks.get(team).size();
    }

    public static void handlepossibletask(Event e, Team team) {
        List<Task> todo = tasks.get(team);
        for (Task t : todo) {
            if (t.is_complete(e)) {
                todo.remove(t);
                TaskAssigner.assign(TaskGenerator.generate(), team);
            }
        }
    }

}
