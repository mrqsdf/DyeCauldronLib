package fr.mrqsdf.ressource;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;

public class DyeColorUtils {
    public static final HashMap<Material, int[]> dyeColor = new HashMap<>(){
        {
            put(Material.WHITE_DYE, new int[]{249, 255, 255});
            put(Material.LIGHT_GRAY_DYE, new int[]{156, 157, 151});
            put(Material.GRAY_DYE, new int[]{71, 79, 82});
            put(Material.BLACK_DYE, new int[]{29, 28, 33});
            put(Material.YELLOW_DYE, new int[]{255, 216, 61});
            put(Material.ORANGE_DYE, new int[]{249, 128, 29});
            put(Material.RED_DYE, new int[]{176, 46, 38});
            put(Material.BROWN_DYE, new int[]{130, 84, 50});
            put(Material.LIME_DYE, new int[]{128, 199, 31});
            put(Material.GREEN_DYE, new int[]{93, 124, 21});
            put(Material.LIGHT_BLUE_DYE, new int[]{58, 179, 218});
            put(Material.CYAN_DYE, new int[]{22, 156, 157});
            put(Material.BLUE_DYE, new int[]{60, 68, 169});
            put(Material.PINK_DYE, new int[]{243, 140, 170});
            put(Material.MAGENTA_DYE, new int[]{198, 79, 189});
            put(Material.PURPLE_DYE, new int[]{137, 50, 183});
        }
    };

    public static final ArrayList<Material> dyeMaterial = new ArrayList<>(){
        {
            add(Material.WHITE_DYE);
            add(Material.LIGHT_GRAY_DYE);
            add(Material.GRAY_DYE);
            add(Material.BLACK_DYE);
            add(Material.YELLOW_DYE);
            add(Material.ORANGE_DYE);
            add(Material.RED_DYE);
            add(Material.BROWN_DYE);
            add(Material.LIME_DYE);
            add(Material.GREEN_DYE);
            add(Material.LIGHT_BLUE_DYE);
            add(Material.CYAN_DYE);
            add(Material.BLUE_DYE);
            add(Material.PINK_DYE);
            add(Material.MAGENTA_DYE);
            add(Material.PURPLE_DYE);
        }
    };
    public static final ArrayList<Material> leatherMaterial = new ArrayList<>(){
        {
            add(Material.LEATHER_HELMET);
            add(Material.LEATHER_CHESTPLATE);
            add(Material.LEATHER_LEGGINGS);
            add(Material.LEATHER_BOOTS);
            add(Material.LEATHER_HORSE_ARMOR);
        }
    };


}
