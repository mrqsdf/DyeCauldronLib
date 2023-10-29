package fr.mrqsdf.dyecauldron;

import fr.mrqsdf.dyecauldron.listener.CauldronBreakListener;
import fr.mrqsdf.dyecauldron.listener.CauldronInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DyeCauldron {

    public static JavaPlugin plugin;

    public static boolean isPluginModActive = true;


    /**
     * Set the plugin instance in the main class of your plugin (onEnable() method)
     * and set if you want this only dependency or use equally the plugin mod
     * @param plugin
     * @param isPluginModActive
     */
    public static void setJavaPlugin(JavaPlugin plugin, boolean isPluginModActive) {
        DyeCauldron.plugin = plugin;
        if (isPluginModActive) setPluginModActive();
    }

    private static void setPluginModActive() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new CauldronBreakListener(), plugin);
        pm.registerEvents(new CauldronInteractListener(), plugin);
    }

}
