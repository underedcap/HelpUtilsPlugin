package ru.helputils.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.helputils.Manager.EcLogic;

public class EcCommand implements CommandExecutor {
    private final EcLogic ec = new EcLogic();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Только для игроков");
            return true;
        }
        Player player = (Player) sender;

        ec.ecInteract(player);
        return true;
    }
}

