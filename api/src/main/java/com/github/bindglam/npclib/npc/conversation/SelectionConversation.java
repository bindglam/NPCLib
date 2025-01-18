package com.github.bindglam.npclib.npc.conversation;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.entity.Player;

public abstract class SelectionConversation implements Conversation {
    private final Component[] selections;

    protected SelectionConversation(Component[] selections) {
        this.selections = selections;
    }

    public abstract void onSelect(Player player, int index);

    @Override
    public void run(Player player) {
        Component message = Component.empty();

        for(int i = 0; i < selections.length; i++){
            int finalI = i;
            message = message.append(selections[i].clickEvent(ClickEvent.callback((audience) -> onSelect(player, finalI)))).append(Component.text(" "));
        }
        player.sendMessage(message);
    }
}
