package fr.mrqsdf.dyecauldron.ressource;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

public class ItemPotionUtilities {

    public static ItemStack dyeCauldronLevel1(int rgb){
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
        potionMeta.setColor(Color.fromRGB(rgb));
        potionMeta.setCustomModelData(531001);
        item.setItemMeta(potionMeta);
        return item;
    }
    public static ItemStack dyeCauldronLevel2(int rgb){
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
        potionMeta.setColor(Color.fromRGB(rgb));
        potionMeta.setCustomModelData(531002);
        item.setItemMeta(potionMeta);
        return item;
    }
    public static ItemStack dyeCauldronLevel3(int rgb){
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
        potionMeta.setColor(Color.fromRGB(rgb));
        potionMeta.setCustomModelData(531003);
        item.setItemMeta(potionMeta);
        return item;
    }

    public static ItemStack dyeCauldronLevel1(int r, int g, int b){
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
        potionMeta.setColor(Color.fromRGB(r, g, b));
        potionMeta.setCustomModelData(531001);
        item.setItemMeta(potionMeta);
        return item;
    }
    public static ItemStack dyeCauldronLevel2(int r, int g, int b){
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
        potionMeta.setColor(Color.fromRGB(r, g, b));
        potionMeta.setCustomModelData(531002);
        item.setItemMeta(potionMeta);
        return item;
    }
    public static ItemStack dyeCauldronLevel3(int r, int g, int b){
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
        potionMeta.setColor(Color.fromRGB(r, g, b));
        potionMeta.setCustomModelData(531003);
        item.setItemMeta(potionMeta);
        return item;
    }

}
