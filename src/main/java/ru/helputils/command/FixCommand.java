package ru.helputils.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.helputils.Manager.FixLogic;

public class FixCommand implements CommandExecutor {

    private final FixLogic fixLogic = new FixLogic();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED+"Команда только для игроков");
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            fixLogic.fixInteract(player);
            return true;
        }

        if (args.length == 1) {
            fixLogic.fixAll(player);
        }

        return true;
    }
}
