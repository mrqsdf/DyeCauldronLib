package fr.mrqsdf.dyecauldron.ressource;

import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * this class is a data class for the cauldron
 * @see CauldronPersistentDataType
 */

public class CauldronData implements Serializable {

    /**
     * this is a map of the armorstand in the cauldron
     * the first string is the data name of the armorstand
     * the second string is the armorstand uuid
     *
     * /!\ please set only armorstand uuid in this map
     */
    public Map<String, String > armorstand = new HashMap<>();

    /**
     * color of the cauldron in RGB complete format
     */
    public int color;
    /**
     * level of the cauldron
     */
    public int level;
    /**
     * map of another object in the cauldron
     * the first string is the data name of the object
     * the second object is the object
     */
    public Map<String ,Object> objects = new HashMap<>();

    /**
     * get the armorstand
     */
    public ArmorStand getArmorstand(String name) {
        return (ArmorStand) Bukkit.getEntity(UUID.fromString(armorstand.get(name)));
    }

}
