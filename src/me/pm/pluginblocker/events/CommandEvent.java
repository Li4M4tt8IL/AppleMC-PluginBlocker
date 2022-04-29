package me.pm.pluginblocker.events;

import me.pm.pluginblocker.Main;
import me.pm.pluginblocker.util.CommandChecker;
import me.pm.pluginblocker.util.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CommandEvent implements Listener {
    private Main plugin;

    public CommandEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String command = e.getMessage().split(" ")[0];
        if(p.isOp() || p.hasPermission("pblocker.bypass") || CommandChecker.isCommandWhitelisted(command.replace("/", ""), plugin)) {
            return;
        } else {
            p.sendMessage(Utils.color(Objects.requireNonNull(plugin.getConfig().getString("Messages.blocked-command"))));
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onTab(PlayerCommandSendEvent event) {
        Player p = event.getPlayer();
        List<String> list = plugin.getConfig().getStringList("WhitelistedCommands");
        if(p.isOp() || p.hasPermission("pblocker.bypass")) {
            return;
        } else {
            event.getCommands().clear();
            event.getCommands().addAll(list);
        }
    }
}
