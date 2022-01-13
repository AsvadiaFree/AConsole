package fr.asvadia.aconsole;

import fr.asvadia.aconsole.utils.LogFilter;
import fr.asvadia.aconsole.utils.file.FileManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onLoad() {
        instance = this;
        saveDefaultConfig();
        try {
            FileManager.init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((Logger) LogManager.getRootLogger()).addFilter(new LogFilter());
    }


    public static Main getInstance() {
        return instance;
    }
}
