package me.adelch;

import org.bukkit.attribute.Attribute;
import java.util.UUID;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class PalitroqueZeus {

    public static ItemStack getPalitroque() {
        ItemStack palitroque = new ItemStack(Material.MACE);
        ItemMeta meta = palitroque.getItemMeta();

        if (meta != null) {

            Multimap<Attribute, AttributeModifier> modifiers = ArrayListMultimap.create();

            // 2. Definimos el nuevo daño (ejemplo: 15 de daño)
            // Importante: El nombre "amount" es el valor total si la operación es
            // ADD_NUMBER
            AttributeModifier damageModifier = new AttributeModifier(
                    UUID.randomUUID(),
                    "generic.attack_damage",
                    15.0,
                    AttributeModifier.Operation.ADD_NUMBER,
                    EquipmentSlot.HAND // Para que solo funcione cuando se tiene en la mano
            );

            // 3. (Opcional) Definimos la velocidad de ataque
            // Si no haces esto, la maza podría atacar extremadamente lento o rápido
            AttributeModifier speedModifier = new AttributeModifier(
                    UUID.randomUUID(),
                    "generic.attack_speed",
                    -3.5, // Valor típico para herramientas pesadas
                    AttributeModifier.Operation.ADD_NUMBER,
                    EquipmentSlot.HAND);

            // 4. Agregamos los modificadores al Multimap
            modifiers.put(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);
            modifiers.put(Attribute.GENERIC_ATTACK_SPEED, speedModifier);

            meta.setEnchantmentGlintOverride(true);
            meta.setDisplayName("§6Palitroque de Zeus");
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Oculta los atributos para que no se vean en la descripción
            meta.setAttributeModifiers(modifiers);
            meta.setLore(java.util.Arrays.asList("§7Un poderoso palitroque que otorga el poder de Zeus."));
            meta.getPersistentDataContainer().set(PluginKeys.ZEUS_ITEM, PersistentDataType.BYTE, (byte) 1);
            palitroque.setItemMeta(meta); // ¡IMPORTANTE! Aplicamos los cambios al item
        }

        return palitroque;
    }

    public static ShapedRecipe getReceta() {
        ShapedRecipe receta = new ShapedRecipe(PluginKeys.ZEUS_RECIPE, getPalitroque());

        receta.shape(" N ", " N ", " P ");
        receta.setIngredient('N', Material.FLINT_AND_STEEL);
        receta.setIngredient('P', Material.STICK);

        return receta;
    }
}
