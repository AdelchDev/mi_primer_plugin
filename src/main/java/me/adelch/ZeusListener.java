package me.adelch;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ZeusListener implements Listener {

    @EventHandler
    public void alGolpear(EntityDamageByEntityEvent event) {
        if (isValidZeusAttack(event)) {
            ejecutarRayo(event.getEntity());
        }
    }

    private boolean isValidZeusAttack(EntityDamageByEntityEvent event) {
        return event.getDamager() instanceof Player jugador 
            && isHoldingPalitroque(jugador) 
            && isAttackFullyCharged(jugador);
    }

    private boolean isHoldingPalitroque(Player p) {
    ItemStack item = p.getInventory().getItemInMainHand();
    return item != null 
        && item.hasItemMeta() 
        && item.getItemMeta().getPersistentDataContainer().has(PluginKeys.ZEUS_ITEM, PersistentDataType.BYTE);
    }

    private boolean isAttackFullyCharged(Player p) {
        return p.getAttackCooldown() >= 1.0f;
    }

    private void ejecutarRayo(org.bukkit.entity.Entity victima) {
        victima.getWorld().strikeLightning(victima.getLocation());
    }
}