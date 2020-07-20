package com.engine.project.file;

import com.engine.project.file.serializer.Serializer;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.List;

interface Configurable {

    Object get(String path);
    <T> T get(Serializer serializer, Class<? extends T> type, String path);
    Object getOrAbsent(String path, Object value);
    boolean contains(String path);

    int getInt(String path);
    double getDouble(String path);
    String getString(String path);
    List<String> getStringList(String path);
    Location getLocation(String path);
    ItemStack getItemStack(String path);

    void set(String path, Object value);
    void setIfAbsent(String path, Object value);
    void setDefault(String path, Object value);
    void set(Serializer serializer, String path, Object value);

}
