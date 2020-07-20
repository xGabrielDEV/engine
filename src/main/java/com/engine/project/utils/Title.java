package com.engine.project.utils;

import net.md_5.bungee.api.chat.BaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Title {

    private final String title;
    private final String subtitle;

    public Title(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public PacketPlayOutTitle[] build() {
        final PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(
                PacketPlayOutTitle.EnumTitleAction.TITLE,
                IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + title +"\"}")
        );
        final PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(
                PacketPlayOutTitle.EnumTitleAction.SUBTITLE,
                IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + subtitle +"\"}")
        );

        return new PacketPlayOutTitle[] { titlePacket, subtitlePacket };
    }

    public void direct(Iterable<? extends Player> players) {
        PacketPlayOutTitle[] packets = build();

        players.forEach(it -> {
            ((CraftPlayer)it).getHandle().playerConnection.sendPacket(packets[0]);
            ((CraftPlayer)it).getHandle().playerConnection.sendPacket(packets[1]);
        });
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
