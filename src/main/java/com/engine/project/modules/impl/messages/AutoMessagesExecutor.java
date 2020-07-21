package com.engine.project.modules.impl.messages;

import com.engine.project.placeholders.Placeholder;
import com.engine.project.placeholders.PlaceholderContext;
import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AutoMessagesExecutor {

    private final Plugin plugin;
    private final FileConfiguration configuration;

    private final List<Placeholder> placeholders = Lists.newArrayList();

    public AutoMessagesExecutor(Plugin plugin) {
        this.plugin = plugin;
        this.configuration = plugin.getConfig();

        loadPlaceholders();
    }

    public void init() {
        List<String> messages = configuration.getStringList("modules.auto-messages.messages");
        AtomicInteger index = new AtomicInteger(0);

        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> {
            plugin.getLogger().info("Going to broadcast a message...");

            if (index.intValue() >= messages.size()) index.set(0);
            String message = ChatColor.translateAlternateColorCodes('&', messages.get(index.getAndIncrement()));

            Bukkit.getOnlinePlayers().forEach((player) -> {

                PlaceholderContext context = new PlaceholderContext(player, message);

                placeholders.forEach((placeholder) -> {
                    placeholder.getCallback().accept(context);
                });

                player.sendMessage("");
                player.sendMessage(context.getText());
                player.sendMessage("");

                Sound sound; try  {
                    sound = Sound.ENTITY_PLAYER_LEVELUP; // PaperSpigot
                } catch (NoSuchFieldError error) {
                    sound = Sound.valueOf("LEVEL_UP"); // Spigot
                }

                player.playSound(player.getLocation(), sound, 1.0f, 1.0f);
            });
            plugin.getLogger().info("Message sent to " + Bukkit.getOnlinePlayers().size() + " players successfully.");
        }, 20L, (configuration.getLong("modules.auto-messages.delay") * 20));
    }

    private void loadPlaceholders() {
        placeholders.add(new Placeholder("Online Players", (context) -> {
            context.apply("{online}", String.valueOf(Bukkit.getOnlinePlayers().size()));
        }));

        placeholders.add(new Placeholder("Nickname", (context) -> {
            context.apply("{name}", context.getPlayer().getName());
        }));
    }
}
