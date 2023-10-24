package fr.mrqsdf.listener;

import fr.mrqsdf.DyeCauldron;
import jdk.jfr.Description;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class CauldronBreakListener implements Listener {

    @Description(
            "When a player break a cauldron, the plugin remove the armorstand"
    )

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (!DyeCauldron.isPluginModActive) return;
        Block block = event.getBlock();
        if (block.getType() != Material.CAULDRON) return;
        if (!block.hasMetadata("armorstand")) return;
        ArmorStand armorStand = (ArmorStand) block.getMetadata("armorstand").get(0).value();
        assert armorStand != null;
        armorStand.remove();
        block.removeMetadata("armorstand", DyeCauldron.plugin);
        block.removeMetadata("color", DyeCauldron.plugin);
        block.removeMetadata("level", DyeCauldron.plugin);
    }

}
