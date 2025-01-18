package com.github.bindglam.npclib;

import com.github.bindglam.npclib.npc.NPC;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class NPCLib extends JavaPlugin {
    private static NPCLib instance;

    private final List<NPC> npcList = new ArrayList<>();

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    public List<NPC> getNpcList() {
        return new ArrayList<>(npcList);
    }

    public static void registerNpc(NPC npc){
        instance.npcList.add(npc);
    }

    public static @NotNull NPCLib getInstance(){
        return instance;
    }
}
