package com.engine.project.file;

import com.engine.project.file.serializer.ItemSerializer;
import com.engine.project.file.serializer.LocationSerializer;
import com.engine.project.file.serializer.Serializer;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.List;

public class CustomFile implements Configurable {

    private final JavaPlugin plugin;
    private final String fileName;
    private final FileConfiguration file;

    @Nullable
    private final String filePath;

    public CustomFile(@NotNull JavaPlugin plugin, @NotNull String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;
        this.filePath = null;

        this.file = load();
    }

    public CustomFile(@NotNull JavaPlugin plugin, @NotNull String fileName, String filePath) {
        this.plugin = plugin;
        this.fileName = fileName;
        this.filePath = filePath;

        this.file = load();
    }

    private FileConfiguration load() {
        System.out.printf("Loaded %s file", fileName);
        
        return YamlConfiguration.loadConfiguration(getFile());
    }

    private void save() {
        try {
            file.save(getFile());
        } catch (Exception e) {
            e.printStackTrace();

            System.out.printf("Couldn't save %s!", fileName);
        }
    }

    private File getFile() {
        File dataFolder = plugin.getDataFolder();

        if (!dataFolder.exists()) dataFolder.mkdir();

        return filePath == null ?
                new File(dataFolder, fileName) :
                new File(dataFolder.getAbsolutePath() + filePath, fileName);
    }

    @Override
    public Object get(String path) {
        return file.get(path);
    }

    @Override
    public <T> T get(Serializer serializer, Class<? extends T> type, String path) {
        return serializer.deserialize(type, get(path).toString());
    }

    @Override
    public Object getOrAbsent(String path, Object value) {
        return contains(path) ? get(path) : value;
    }

    @Override
    public boolean contains(String path) {
        return file.contains(path);
    }

    @Override
    public int getInt(String path) {
        return Integer.parseInt(get(path).toString());
    }

    @Override
    public double getDouble(String path) {
        return Double.parseDouble(get(path).toString());
    }

    @Override
    public String getString(String path) {
        return get(path).toString();
    }

    @Override
    public List<String> getStringList(String path) {
        return file.getStringList(path);
    }

    @Override
    public Location getLocation(String path) {
        return get(new LocationSerializer(), Location.class, path);
    }

    @Override
    public ItemStack getItemStack(String path) {
        return get(new ItemSerializer(), ItemStack.class, path);
    }

    @Override
    public void set(String path, Object value) {
        file.set(path, value);

        save();
    }

    @Override
    public void setIfAbsent(String path, Object value) {
        if (!contains(path)) set(path, value);
    }

    @Override
    public void setDefault(String path, Object value) {
        if (!contains(path)) set(path, value);
    }

    @Override
    public void set(Serializer serializer, String path, Object value) {
        set(path, serializer.serialize(value));
    }

}
