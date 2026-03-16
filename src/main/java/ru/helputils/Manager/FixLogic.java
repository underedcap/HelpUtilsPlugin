package ru.helputils.Manager;

import lombok.ToString;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FixLogic {

    List<ItemStack> fixeditems = new ArrayList<>();


    public void fixInteract(Player player) {

        ItemStack item = player.getInventory().getItemInMainHand();


        Damageable handitem = (Damageable) item.getItemMeta();


        if (!(item.getItemMeta() instanceof Damageable)) {
            player.sendMessage(ChatColor.RED + "Предмет нельзя чинить");
            return;
        }
        if (handitem.getDamage() == 0) {
            player.sendMessage(ChatColor.RED+"Предмет не нуждается в починке");
        }

        if (handitem.hasDamage()) {
            handitem.setDamage(0);
            item.setItemMeta((ItemMeta) handitem);
            player.sendMessage(ChatColor.GOLD + "Был успешно починен предмет : " +ChatColor.RED+ item.getType());
        }
    }

    public void fixAll(Player player) {

        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null) {
                continue;
            }

            if (!(item.getItemMeta() instanceof Damageable)) {
                continue;
            }
            Damageable meta = (Damageable) item.getItemMeta();


            if (meta.hasDamage()) {
                meta.setDamage(0);
                item.setItemMeta((ItemMeta) meta);
                fixeditems.add(item);
            }
        }
        if (fixeditems.isEmpty()){
            player.sendMessage(ChatColor.RED+"Нету предметов для починки");
            return;
        }
        String items = fixeditems.stream()
                .map(item -> item.getType().name())
                .collect(Collectors.joining(", "));
        player.sendMessage(ChatColor.GOLD+"Успешно были починены предметы : "+ChatColor.RED+items);
        fixeditems.clear();
    }
}
