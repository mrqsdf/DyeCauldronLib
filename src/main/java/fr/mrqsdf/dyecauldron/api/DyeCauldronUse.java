package fr.mrqsdf.dyecauldron.api;

import fr.mrqsdf.dyecauldron.armorstand.SummonArmorstand;
import jdk.jfr.Description;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class DyeCauldronUse {

    @Description(
            "Dye a cauldron"
    )
    public static void dyeCauldron(Block block, int color, int level) {
        if (block.getType() != org.bukkit.Material.CAULDRON) throw new IllegalArgumentException("The block must be a cauldron");
        if (level > 3 || level < 1) throw new IllegalArgumentException("The level must be between 1 and 3");
        Location location = block.getLocation();
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        location.setX(location.getX() + 0.5);
        location.setZ(location.getZ() + 0.5);
        SummonArmorstand.summon(location, r, g, b, level);
    }
    public static void dyeCauldron(Block block, int r, int g, int b, int level) {
        if (block.getType() != org.bukkit.Material.CAULDRON) throw new IllegalArgumentException("The block must be a cauldron");
        if (level > 3 || level < 1) throw new IllegalArgumentException("The level must be between 1 and 3");
        Location location = block.getLocation();
        location.setX(location.getX() + 0.5);
        location.setZ(location.getZ() + 0.5);
        SummonArmorstand.summon(location, r, g, b, level);
    }
    public static void dyeCauldron(Block block, Color color, int level) {
        if (block.getType() != org.bukkit.Material.CAULDRON) throw new IllegalArgumentException("The block must be a cauldron");
        if (level > 3 || level < 1) throw new IllegalArgumentException("The level must be between 1 and 3");
        Location location = block.getLocation();
        location.setX(location.getX() + 0.5);
        location.setZ(location.getZ() + 0.5);
        SummonArmorstand.summon(location, color, level);
    }

}
