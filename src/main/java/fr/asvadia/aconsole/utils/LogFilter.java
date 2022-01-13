package fr.asvadia.aconsole.utils;

import fr.asvadia.aconsole.utils.file.FileManager;
import fr.asvadia.aconsole.utils.file.Files;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.Message;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public class LogFilter implements Filter {
    private final List<String> forceHideMessages;
    private final List<String> hideMessages;

    public LogFilter() {
        YamlConfiguration config = FileManager.getValues().get(Files.Config);
        hideMessages = config.getStringList("ToHide");
        forceHideMessages = config.getStringList("ToForceHide");
    }

    public Filter.Result checkMessages(int level, String message) {
        if (level >= 400)
            for (String s : hideMessages)
                if (message.contains(s))
                    return Result.DENY;
        for (String s : forceHideMessages)
            if (message.contains(s))
                return Result.DENY;
        return Result.NEUTRAL;
    }

    @Override
    public Result getOnMismatch() {
        return null;
    }

    @Override
    public Result getOnMatch() {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String msg, Object... params) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String message, Object p0) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, Object msg, Throwable t) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, Message msg, Throwable t) {
        return null;
    }

    @Override
    public Result filter(LogEvent event) {
        return checkMessages(event.getLevel().intLevel(), event.getLoggerName() + " " + event.getMessage().getFormattedMessage());
    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }
}
