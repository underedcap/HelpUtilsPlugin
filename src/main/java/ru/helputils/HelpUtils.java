package ru.helputils;

import org.bukkit.plugin.java.JavaPlugin;
import ru.helputils.command.FixCommand;
import ru.helputils.command.FlyCommand;
import ru.helputils.command.HealCommand;
import ru.helputils.command.EcCommand;

public final class HelpUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getLogger().info("HelpUtils plugin is enabled");

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("fix").setExecutor(new FixCommand());
        getCommand("ec").setExecutor(new EcCommand());
        getCommand("fly").setExecutor(new FlyCommand());
    }
    @Override
    public void onDisable() {
        getServer().getLogger().info("HelpUtils plugin is disabled");

    }
}
