package net.refractored.jobboard.database

import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager
import com.j256.ormlite.jdbc.JdbcConnectionSource
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource
import com.j256.ormlite.table.TableUtils
import net.refractored.jobboard.JobBoard
import net.refractored.jobboard.order.Order
import java.util.*

class Database {
    companion object {
        @JvmStatic
        private lateinit var _connectionSource: JdbcConnectionSource

        @JvmStatic
        var connectionSource: JdbcConnectionSource
            get() = _connectionSource
            set(value) {}

        @JvmStatic
        private lateinit var _orderDao: Dao<Order, UUID>

        @JvmStatic
        var userDao: Dao<Order, UUID>
            get() = _orderDao
            set(value) {}

        @JvmStatic
        fun init() {
            _connectionSource = JdbcPooledConnectionSource(
                JobBoard.get().configYml.getString("Database.URL"),
                JobBoard.get().configYml.getString("Database.user"),
                JobBoard.get().configYml.getString("Database.password")
            )

            _orderDao = DaoManager.createDao(connectionSource, Order::class.java) as Dao<Order, UUID>

            TableUtils.createTableIfNotExists(connectionSource, Order::class.java)
        }
    }

}