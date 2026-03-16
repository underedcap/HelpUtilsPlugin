package ru.helputils.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.helputils.HelpUtils;
import ru.helputils.Manager.HealLogic;

public class HealCommand implements CommandExecutor {

    private final HealLogic helpU = new HealLogic();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Команда только для игроков");
            return true;
        }
        Player player  = (Player) sender;
        helpU.healInteract(player);
        player.sendMessage(ChatColor.GOLD+"Вы были успешно исцелены");
        return  true;
    }
}
