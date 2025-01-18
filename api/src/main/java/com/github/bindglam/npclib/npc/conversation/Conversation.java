package com.github.bindglam.npclib.npc.conversation;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public interface Conversation {
    default void run(Player player){
    }

    @Nullable Component getMessage();
}
