package de.ytendx.opj.listeners;

import de.ytendx.opj.OnlyProxyJoin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class ConnectListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        if (!event.getAddress().getHostAddress().contains(OnlyProxyJoin.getInstance().getProxyAddress())) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "§cThat´s not allowed ;)");
        }
    }
}
