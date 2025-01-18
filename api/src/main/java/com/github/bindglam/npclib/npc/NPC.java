package com.github.bindglam.npclib.npc;

import com.github.bindglam.npclib.NPCLib;
import com.github.bindglam.npclib.npc.conversation.Conversation;
import net.citizensnpcs.api.CitizensAPI;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public abstract class NPC {
    private final int npcID;

    protected Sound conversationSound = Sound.sound(Key.key("entity.villager.ambient"), Sound.Source.MASTER, 1f, 1f);

    public NPC(int npcID) {
        this.npcID = npcID;
    }

    public abstract void onRightClick(Player player);

    protected void displayConversation(Player player, Conversation conversation){
        if(conversation.getMessage() != null)
            player.sendMessage(CitizensAPI.getNPCRegistry().getById(npcID).getEntity().name().append(Component.text(": ").color(NamedTextColor.GRAY).append(conversation.getMessage())));
        player.playSound(conversationSound);

        conversation.run(player);
    }

    public void startTalking(Player player){
        player.setMetadata("is-talking", new FixedMetadataValue(NPCLib.getInstance(), true));
    }

    public void stopTalking(Player player){
        Bukkit.getScheduler().runTask(NPCLib.getInstance(), () -> player.removeMetadata("is-talking", NPCLib.getInstance()));
    }

    public int getNpcID() {
        return npcID;
    }
}
