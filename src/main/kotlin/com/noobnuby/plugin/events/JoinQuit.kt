package com.noobnuby.plugin.events

import com.noobnuby.plugin.scoreboard.ScoreBorad
import net.kyori.adventure.text.Component
import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinQuit: Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val p = e.player
        e.joinMessage(Component.text(""))
        p.teleport(Location(p.world,0.0,150.0,0.0))
        e.player.setBedSpawnLocation(Location(p.world,0.0,150.0,0.0),true)
        ScoreBorad().showScoreboard(p)
    }

    @EventHandler
    fun onQuit(e: PlayerQuitEvent) {
        e.quitMessage(Component.text(""))
    }
}