package fr.mrqsdf.dyecauldron.listener;

import com.jeff_media.customblockdata.CustomBlockData;
import fr.mrqsdf.dyecauldron.DyeCauldron;
import fr.mrqsdf.dyecauldron.armorstand.SummonArmorstand;
import fr.mrqsdf.dyecauldron.ressource.CauldronData;
import fr.mrqsdf.dyecauldron.ressource.CauldronPersistentDataType;
import fr.mrqsdf.dyecauldron.ressource.DyeColorUtils;
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
import org.bukkit.persistence.PersistentDataContainer;

import java.util.Arrays;

public class CauldronInteractListener implements Listener {


    /**
     * When a player interact with a cauldron and a dye, the plugin summon an armorstand with the color of the dye in the cauldron
     */
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (event.getHand() != EquipmentSlot.HAND) return;
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (!DyeColorUtils.dyeMaterial.contains(item.getType())) return;
        if (block.getType() == Material.CAULDRON || block.getType() == Material.LAVA_CAULDRON || block.getType() == Material.POWDER_SNOW_CAULDRON) return;
        PersistentDataContainer persistentDataContainer = new CustomBlockData(block, DyeCauldron.plugin);
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
        CauldronData cauldronData = new CauldronData();
        cauldronData.armorstand.put("armorstandColor", armorStand.getUniqueId().toString());
        cauldronData.color = Color.fromRGB(DyeColorUtils.dyeColor.get(item.getType())[0], DyeColorUtils.dyeColor.get(item.getType())[1], DyeColorUtils.dyeColor.get(item.getType())[2]).asRGB();
        cauldronData.level = lvlData;
        persistentDataContainer.set(new NamespacedKey(DyeCauldron.plugin, "cauldrondata"), new CauldronPersistentDataType(), cauldronData);
    }

    /**
     * When a player interact with a cauldron and a leather armor,
     * the plugin color leather armor with the color of the dye in the cauldron
     * and summon an armorstand with different level
     */
    @EventHandler
    public void onInteractArmor(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (block == null) return;
        if (!DyeColorUtils.leatherMaterial.contains(item.getType())) return;
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) item.getItemMeta();
        PersistentDataContainer persistentDataContainer = new CustomBlockData(block, DyeCauldron.plugin);
        if (!persistentDataContainer.has(new NamespacedKey(DyeCauldron.plugin, "cauldrondata"), new CauldronPersistentDataType())) return;
        CauldronData cauldronData = persistentDataContainer.get(new NamespacedKey(DyeCauldron.plugin, "cauldrondata"), new CauldronPersistentDataType());
        assert cauldronData != null;
        int lvlData = cauldronData.level;
        if (lvlData == 0) return;
        itemMeta.setColor(Color.fromRGB(DyeColorUtils.dyeColor.get(item.getType())[0], DyeColorUtils.dyeColor.get(item.getType())[1], DyeColorUtils.dyeColor.get(item.getType())[2]));
        ArmorStand previousArmorStand = cauldronData.getArmorstand("armorstandColor");
        previousArmorStand.remove();
        lvlData--;
        if (lvlData == 0) {
            persistentDataContainer.remove(new NamespacedKey(DyeCauldron.plugin, "cauldrondata"));
            return;
        }
        Location location = block.getLocation();
        location.add(0.5,0,0.5);
        ArmorStand armorStand = SummonArmorstand.summon(location, DyeColorUtils.dyeColor.get(item.getType())[0],
                DyeColorUtils.dyeColor.get(item.getType())[1],DyeColorUtils.dyeColor.get(item.getType())[2], lvlData);
        cauldronData.armorstand.replace("armorstandColor", armorStand.getUniqueId().toString());
        cauldronData.level = lvlData;
        persistentDataContainer.set(new NamespacedKey(DyeCauldron.plugin, "cauldrondata"), new CauldronPersistentDataType(), cauldronData);
    }
}
