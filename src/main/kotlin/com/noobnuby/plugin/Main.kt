package com.noobnuby.plugin

import com.noobnuby.plugin.command.Start
import com.noobnuby.plugin.events.BreakBlock
import com.noobnuby.plugin.events.Death
import com.noobnuby.plugin.events.JoinQuit
import com.noobnuby.plugin.events.MobSpawn
import com.noobnuby.plugin.init.Schem
import org.bukkit.plugin.java.JavaPlugin

class Main:JavaPlugin() {
    companion object {
        lateinit var instance: Main
            private set
    }

    //TODO : 스코어보드
    //TODO : 킬로그
    override fun onEnable() {
        instance = this
        logger.info("Enable plugin!")
        saveResource("main.schem", false)

        server.pluginManager.apply {
            registerEvents(JoinQuit(),this@Main)
            registerEvents(Death(),this@Main)
            registerEvents(BreakBlock(),this@Main)
            registerEvents(MobSpawn(),this@Main)
            getCommand("start")?.setExecutor(Start())
        }

        Schem().loadSchem()
    }
}