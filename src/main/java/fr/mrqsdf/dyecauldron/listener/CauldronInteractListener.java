package fr.mrqsdf.dyecauldron.listener;

import fr.mrqsdf.dyecauldron.DyeCauldron;
import fr.mrqsdf.dyecauldron.armorstand.SummonArmorstand;
import fr.mrqsdf.dyecauldron.ressource.DyeColorUtils;
import jdk.jfr.Description;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.TileState;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataType;

public class CauldronInteractListener implements Listener {



    @Description(
            "When a player interact with a cauldron, the plugin summon an armorstand with the color of the dye in the cauldron"
    )
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if (!DyeCauldron.isPluginModActive) return;
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (event.getHand() != EquipmentSlot.HAND) return;
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (!DyeColorUtils.dyeMaterial.contains(item.getType())) return;
        if (block.getType() == Material.CAULDRON || block.getType() == Material.LAVA_CAULDRON || block.getType() == Material.POWDER_SNOW_CAULDRON) return;
        Levelled cauldron = (Levelled) block.getBlockData();
        TileState tileState = (TileState) block.getState();
        int lvlData = cauldron.getLevel();
        block.setType(Material.CAULDRON);
        if (cauldron.getLevel() == 0) return;
        Location location = block.getLocation();
        location.setX(location.getX() + 0.5);
        location.setZ(location.getZ() + 0.5);
        ArmorStand armorStand = SummonArmorstand.summon(location, DyeColorUtils.dyeColor.get(item.getType())[0],
                DyeColorUtils.dyeColor.get(item.getType())[1],DyeColorUtils.dyeColor.get(item.getType())[2], lvlData);
        tileState.getPersistentDataContainer().set(new NamespacedKey(DyeCauldron.plugin, "armorstand"), PersistentDataType.STRING, armorStand.getUniqueId().toString());
        tileState.getPersistentDataContainer().set(new NamespacedKey(DyeCauldron.plugin, "color"), PersistentDataType.INTEGER_ARRAY,DyeColorUtils.dyeColor.get(item.getType()));
        tileState.getPersistentDataContainer().set(new NamespacedKey(DyeCauldron.plugin, "level"), PersistentDataType.INTEGER, lvlData);
        tileState.update();
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
        ArmorStand armorStand = SummonArmorstand.summon(location, DyeColorUtils.dyeColor.get(item.getType())[0],
                DyeColorUtils.dyeColor.get(item.getType())[1],DyeColorUtils.dyeColor.get(item.getType())[2], lvlData);
        block.setMetadata("armorstand", new FixedMetadataValue(DyeCauldron.plugin, armorStand));
        block.setMetadata("level", new FixedMetadataValue(DyeCauldron.plugin, lvlData));
    }
}
