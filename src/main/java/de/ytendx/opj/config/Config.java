package de.ytendx.opj.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Config {

    private final String bungeeIP;

    public Config(String bungeeIP) {
        this.bungeeIP = bungeeIP;
    }

    public static Config fromString(String jsonContext) {
        return new Gson().fromJson(jsonContext, Config.class);
    }

    public String getBungeeIP() {
        return bungeeIP;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
