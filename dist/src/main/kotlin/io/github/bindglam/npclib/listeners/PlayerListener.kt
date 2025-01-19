package io.github.bindglam.npclib.listeners

import com.github.bindglam.npclib.NPCLib
import net.citizensnpcs.api.CitizensAPI
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractAtEntityEvent

class PlayerListener : Listener {
    @EventHandler
    fun onInteractEntity(event: PlayerInteractAtEntityEvent){
        val player = event.player
        val entity = event.rightClicked

        if(entity.hasMetadata("NPC") && !player.hasMetadata("is-talking")){
            val citizensNPC = CitizensAPI.getNPCRegistry().getNPC(entity)

            for(npc in NPCLib.getInstance().npcList){
                if(npc.npcID == citizensNPC.id){
                    npc.startTalking(player)

                    Bukkit.getAsyncScheduler().runNow(NPCLib.getInstance()) { _ ->
                        npc.onRightClick(player)
                    }
                    break
                }
            }
        }
    }
}