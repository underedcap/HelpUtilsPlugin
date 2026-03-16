package ru.helputils.Manager;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.util.Set;

public class HealLogic{

    public void healInteract(Player player) {

        Set<PotionEffectType> bads = Set.of(

            PotionEffectType.WEAKNESS,
                PotionEffectType.WITHER,
                PotionEffectType.BLINDNESS,
                PotionEffectType.POISON,
                PotionEffectType.SLOW
        );
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setSaturation(20);

        for (PotionEffectType type : bads) {
            player.removePotionEffect(type);
        }
    }

}
