package net.refractored.jobboard

import com.willfp.eco.core.EcoPlugin


class JobBoard : EcoPlugin() {
    override fun handleEnable() {
        setInstance(this)
    }

    override fun handleDisable() {
        // Plugin shutdown logic
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
