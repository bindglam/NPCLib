package io.github.bindglam.npclib

import com.github.bindglam.npclib.NPCLib
import io.github.bindglam.npclib.listeners.PlayerListener

class NPCLibImpl : NPCLib() {
    override fun onEnable() {
        server.pluginManager.registerEvents(PlayerListener(), this)
    }

    override fun onDisable() {
    }
}