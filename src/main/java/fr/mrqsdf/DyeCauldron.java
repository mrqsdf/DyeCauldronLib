package fr.mrqsdf;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class DyeCauldron {

    public static JavaPlugin plugin;

    public static void setJavaPlugin(JavaPlugin plugin) {
        DyeCauldron.plugin = plugin;
    }

    public void test(){
        ItemStack item = new ItemStack(Material.WHITE_DYE);
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
        potionMeta.setColor(Color.fromRGB(255, 0, 0));
    }

}
