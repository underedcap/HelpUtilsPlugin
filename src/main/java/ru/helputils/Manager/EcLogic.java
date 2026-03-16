package ru.helputils.Manager;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EcLogic {

    public void ecInteract(Player player) {
        Inventory enderChest = player.getEnderChest();
        player.openInventory(enderChest);
    }
    }
