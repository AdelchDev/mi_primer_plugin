package me.adelch.Items.Trinkets;

import me.adelch.App;
import me.adelch.PluginKeys;
import me.adelch.Items.ItemUtils;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class AttackBoost extends CustomTrinket {


    public AttackBoost() {
        super(PluginKeys.ATTACK_SPEED_KEY, Material.CLOCK, "Attack Boost", TrinketTierType.LEGENDARY,
                EquipmentSlotGroup.OFFHAND, EquipmentSlotGroup.MAINHAND);
    }

    @Override
    public ItemStack createItem() {
        ItemStack item = new ItemStack(this.material);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            ItemUtils.setAttributePorcentaje(meta, this.key, this.tipo.getBoost(),
                    Attribute.GENERIC_ATTACK_SPEED, this.slot);

            ItemUtils.setAttributePorcentaje(meta, this.key, this.tipo.getBoost(),
                    Attribute.GENERIC_MOVEMENT_SPEED, this.Activa);

            ItemUtils.setName(meta, this.name, this.tipo.getColor(), true, false, false, false);
            ItemUtils.setLore(meta,
                    "<gradient:green:#00ff00>Un poderoso boost de ataque.</gradient>",
                    "",
                    "<gray>• Podrás librar batallas a una velocidad vertiginosa",
                    "<gray>• Nadie te verá venir",
                    "<gray>• El poder de la velocidad en tus manos");

            ItemUtils.setAddItemFlags(meta, ItemFlag.HIDE_ATTRIBUTES);
            ItemUtils.setSetEnchantmentGlintOverride(meta, true);
            ItemUtils.setPDC(meta, this.key);

            item.setItemMeta(meta);
        }
        return item;
    }

    @Override
    public void onHit(Entity victim) {
        accelerateTime(victim.getWorld());
    }

    @Override
    public ShapedRecipe getRecipe() {
        ShapedRecipe receta = new ShapedRecipe(PluginKeys.ATTACK_SPEED_RECIPE, createItem());
        receta.shape("NNN", "NPN", "NNN");
        receta.setIngredient('N', Material.BLAZE_POWDER);
        receta.setIngredient('P', this.material);
        return receta;
    }

    private void accelerateTime(World world) {
        long currentTime = world.getTime();
        final long targetTime;

        if (currentTime < 6000) {
            targetTime = 6000;
        } else if (currentTime < 18000) {
            targetTime = 18000;
        } else {
            targetTime = 24000;
        }

        new BukkitRunnable() {
            long velocidad = 10;

            @Override
            public void run() {
                long now = world.getTime();

                if (targetTime == 24000 && now < 1000 && now >= 0 && velocidad > 100) {
                    world.setTime(0);
                    this.cancel();
                    return;
                }

                velocidad += 50;

                long nextTime = now + velocidad;

                if (nextTime >= targetTime) {
                    world.setTime(targetTime == 24000 ? 0 : targetTime);
                    this.cancel(); 
                } else {
                    world.setTime(nextTime);
                }
            }
        }.runTaskTimer(App.getInstance(), 0L, 1L);
    }
}