package net.refractored.jobboard

import com.j256.ormlite.jdbc.JdbcConnectionSource
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import com.willfp.eco.core.EcoPlugin
import net.refractored.jobboard.order.order


class JobBoard : EcoPlugin() {

    private lateinit var connectionSource: ConnectionSource

    override fun handleEnable() {
        setInstance(this)
        connectToDatabase()
        createTables()
    }

    override fun handleDisable() {


    }

    private fun connectToDatabase() {
        val databaseUrl = configYml.getString("database.URL")
        val username = configYml.getString("database.user")
        val password = configYml.getString("database.password")
        connectionSource = JdbcConnectionSource(databaseUrl, username, password)
    }
    private fun createTables() {
        TableUtils.createTableIfNotExists(connectionSource, order::class.java)
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
