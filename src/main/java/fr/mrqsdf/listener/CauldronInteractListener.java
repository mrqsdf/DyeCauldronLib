package fr.mrqsdf.listener;

import fr.mrqsdf.DyeCauldron;
import fr.mrqsdf.armorstand.SummonArmorstand;
import fr.mrqsdf.ressource.DyeColorUtils;
import jdk.jfr.Description;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;

public class CauldronInteractListener implements Listener {



    @Description(
            "When a player interact with a cauldron, the plugin summon an armorstand with the color of the dye in the cauldron"
    )
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if (!DyeCauldron.isPluginModActive) return;
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (!DyeColorUtils.dyeMaterial.contains(item.getType())) return;
        Levelled cauldron = (Levelled) block.getBlockData();
        int lvlData = cauldron.getLevel();
        if (lvlData == 0) return;
        cauldron.setLevel(0);
        Location location = block.getLocation();
        location.setX(location.getX() + 0.5);
        location.setZ(location.getZ() + 0.5);
        ArmorStand armorStand = SummonArmorstand.summon(block.getLocation(), DyeColorUtils.dyeColor.get(item.getType())[0],
                DyeColorUtils.dyeColor.get(item.getType())[1],DyeColorUtils.dyeColor.get(item.getType())[2], lvlData);
        block.setMetadata("armorstand", new FixedMetadataValue(DyeCauldron.plugin, armorStand));
        block.setMetadata("color", new FixedMetadataValue(DyeCauldron.plugin, DyeColorUtils.dyeColor.get(item.getType())));
        block.setMetadata("level", new FixedMetadataValue(DyeCauldron.plugin, lvlData));
    }

    @Description(
            "When a player interact with a cauldron and a leather armor, the plugin summon an armorstand with the color of the dye in the cauldron"
    )
    @EventHandler
    public void onInteractArmor(PlayerInteractEvent event){
        if (!DyeCauldron.isPluginModActive) return;
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (!DyeColorUtils.leatherMaterial.contains(item.getType())) return;
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) item.getItemMeta();
        if (!block.hasMetadata("armorstand")) return;
        int lvlData = block.getMetadata("level").get(0).asInt();
        if (lvlData == 0) return;
        itemMeta.setColor(Color.fromRGB(DyeColorUtils.dyeColor.get(item.getType())[0], DyeColorUtils.dyeColor.get(item.getType())[1], DyeColorUtils.dyeColor.get(item.getType())[2]));
        ArmorStand previousArmorStand = (ArmorStand) block.getMetadata("armorstand").get(0).value();
        previousArmorStand.remove();
        block.removeMetadata("armorstand", DyeCauldron.plugin);
        block.removeMetadata("level", DyeCauldron.plugin);
        lvlData--;
        if (lvlData == 0) {
            block.removeMetadata("color", DyeCauldron.plugin);
            return;
        }
        Location location = block.getLocation();
        location.setX(location.getX() + 0.5);
        location.setZ(location.getZ() + 0.5);
        ArmorStand armorStand = SummonArmorstand.summon(block.getLocation(), DyeColorUtils.dyeColor.get(item.getType())[0],
                DyeColorUtils.dyeColor.get(item.getType())[1],DyeColorUtils.dyeColor.get(item.getType())[2], lvlData);
        block.setMetadata("armorstand", new FixedMetadataValue(DyeCauldron.plugin, armorStand));
        block.setMetadata("level", new FixedMetadataValue(DyeCauldron.plugin, lvlData));
    }
}
