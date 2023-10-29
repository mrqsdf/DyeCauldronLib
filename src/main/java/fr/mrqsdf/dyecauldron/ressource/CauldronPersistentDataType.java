package fr.mrqsdf.dyecauldron.ressource;

import org.apache.commons.lang.SerializationUtils;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * this class is a PersistentDataType for the cauldron data
 * this is use in the PersistentDataContainer of the cauldron
 * @see PersistentDataType
 * @see CauldronData
 * @see org.bukkit.persistence.PersistentDataContainer
 */

public class CauldronPersistentDataType implements PersistentDataType<byte[], CauldronData> {

    @Override
    public Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @Override
    public Class<CauldronData> getComplexType() {
        return CauldronData.class;
    }

    @Override
    public byte[] toPrimitive(CauldronData cauldronData, PersistentDataAdapterContext persistentDataAdapterContext) {
        return SerializationUtils.serialize(cauldronData);
    }

    @Override
    public CauldronData fromPrimitive(byte[] bytes, PersistentDataAdapterContext persistentDataAdapterContext) {
        try {
            InputStream inputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            return (CauldronData) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
