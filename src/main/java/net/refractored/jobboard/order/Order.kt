package net.refractored.jobboard.order

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import org.bukkit.inventory.ItemStack
import java.util.*

@DatabaseTable(tableName = "shuffled_users")
data class order(
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

        @DatabaseField
        var item: ItemStack?

) {
    constructor() : this(UUID.randomUUID(), 0.0, UUID.randomUUID(), null, Date(), ItemStack.empty())
}
