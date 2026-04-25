package me.adelch.Items.Trinkets;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LootingTrinket {
    
    public void applyEffect(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 1, false, false, true));
    }

}
