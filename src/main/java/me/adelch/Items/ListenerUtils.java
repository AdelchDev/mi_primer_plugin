package me.adelch.Items;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.world.TimeSkipEvent;
import org.bukkit.inventory.ItemStack;

public class ListenerUtils implements Listener {

    private final ItemManager manager;

    public ListenerUtils(ItemManager manager) {
        this.manager = manager; // Guardamos lo que recibimos en nuestra variable privada
    }

    @EventHandler
    public void EntityDmgByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player jugador))
            return;

        ItemStack item = jugador.getInventory().getItemInMainHand();

        if (item == null || !item.hasItemMeta())
            return;

        CustomItem arma = manager.getWeapon(item);

        if (arma != null) {
            if (ItemUtils.isAttackFullyCharged(jugador)) {
                arma.onHit(event.getEntity()); 
            }
        }
    }

}
