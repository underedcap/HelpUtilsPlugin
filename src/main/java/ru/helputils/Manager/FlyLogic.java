package ru.helputils.Manager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class FlyLogic {

    public void toggleFly(Player player) {

        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage(ChatColor.GOLD + "Режим полета был установлен для игрока" + player.getName());
        } else {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage(ChatColor.GOLD + "Режим полета был установлен для игрока" + player.getName());
        }
    }
    }

