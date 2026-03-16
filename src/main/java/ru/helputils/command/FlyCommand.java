package ru.helputils.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.helputils.Manager.FlyLogic;

public class FlyCommand implements CommandExecutor {
    private final FlyLogic flyLogic = new FlyLogic();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED+"Только для игроков");
            return true;
        }
    if (args.length == 0) {
        flyLogic.toggleFly(player);
        return true;
    }
    if (args.length == 1) {
        Integer speed = Integer.parseInt(args[0]);
        float flyspeed = speed / 10F;
        player.setFlySpeed(flyspeed);
        player.sendMessage(ChatColor.GOLD + "Скорость полета была установлена : " + flyspeed);
        return true;
    }
    return  true;
    }
}
