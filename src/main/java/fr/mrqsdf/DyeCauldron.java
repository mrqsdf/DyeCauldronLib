package fr.mrqsdf;

import org.bukkit.plugin.java.JavaPlugin;

public class DyeCauldron {

    public static JavaPlugin plugin;

    public static boolean isPluginModActive = true;

    public static void setJavaPlugin(JavaPlugin plugin) {
        DyeCauldron.plugin = plugin;
    }
    public static void setPluginModActive(boolean isPluginModActive) {
        DyeCauldron.isPluginModActive = isPluginModActive;
    }

}
