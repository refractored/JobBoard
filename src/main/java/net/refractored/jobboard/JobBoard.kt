package net.refractored.jobboard

import com.willfp.eco.core.EcoPlugin
import net.refractored.jobboard.commands.OrderCreate
import net.refractored.jobboard.database.Database
import revxrsal.commands.bukkit.BukkitCommandHandler


class JobBoard : EcoPlugin() {
    lateinit var handler: BukkitCommandHandler

    override fun handleEnable() {
        setInstance(this)
        logger.info("Connecting to database")
        Database.init()

        //Register commands
        handler = BukkitCommandHandler.create(this)
        handler.register(OrderCreate())
        handler.registerBrigadier()
    }

    override fun handleDisable() {


    }

    override fun handleReload() {

    }

    companion object {
        private lateinit var instance: JobBoard

        fun get(): JobBoard {
            return instance
        }

        private fun setInstance(instance: JobBoard) {
            this.instance = instance
        }
    }

}
