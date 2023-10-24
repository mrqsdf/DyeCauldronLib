package fr.mrqsdf.armorstand;

import fr.mrqsdf.ressource.ItemPotionUtilities;
import jdk.jfr.Description;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class SummonArmorstand {

    @Description(
            "Summon an armorstand with the color of the dye in the cauldron"
    )

    public static ArmorStand summon(Location location, int r, int g, int b, int level) {
        ArmorStand armorStand = location.getWorld().spawn(location, ArmorStand.class);
        armorStand.setGravity(false);
        armorStand.setInvulnerable(true);
        armorStand.setInvisible(true);
        armorStand.setBasePlate(false);
        armorStand.setSmall(true);
        if (level == 1) armorStand.setHelmet(ItemPotionUtilities.dyeCauldronLevel1(r, g, b));
        if (level == 2) armorStand.setHelmet(ItemPotionUtilities.dyeCauldronLevel2(r, g, b));
        if (level == 3) armorStand.setHelmet(ItemPotionUtilities.dyeCauldronLevel3(r, g, b));
        return armorStand;
    }
    public static ArmorStand summon(Location location, Color color, int level) {
        ArmorStand armorStand = location.getWorld().spawn(location, ArmorStand.class);
        armorStand.setGravity(false);
        armorStand.setInvulnerable(true);
        armorStand.setInvisible(true);
        armorStand.setBasePlate(false);
        armorStand.setSmall(true);
        if (level == 1) armorStand.setHelmet(ItemPotionUtilities.dyeCauldronLevel1(color.asRGB()));
        if (level == 2) armorStand.setHelmet(ItemPotionUtilities.dyeCauldronLevel2(color.asRGB()));
        if (level == 3) armorStand.setHelmet(ItemPotionUtilities.dyeCauldronLevel3(color.asRGB()));
        return armorStand;
    }

}
