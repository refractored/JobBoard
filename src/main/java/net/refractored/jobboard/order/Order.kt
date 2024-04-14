package net.refractored.jobboard.order

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.j256.ormlite.field.DataType
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.field.types.LongStringType
import com.j256.ormlite.table.DatabaseTable
import org.bukkit.inventory.ItemStack
import java.util.*

@DatabaseTable(tableName = "jobboard_orders")
data class Order(
        @DatabaseField(id = true)
        val id: UUID,

        @DatabaseField
        var cost: Double,

        @DatabaseField
        var user: UUID,

        @DatabaseField
        var assignee: UUID?,

        @DatabaseField
        var timeCreated: Date,

        @DatabaseField(dataType = DataType.BYTE_ARRAY, columnDefinition = "LONGBLOB")
        var item: ByteArray?

) {
    constructor() : this(UUID.randomUUID(), 0.0, UUID.randomUUID(), null, Date(), null)

        fun serializeItemStack(itemStack: ItemStack): String {
                return Gson().toJson(itemStack.serialize())
        }

        fun deserializeItemStack(serializedItemStack: String): ItemStack {
                val mapType = object : TypeToken<Map<String, Any>>() {}.type
                val itemMap: Map<String, Any> = Gson().fromJson(serializedItemStack, mapType)
                return ItemStack.deserialize(itemMap)
        }
}
