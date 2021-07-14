package de.ytendx.opj.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConfigWriter {

    private static File file = new File("plugins//OnlyProxyJoin//config.json");

    public static Config readConfig() throws IOException {
        file = new File("plugins//OnlyProxyJoin//config.json");
        if (!file.exists()) {
            file.createNewFile();
            final Config config = new Config("127.0.0.1");
            setConfig(config);
            return config;
        }
        final Scanner scanner = new Scanner(file);
        String content = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            content = content + line;
        }
        return Config.fromString(content);
    }

    public static void setConfig(Config config) throws IOException {
        final FileWriter writer = new FileWriter(file);
        writer.write(config.toString());
        writer.flush();
        writer.close();
    }

}
