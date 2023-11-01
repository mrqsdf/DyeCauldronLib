package fr.mrqsdf.dyecauldron.entity;

import fr.mrqsdf.dyecauldron.ressource.ItemPotionUtilities;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.ItemDisplay;

public class SummonItemDisplay {

    public static ItemDisplay summon(Location location, int r, int g, int b, int level) {
        ItemDisplay itemDisplay = location.getWorld().spawn(location, ItemDisplay.class);
        itemDisplay.setGravity(false);
        itemDisplay.setInvulnerable(true);
        if (level == 1) itemDisplay.setItemStack(ItemPotionUtilities.dyeCauldronLevel1(r, g, b));
        if (level == 2) itemDisplay.setItemStack(ItemPotionUtilities.dyeCauldronLevel2(r, g, b));
        if (level == 3) itemDisplay.setItemStack(ItemPotionUtilities.dyeCauldronLevel3(r, g, b));
        itemDisplay.setItemDisplayTransform(ItemDisplay.ItemDisplayTransform.HEAD);
        return itemDisplay;
    }

    public static ItemDisplay summon(Location location, Color color, int level) {
        ItemDisplay itemDisplay = location.getWorld().spawn(location, ItemDisplay.class);
        itemDisplay.setGravity(false);
        itemDisplay.setInvulnerable(true);
        if (level == 1) itemDisplay.setItemStack(ItemPotionUtilities.dyeCauldronLevel1(color.asRGB()));
        if (level == 2) itemDisplay.setItemStack(ItemPotionUtilities.dyeCauldronLevel2(color.asRGB()));
        if (level == 3) itemDisplay.setItemStack(ItemPotionUtilities.dyeCauldronLevel3(color.asRGB()));
        itemDisplay.setItemDisplayTransform(ItemDisplay.ItemDisplayTransform.HEAD);
        return itemDisplay;
    }

}
