package fr.mrqsdf.dyecauldron.api;

import com.jeff_media.customblockdata.CustomBlockData;
import fr.mrqsdf.dyecauldron.DyeCauldron;
import fr.mrqsdf.dyecauldron.armorstand.SummonArmorstand;
import fr.mrqsdf.dyecauldron.ressource.CauldronData;
import fr.mrqsdf.dyecauldron.ressource.CauldronPersistentDataType;
import jdk.jfr.Description;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.persistence.PersistentDataContainer;

public class DyeCauldronUse {

    /**
     * Dye a cauldron
     * block must be a cauldron
     * color must be a rgb color
     * level must be between 1 and 3
     * @param block
     * @param color
     * @param level
     */
    public static void dyeCauldron(Block block, int color, int level) {
        if (block.getType() != org.bukkit.Material.CAULDRON) throw new IllegalArgumentException("The block must be a cauldron");
        if (level > 3 || level < 1) throw new IllegalArgumentException("The level must be between 1 and 3");
        Location location = block.getLocation();
        location.add(0.5, 0, 0.5);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        PersistentDataContainer persistentDataContainer = new CustomBlockData(block, DyeCauldron.plugin);
        CauldronData cauldronData = new CauldronData();
        if (cauldronData.armorstand.containsKey("armorstandColor")) cauldronData.armorstand.remove("armorstandColor");
        cauldronData.armorstand.putIfAbsent("armorstandColor", SummonArmorstand.summon(location, r, g, b, level).getUniqueId().toString());
        cauldronData.color = color;
        cauldronData.level = level;
        persistentDataContainer.set(new org.bukkit.NamespacedKey(DyeCauldron.plugin, "cauldrondata"), new CauldronPersistentDataType(), cauldronData);
    }
    public static void dyeCauldron(Block block, int r, int g, int b, int level) {
        if (block.getType() != org.bukkit.Material.CAULDRON) throw new IllegalArgumentException("The block must be a cauldron");
        if (level > 3 || level < 1) throw new IllegalArgumentException("The level must be between 1 and 3");
        Location location = block.getLocation();
        location.add(0.5, 0, 0.5);
        PersistentDataContainer persistentDataContainer = new CustomBlockData(block, DyeCauldron.plugin);
        CauldronData cauldronData = new CauldronData();
        if (cauldronData.armorstand.containsKey("armorstandColor")) cauldronData.armorstand.remove("armorstandColor");
        cauldronData.armorstand.putIfAbsent("armorstandColor", SummonArmorstand.summon(location, r, g, b, level).getUniqueId().toString());
        cauldronData.color = Color.fromRGB(r, g, b).asRGB();
        cauldronData.level = level;
        persistentDataContainer.set(new org.bukkit.NamespacedKey(DyeCauldron.plugin, "cauldrondata"), new CauldronPersistentDataType(), cauldronData);
    }
    public static void dyeCauldron(Block block, Color color, int level) {
        if (block.getType() != org.bukkit.Material.CAULDRON) throw new IllegalArgumentException("The block must be a cauldron");
        if (level > 3 || level < 1) throw new IllegalArgumentException("The level must be between 1 and 3");
        Location location = block.getLocation();
        location.add(0.5, 0, 0.5);
        PersistentDataContainer persistentDataContainer = new CustomBlockData(block, DyeCauldron.plugin);
        CauldronData cauldronData = new CauldronData();
        if (cauldronData.armorstand.containsKey("armorstandColor")) cauldronData.armorstand.remove("armorstandColor");
        cauldronData.armorstand.putIfAbsent("armorstandColor", SummonArmorstand.summon(location, color, level).getUniqueId().toString());
        cauldronData.color = color.asRGB();
        cauldronData.level = level;
        persistentDataContainer.set(new org.bukkit.NamespacedKey(DyeCauldron.plugin, "cauldrondata"), new CauldronPersistentDataType(), cauldronData);
    }

}
