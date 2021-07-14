package de.ytendx.opj;

import de.ytendx.opj.config.ConfigWriter;
import de.ytendx.opj.listeners.ConnectListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class OnlyProxyJoin extends JavaPlugin {

    private static OnlyProxyJoin instance;
    private String proxyAddress;

    public static OnlyProxyJoin getInstance() {
        return instance;
    }

    public String getProxyAddress() {
        return proxyAddress;
    }

    @Override
    public void onEnable() {
        System.out.println("[OPJ] Loading OnlyProxyJoin...");

        if (!this.getDataFolder().exists()) this.getDataFolder().mkdir();
        instance = this;
        Bukkit.getPluginManager().registerEvents(new ConnectListener(), this);

        try {
            this.proxyAddress = ConfigWriter.readConfig().getBungeeIP();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("[OPJ] Loaded OnlyProxyJoin succesfully!");
        super.onEnable();
    }

    @Override
    public void onDisable() {
        System.out.println("[OPJ] Disabled OnlyProxyJoin succesfully!");
        super.onDisable();
    }
}
